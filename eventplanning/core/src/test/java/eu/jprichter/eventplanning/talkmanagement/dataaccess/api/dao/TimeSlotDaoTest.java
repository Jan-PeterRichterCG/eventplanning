package eu.jprichter.eventplanning.talkmanagement.dataaccess.api.dao;

import java.time.Instant;
import java.util.TimeZone;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eu.jprichter.eventplanning.EventplanningApp;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TimeSlotEntity;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * Test the TimeSlotDao and first of all the mapping of the {@link Instant}s 'start' and 'end' therein.
 *
 * @author jrichter
 * @since 0.0.1
 */
@Transactional
@SpringApplicationConfiguration(classes = { EventplanningApp.class })
public class TimeSlotDaoTest extends ComponentTest {

  private static Logger LOG = Logger.getLogger(TimeSlotDaoTest.class);

  /**
   *
   * This constructor is necessary in order to set the JVM's time zone to UTC so that the mapping of java.time.Instant
   * <-> SQL TIMESTAMP works properly
   *
   * This code is left here intentionally so that it is not forgotten that the hibernate mapping is actually broken
   */
  public TimeSlotDaoTest() {
    super();

    LOG.debug("XXX set default time zone to UTC");

    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

  }

  @Inject
  TimeSlotDaoTestHelper timeSlotDaoTestHelper;

  /**
   * Tests whether {@link Instant}s can be stored and read back that are at the switching hours of daylight saving time.
   * The start of the {@TimeSlot} is '2016-03-27 02:30:00.000Z'. The point in time '2016-03-27 02:30:00.000' (without Z)
   * does not exists in time zone 'Europe/Berlin': daylight saving time starts at '2016-03-27 02:00:00.000' and clocks
   * are set to '2016-03-27 03:00:00.000' immediately. The end of the {@TimeSlot} is '2016-10-30 03:30:00.000Z'. The
   * point in time '2016-10-30 03:30:00.000' (without Z) is ambiguous in time zone 'Europe/Berlin': daylight saving time
   * ends at '2016-10-30 03:00:00.000' and clocks are set back to '2016-03-27 02:00:00.000'.
   *
   * Actually, a whole sequence of {@link TimeSlotEntity}s are written to the database.
   *
   * NOTE: This test is not actually free of side effects since it leaves a {{@link TimeSlotEntity} in the table if it
   * fails. Also the sequence counter for IDs is increased.
   */
  @Test
  @Transactional(propagation = Propagation.REQUIRED)
  public void testDaylightSavingTimeSwitchReadback() {

    Instant start = Instant.parse("2016-03-26T12:30:00.000Z");
    Instant end = Instant.parse("2016-10-29T12:30:00.000Z");

    for (int i = 0; i < 24; i++) {
      TimeSlotEntity timeSlot = new TimeSlotEntity();
      timeSlot.setStart(start);
      timeSlot.setEnd(end);

      // write the TimeSlotEntity to the table in a separate transaction
      TimeSlotEntity savedTimeSlot = this.timeSlotDaoTestHelper.saveTimeSlot(timeSlot);

      assertThat(timeSlot.getStart()).isEqualTo(savedTimeSlot.getStart());
      assertThat(timeSlot.getEnd()).isEqualTo(savedTimeSlot.getEnd());

      // read back the TimeSlotEntity from the table in a separate transaction
      TimeSlotEntity readTimeSlot = this.timeSlotDaoTestHelper.readTimeSlot(timeSlot.getId());

      LOG.debug("XXX saved start: " + savedTimeSlot.getStart() + " end: " + savedTimeSlot.getEnd());
      LOG.debug("XXX read start: " + readTimeSlot.getStart() + " end: " + readTimeSlot.getEnd());

      assertThat(savedTimeSlot.getStart()).isEqualTo(readTimeSlot.getStart());
      assertThat(savedTimeSlot.getEnd()).isEqualTo(readTimeSlot.getEnd());

      // delete the TimeSlotEntity from the table in a separate transaction
      this.timeSlotDaoTestHelper.deleteTimeSlot(timeSlot.getId());

      start = Instant.ofEpochSecond(start.getEpochSecond() + 3600);
      end = Instant.ofEpochSecond(end.getEpochSecond() + 3600);
    }
  }

}
