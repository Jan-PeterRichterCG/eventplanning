package eu.jprichter.eventplanning.talkmanagement.common.api;

import java.time.Instant;

import eu.jprichter.eventplanning.general.common.api.ApplicationEntity;

/**
 * The {@link TimeSlot} defines the time when {@link Talk}s are presented. The {@link TimeSlot} has a start and end
 * (with a date and a time each) in local time.
 *
 * @author jrichter
 * @since 0.0.1
 */
public interface TimeSlot extends ApplicationEntity {

  /**
   * @return start
   */
  public Instant getStart();

  /**
   * @param start new value of {@link #getStart}.
   */
  public void setStart(Instant start);

  /**
   * @return end
   */
  public Instant getEnd();

  /**
   * @param end new value of {@link #getEnd}.
   */
  public void setEnd(Instant end);

}
