package eu.jprichter.eventplanning.talkmanagement.logic.api.usecase;

import java.util.List;

import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

public interface UcFindTimeSlot {

  /**
   * Returns a TimeSlot by its id 'id'.
   *
   * @param id The id 'id' of the TimeSlot.
   * @return The {@link TimeSlotEto} with id 'id'
   */
  TimeSlotEto findTimeSlot(Long id);

  /**
   * Returns a paginated list of TimeSlots matching the search criteria.
   *
   * @param criteria the {@link TimeSlotSearchCriteriaTo}.
   * @return the {@link List} of matching {@link TimeSlotEto}s.
   */
  PaginatedListTo<TimeSlotEto> findTimeSlotEtos(TimeSlotSearchCriteriaTo criteria);

}
