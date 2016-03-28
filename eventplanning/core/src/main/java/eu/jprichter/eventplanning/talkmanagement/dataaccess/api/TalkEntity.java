package eu.jprichter.eventplanning.talkmanagement.dataaccess.api;

import javax.persistence.Entity;
import javax.persistence.Table;

import eu.jprichter.eventplanning.general.dataaccess.api.ApplicationPersistenceEntity;
import eu.jprichter.eventplanning.talkmanagement.common.api.Talk;

/**
 * This type implements the {@link Talk} as a persistent entity.
 *
 * @author jrichter
 * @since 0.0.1
 */
@Entity
@Table(name = "Talk")
public class TalkEntity extends ApplicationPersistenceEntity implements Talk {

  private static final long serialVersionUID = 1L;

  private String title;

  private String speakerFirstName;

  private String speakerLastName;

  /**
   * {@inheritDoc}
   */
  @Override
  public String getTitle() {

    return this.title;
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

    return this.speakerFirstName;
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

    return this.speakerLastName;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setSpeakerLastName(String speakerLastName) {

    this.speakerLastName = speakerLastName;
  }

}
