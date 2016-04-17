package eu.jprichter.eventplanning.talkmanagement.logic.api.usecase;

import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotEto;

/**
 * Interface of UcManageTimeSlot to centralize documentation and signatures of methods.
 */
public interface UcManageTimeSlot {

  /**
   * Deletes a timeSlot from the database by its id 'timeSlotId'.
   *
   * @param timeSlotId Id of the timeSlot to delete
   * @return boolean <code>true</code> if the timeSlot can be deleted, <code>false</code> otherwise
   */
  boolean deleteTimeSlot(Long timeSlotId);

  /**
   * Saves a timeSlot and store it in the database.
   *
   * @param timeSlot the {@link TimeSlotEto} to create.
   * @return the new {@link TimeSlotEto} that has been saved with ID and version.
   */
  TimeSlotEto saveTimeSlot(TimeSlotEto timeSlot);

}
