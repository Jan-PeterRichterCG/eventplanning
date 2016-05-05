package eu.jprichter.eventplanning.talkmanagement.dataaccess.api;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.jprichter.eventplanning.general.dataaccess.api.ApplicationPersistenceEntity;
import eu.jprichter.eventplanning.talkmanagement.common.api.TimeSlot;

/**
 * This type implements the {@link TimeSlot} as a persistent entity.
 *
 * @author jrichter
 * @since 0.0.1
 */
@Entity
@Table(name = "TimeSlot")
public class TimeSlotEntity extends ApplicationPersistenceEntity implements TimeSlot {

  private static final Logger LOG = LoggerFactory.getLogger(TimeSlotEntity.class);

  private static final long serialVersionUID = 1L;

  private Instant start;

  private Instant end;

  /**
   * {@inheritDoc}
   */
  @Override
  @Column(name = "FOO")
  public Instant getStart() {

    return this.start;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setStart(Instant start) {

    LOG.debug("XXX Instant start set to: " + start);

    this.start = start;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @Column(name = "BAR")
  public Instant getEnd() {

    return this.end;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEnd(Instant end) {

    LOG.debug("XXX Instant end set to: " + end);

    this.end = end;
  }

}
