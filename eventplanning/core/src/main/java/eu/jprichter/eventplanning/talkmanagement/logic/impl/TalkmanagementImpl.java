package eu.jprichter.eventplanning.talkmanagement.logic.impl;

import javax.inject.Inject;
import javax.inject.Named;

import eu.jprichter.eventplanning.general.logic.api.UseCase;
import eu.jprichter.eventplanning.general.logic.base.AbstractComponentFacade;
import eu.jprichter.eventplanning.talkmanagement.logic.api.Talkmanagement;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkSearchCriteriaTo;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotSearchCriteriaTo;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcFindTalk;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcFindTimeSlot;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcManageTalk;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcManageTimeSlot;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of component interface of talkmanagement
 */
@Named
public class TalkmanagementImpl extends AbstractComponentFacade implements Talkmanagement {

  private UcFindTalk ucFindTalk;

  private UcManageTalk ucManageTalk;

  private UcFindTimeSlot ucFindTimeSlot;

  private UcManageTimeSlot ucManageTimeSlot;

  /**
   * The constructor.
   */
  public TalkmanagementImpl() {

    super();
  }

  @Override
  public TalkEto findTalk(Long id) {

    return this.ucFindTalk.findTalk(id);
  }

  @Override
  public PaginatedListTo<TalkEto> findTalkEtos(TalkSearchCriteriaTo criteria) {

    return this.ucFindTalk.findTalkEtos(criteria);
  }

  @Override
  public TalkEto saveTalk(TalkEto talk) {

    return this.ucManageTalk.saveTalk(talk);
  }

  @Override
  public boolean deleteTalk(Long id) {

    return this.ucManageTalk.deleteTalk(id);
  }

  /**
   * Sets the field 'ucFindTalk'.
   *
   * @param ucFindTalk New value for ucFindTalk
   */
  @Inject
  @UseCase
  public void setUcFindTalk(UcFindTalk ucFindTalk) {

    this.ucFindTalk = ucFindTalk;
  }

  /**
   * Sets the field 'ucManageTalk'.
   *
   * @param ucManageTalk New value for ucManageTalk
   */
  @Inject
  @UseCase
  public void setUcManageTalk(UcManageTalk ucManageTalk) {

    this.ucManageTalk = ucManageTalk;
  }

  @Override
  public TimeSlotEto findTimeSlot(Long id) {

    return this.ucFindTimeSlot.findTimeSlot(id);
  }

  @Override
  public PaginatedListTo<TimeSlotEto> findTimeSlotEtos(TimeSlotSearchCriteriaTo criteria) {

    return this.ucFindTimeSlot.findTimeSlotEtos(criteria);
  }

  @Override
  public TimeSlotEto saveTimeSlot(TimeSlotEto timeslot) {

    return this.ucManageTimeSlot.saveTimeSlot(timeslot);
  }

  @Override
  public boolean deleteTimeSlot(Long id) {

    return this.ucManageTimeSlot.deleteTimeSlot(id);
  }

  /**
   * Sets the field 'ucFindTimeSlot'.
   *
   * @param ucFindTimeSlot New value for ucFindTimeSlot
   */
  @Inject
  @UseCase
  public void setUcFindTimeSlot(UcFindTimeSlot ucFindTimeSlot) {

    this.ucFindTimeSlot = ucFindTimeSlot;
  }

  /**
   * Sets the field 'ucManageTimeSlot'.
   *
   * @param ucManageTimeSlot New value for ucManageTimeSlot
   */
  @Inject
  @UseCase
  public void setUcManageTimeSlot(UcManageTimeSlot ucManageTimeSlot) {

    this.ucManageTimeSlot = ucManageTimeSlot;
  }

}
