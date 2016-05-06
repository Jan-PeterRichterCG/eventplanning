package eu.jprichter.eventplanning.talkmanagement.common.api;

import eu.jprichter.eventplanning.general.common.api.ApplicationEntity;

/**
 * The {@Link Event} is a talk that is held at an actual time slot. It is the central entity of the event planning.
 *
 * @author jrichter
 * @since 0.0.1
 */
public interface Event extends ApplicationEntity {

  /**
   * @return the {@link Talk} held in the event
   */
  public Talk getTalk();

  /**
   * @param talk the {@link Talk} to be held in the event
   */
  public void setTalk(Talk talk);

  /**
   * @return the {@link TimeSlot} when the event takes place
   */
  public TimeSlot getTimeSlot();

  /**
   * @param timeSlot the {@link TimeSlot} when the event is to take place
   */
  public void setTimeSlot(TimeSlot timeSlot);

}
