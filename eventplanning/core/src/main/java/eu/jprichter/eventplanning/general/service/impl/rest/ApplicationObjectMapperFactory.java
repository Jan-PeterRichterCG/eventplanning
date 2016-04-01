package eu.jprichter.eventplanning.general.service.impl.rest;

import javax.inject.Named;

import com.fasterxml.jackson.databind.jsontype.NamedType;
// import com.fasterxml.jackson.databind.module.SimpleModule;

import io.oasp.module.rest.service.impl.json.ObjectMapperFactory;

/**
 * The MappingFactory class to resolve polymorphic conflicts within the eventplanning application.
 *
 * @author agreul
 */
@Named("ApplicationObjectMapperFactory")
public class ApplicationObjectMapperFactory extends ObjectMapperFactory {

  /**
   * The constructor.
   */
  public ApplicationObjectMapperFactory() {

    super();
    // register polymorphic base classes

    @SuppressWarnings("unused") // not used yet
    NamedType[] subtypes;
    // register mapping for polymorphic sub-classes

  }
}
