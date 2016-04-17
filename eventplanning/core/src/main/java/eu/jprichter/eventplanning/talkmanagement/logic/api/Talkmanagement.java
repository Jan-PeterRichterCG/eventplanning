package eu.jprichter.eventplanning.talkmanagement.logic.api;

import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcFindTalk;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcFindTimeSlot;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcManageTalk;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcManageTimeSlot;

/**
 * Interface for Talkmanagement component.
 */
public interface Talkmanagement extends UcFindTalk, UcManageTalk, UcFindTimeSlot, UcManageTimeSlot {

}
