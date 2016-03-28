package eu.jprichter.eventplanning.talkmanagement.logic.api.usecase;

import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkEto;

/**
 * Interface of UcManageTalk to centralize documentation and signatures of methods.
 */
public interface UcManageTalk {

  /**
   * Deletes a talk from the database by its id 'talkId'.
   *
   * @param talkId Id of the talk to delete
   * @return boolean <code>true</code> if the talk can be deleted, <code>false</code> otherwise
   */
  boolean deleteTalk(Long talkId);

  /**
   * Saves a talk and store it in the database.
   *
   * @param talk the {@link TalkEto} to create.
   * @return the new {@link TalkEto} that has been saved with ID and version.
   */
  TalkEto saveTalk(TalkEto talk);

}
