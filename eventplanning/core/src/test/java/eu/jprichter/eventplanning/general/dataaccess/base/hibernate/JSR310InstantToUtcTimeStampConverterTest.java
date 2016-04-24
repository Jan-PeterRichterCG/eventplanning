package eu.jprichter.eventplanning.general.dataaccess.base.hibernate;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.AttributeConverter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Module tests for {@link JSR310InstantToUtcTimeStampConverter}.
 *
 * @author jrichter
 * @since 0.0.1
 */
public class JSR310InstantToUtcTimeStampConverterTest {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(JSR310InstantToUtcTimeStampConverterTest.class);

  /**
   *
   * test whether the converter can correctly convert a timestamp from the night of the start of the daylight saving
   * time.
   */
  @Test
  public void testConvertTimestampFromDaylightSavingTimeStartToInstant() {

    // daylight saving time in Germany started on March, 27th 02:00 - so there was no time 02:30 in MET or MEST!
    ZonedDateTime zonedDateTime = ZonedDateTime.of(2016, 03, 27, 2, 30, 42, 123000000, ZoneId.of("UTC"));
    LOG.debug("zonedDateTime: " + zonedDateTime);
    LocalDateTime localDateTime = LocalDateTime.from(zonedDateTime);
    LOG.debug("localDateTime: " + localDateTime);
    Timestamp timestamp = Timestamp.valueOf(localDateTime);
    LOG.debug("Timestamp: " + timestamp);

    AttributeConverter<Instant, Timestamp> converter = new JSR310InstantToUtcTimeStampConverter();
    Instant convertedInstant = converter.convertToEntityAttribute(timestamp);

    Instant targetInstant = Instant.parse("2016-03-27T02:30:42.123Z");
    assertThat(convertedInstant).isNotNull();
    assertThat(convertedInstant).isEqualTo(targetInstant);
  }
}
