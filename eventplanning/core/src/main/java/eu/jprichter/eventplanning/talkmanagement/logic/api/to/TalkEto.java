package eu.jprichter.eventplanning.talkmanagement.logic.api.to;

import eu.jprichter.eventplanning.general.common.api.to.AbstractEto;
import eu.jprichter.eventplanning.talkmanagement.common.api.Talk;

/**
 * Entity transport object of Talk
 */
public class TalkEto extends AbstractEto implements Talk {

  private static final long serialVersionUID = 1L;

  private String title;

  private String speakerFirstName;

  private String speakerLastName;

  /**
   * {@inheritDoc}
   */
  @Override
  public String getTitle() {

    return title;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setTitle(String title) {

    this.title = title;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getSpeakerFirstName() {

    return speakerFirstName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setSpeakerFirstName(String speakerFirstName) {

    this.speakerFirstName = speakerFirstName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getSpeakerLastName() {

    return speakerLastName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setSpeakerLastName(String speakerLastName) {

    this.speakerLastName = speakerLastName;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.title == null) ? 0 : this.title.hashCode());
    result = prime * result + ((this.speakerFirstName == null) ? 0 : this.speakerFirstName.hashCode());
    result = prime * result + ((this.speakerLastName == null) ? 0 : this.speakerLastName.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    TalkEto other = (TalkEto) obj;
    if (this.title == null) {
      if (other.title != null) {
        return false;
      }
    } else if (!this.title.equals(other.title)) {
      return false;
    }
    if (this.speakerFirstName == null) {
      if (other.speakerFirstName != null) {
        return false;
      }
    } else if (!this.speakerFirstName.equals(other.speakerFirstName)) {
      return false;
    }
    if (this.speakerLastName == null) {
      if (other.speakerLastName != null) {
        return false;
      }
    } else if (!this.speakerLastName.equals(other.speakerLastName)) {
      return false;
    }
    return true;
  }
}
