package eu.jprichter.eventplanning.talkmanagement.logic.base.usecase;

import javax.inject.Inject;

import eu.jprichter.eventplanning.general.logic.base.AbstractUc;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.dao.TimeSlotDao;

/**
 * Abstract use case for TimeSlots, which provides access to the commonly necessary data access objects.
 */
public class AbstractTimeSlotUc extends AbstractUc {

  /** @see #getTimeSlotDao() */
  private TimeSlotDao timeSlotDao;

  /**
   * Returns the field 'timeSlotDao'.
   * 
   * @return the {@link TimeSlotDao} instance.
   */
  public TimeSlotDao getTimeSlotDao() {

    return this.timeSlotDao;
  }

  /**
   * Sets the field 'timeSlotDao'.
   * 
   * @param timeSlotDao New value for timeSlotDao
   */
  @Inject
  public void setTimeSlotDao(TimeSlotDao timeSlotDao) {

    this.timeSlotDao = timeSlotDao;
  }

}
