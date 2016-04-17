package eu.jprichter.eventplanning.talkmanagement.dataaccess.api.dao;

import eu.jprichter.eventplanning.general.dataaccess.api.dao.ApplicationDao;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TimeSlotEntity;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for TimeSlot entities
 */
public interface TimeSlotDao extends ApplicationDao<TimeSlotEntity> {

  /**
   * Finds the {@link TimeSlotEntity timeslots} matching the given {@link TimeSlotSearchCriteriaTo}.
   *
   * @param criteria is the {@link TimeSlotSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link TimeSlotEntity} objects.
   */
  PaginatedListTo<TimeSlotEntity> findTimeSlots(TimeSlotSearchCriteriaTo criteria);
}
