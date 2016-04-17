package eu.jprichter.eventplanning.talkmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import eu.jprichter.eventplanning.general.logic.api.UseCase;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TimeSlotEntity;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcManageTimeSlot;
import eu.jprichter.eventplanning.talkmanagement.logic.base.usecase.AbstractTimeSlotUc;

/**
 * Use case implementation for modifying and deleting TimeSlots
 */
@Named
@UseCase
@Validated
public class UcManageTimeSlotImpl extends AbstractTimeSlotUc implements UcManageTimeSlot {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageTimeSlotImpl.class);

  @Override
  public boolean deleteTimeSlot(Long timeSlotId) {

    TimeSlotEntity timeSlot = getTimeSlotDao().find(timeSlotId);
    getTimeSlotDao().delete(timeSlot);
    LOG.debug("The timeSlot with id '{}' has been deleted.", timeSlotId);
    return true;
  }

  @Override
  public TimeSlotEto saveTimeSlot(TimeSlotEto timeSlot) {

    Objects.requireNonNull(timeSlot, "timeSlot");

    TimeSlotEntity timeSlotEntity = getBeanMapper().map(timeSlot, TimeSlotEntity.class);

    // initialize, validate timeSlotEntity here if necessary

    getTimeSlotDao().save(timeSlotEntity);
    LOG.debug("TimeSlot with id '{}' has been created.", timeSlotEntity.getId());
    return getBeanMapper().map(timeSlotEntity, TimeSlotEto.class);
  }
}
