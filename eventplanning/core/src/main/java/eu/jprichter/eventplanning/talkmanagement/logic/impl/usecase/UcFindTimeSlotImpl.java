package eu.jprichter.eventplanning.talkmanagement.logic.impl.usecase;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import eu.jprichter.eventplanning.general.logic.api.UseCase;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TimeSlotEntity;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotSearchCriteriaTo;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcFindTimeSlot;
import eu.jprichter.eventplanning.talkmanagement.logic.base.usecase.AbstractTimeSlotUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting TimeSlots
 */
@Named
@UseCase
@Validated
public class UcFindTimeSlotImpl extends AbstractTimeSlotUc implements UcFindTimeSlot {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindTimeSlotImpl.class);

  @Override
  public TimeSlotEto findTimeSlot(Long id) {

    LOG.debug("Get TimeSlot with id {} from database.", id);
    return getBeanMapper().map(getTimeSlotDao().findOne(id), TimeSlotEto.class);
  }

  @Override
  public PaginatedListTo<TimeSlotEto> findTimeSlotEtos(TimeSlotSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<TimeSlotEntity> timeslots = getTimeSlotDao().findTimeSlots(criteria);
    return mapPaginatedEntityList(timeslots, TimeSlotEto.class);
  }

}
