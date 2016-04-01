package eu.jprichter.eventplanning.general.common.api.datatype;

import java.security.Principal;

/**
 * This type ... (missing JavaDoc in generated code)
 *
 * @author jrichter
 * @since 0.0.1
 */
public enum Role implements Principal {

  /**
   * (missing JavaDoc in generated code)
   */
  ADMIN("Admin");

  private final String name;

  private Role(String name) {

    this.name = name;
  }

  @Override
  public String getName() {

    return this.name;
  }
}
