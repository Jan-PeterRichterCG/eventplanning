package eu.jprichter.eventplanning.talkmanagement.logic.api.to;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link eu.jprichter.eventplanning.talkmanagement.common.api.Talk}s.
 *
 */
public class TalkSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private String title;

  private String speakerFirstName;

  private String speakerLastName;

  /**
   * The constructor.
   */
  public TalkSearchCriteriaTo() {

    super();
  }

  public String getTitle() {

    return title;
  }

  public void setTitle(String title) {

    this.title = title;
  }

  public String getSpeakerFirstName() {

    return speakerFirstName;
  }

  public void setSpeakerFirstName(String speakerFirstName) {

    this.speakerFirstName = speakerFirstName;
  }

  public String getSpeakerLastName() {

    return speakerLastName;
  }

  public void setSpeakerLastName(String speakerLastName) {

    this.speakerLastName = speakerLastName;
  }

}
