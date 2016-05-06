package eu.jprichter.eventplanning.talkmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import eu.jprichter.eventplanning.general.dataaccess.api.ApplicationPersistenceEntity;
import eu.jprichter.eventplanning.talkmanagement.common.api.Event;
import eu.jprichter.eventplanning.talkmanagement.common.api.Talk;
import eu.jprichter.eventplanning.talkmanagement.common.api.TimeSlot;

/**
 * This type implements the {@link Event} as a persistent entity.
 *
 * @author jrichter
 * @since 0.0.1
 */
@Entity
@Table(name = "Event")
public class EventEntity extends ApplicationPersistenceEntity implements Event {

  private static final long serialVersionUID = 1L;

  private Talk talk;

  private TimeSlot timeSlot;

  /**
   * {@inheritDoc}
   */
  @Override
  @ManyToOne
  @JoinColumn(name = "TALK")
  public Talk getTalk() {

    return this.talk;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTalk(Talk talk) {

    this.talk = talk;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  @ManyToOne
  @JoinColumn(name = "TIMESLOT")
  public TimeSlot getTimeSlot() {

    return this.timeSlot;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTimeSlot(TimeSlot timeSlot) {

    this.timeSlot = timeSlot;
  }

}
