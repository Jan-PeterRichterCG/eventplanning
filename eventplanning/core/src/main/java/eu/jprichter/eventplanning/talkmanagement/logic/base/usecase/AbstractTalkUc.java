package eu.jprichter.eventplanning.talkmanagement.logic.base.usecase;

import javax.inject.Inject;

import eu.jprichter.eventplanning.general.logic.base.AbstractUc;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.dao.TalkDao;

/**
 * Abstract use case for Talks, which provides access to the commonly necessary data access objects.
 */
public class AbstractTalkUc extends AbstractUc {

  /** @see #getTalkDao() */
  private TalkDao talkDao;

  /**
   * Returns the field 'talkDao'.
   * 
   * @return the {@link TalkDao} instance.
   */
  public TalkDao getTalkDao() {

    return this.talkDao;
  }

  /**
   * Sets the field 'talkDao'.
   * 
   * @param talkDao New value for talkDao
   */
  @Inject
  public void setTalkDao(TalkDao talkDao) {

    this.talkDao = talkDao;
  }

}
