package eu.jprichter.eventplanning.talkmanagement.common.api;

/**
 * The {@link Talk} is the somewhat abstract entity that represents what the speaker presents. It is not associated with
 * a time slot or a room. Think of the {@link Talk} as 'what the speaker prepares'.
 *
 * @author jrichter
 * @since 0.0.1
 */
public interface Talk {

  /**
   *
   * @return the title of the talk
   */
  public String getTitle();

  /**
   *
   * @param title the new title of the talk
   */
  public void setTitle(String title);

  /**
   *
   * @return the first name of the speaker
   */
  public String getSpeakerFirstName();

  /**
   *
   * @param speakerFirstName the new first name of the speaker
   */
  public void setSpeakerFirstName(String speakerFirstName);

  /**
   *
   * @return the last name of the speaker
   */
  public String getSpeakerLastName();

  /**
   *
   * @param speakerLastName the new last name of the speaker
   */
  public void setSpeakerLastName(String speakerLastName);

}
