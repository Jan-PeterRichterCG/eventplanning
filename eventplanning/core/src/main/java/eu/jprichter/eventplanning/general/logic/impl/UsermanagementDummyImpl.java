package eu.jprichter.eventplanning.general.logic.impl;

import javax.inject.Named;

import org.springframework.stereotype.Component;

import eu.jprichter.eventplanning.general.common.api.UserProfile;
import eu.jprichter.eventplanning.general.common.api.Usermanagement;
import eu.jprichter.eventplanning.general.common.api.datatype.Role;
import eu.jprichter.eventplanning.general.common.api.to.UserDetailsClientTo;
import eu.jprichter.eventplanning.general.common.base.AbstractBeanMapperSupport;

/**
 * Implementation of {@link Usermanagement}.
 */
@Named
@Component
public class UsermanagementDummyImpl extends AbstractBeanMapperSupport implements Usermanagement {

  @Override
  public UserProfile findUserProfileByLogin(String login) {

    // this is only a dummy - please replace with a real implementation
    UserDetailsClientTo profile = new UserDetailsClientTo();
    profile.setName(login);
    profile.setFirstName("Peter");
    profile.setLastName(login);
    profile.setRole(Role.ADMIN);
    return profile;
  }

}
