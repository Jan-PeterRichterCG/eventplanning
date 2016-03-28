package eu.jprichter.eventplanning.general.dataaccess.api;

import javax.persistence.MappedSuperclass;

import eu.jprichter.eventplanning.general.common.api.ApplicationEntity;
import io.oasp.module.jpa.dataaccess.api.AbstractPersistenceEntity;

/**
 * Abstract Entity for all Entities with an id and a version field.
 *
 * @author hohwille
 * @author rjoeris
 */
@MappedSuperclass
public abstract class ApplicationPersistenceEntity extends AbstractPersistenceEntity implements ApplicationEntity {

  private static final long serialVersionUID = 1L;

  /**
   * The constructor.
   */
  public ApplicationPersistenceEntity() {

    super();
  }

}
