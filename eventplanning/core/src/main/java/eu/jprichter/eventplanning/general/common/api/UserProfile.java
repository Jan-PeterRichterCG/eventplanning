package eu.jprichter.eventplanning.general.common.api;

import java.security.Principal;

import eu.jprichter.eventplanning.general.common.api.datatype.Role;

/**
 * This is the interface for the profile of a user interacting with this application.
 *
 * @author agreul
 */
public interface UserProfile extends Principal {
  /**
   * @return the technical ID of the user for calling REST services.
   */
  Long getId();

  /**
   * @return the unique login of the user for authentication and identification.
   */
  @Override
  String getName();

  /**
   * @return the first name of the users real name.
   */
  String getFirstName();

  /**
   * @return the last name of the users real name.
   */
  String getLastName();

  /**
   * @return {@link Role} of this {@link UserProfile}.
   */
  Role getRole();
}
