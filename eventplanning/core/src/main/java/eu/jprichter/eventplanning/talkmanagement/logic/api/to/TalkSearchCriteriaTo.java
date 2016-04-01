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

  /**
   * @return (missing JavaDoc in generated code)
   */
  public String getTitle() {

    return this.title;
  }

  /**
   * @param title (missing JavaDoc in generated code)
   */
  public void setTitle(String title) {

    this.title = title;
  }

  /**
   * @return (missing JavaDoc in generated code)
   */
  public String getSpeakerFirstName() {

    return this.speakerFirstName;
  }

  /**
   * @param speakerFirstName (missing JavaDoc in generated code)
   */
  public void setSpeakerFirstName(String speakerFirstName) {

    this.speakerFirstName = speakerFirstName;
  }

  /**
   * @return (missing JavaDoc in generated code)
   */
  public String getSpeakerLastName() {

    return this.speakerLastName;
  }

  /**
   * @param speakerLastName (missing JavaDoc in generated code)
   */
  public void setSpeakerLastName(String speakerLastName) {

    this.speakerLastName = speakerLastName;
  }

}
