package eu.jprichter.eventplanning.general.service.impl.rest;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import io.oasp.module.rest.service.impl.json.ObjectMapperFactory;

/**
 * The MappingFactory class to resolve polymorphic conflicts within the eventplanning application.
 *
 * @author agreul
 */
@Named("ApplicationObjectMapperFactory")
public class ApplicationObjectMapperFactory extends ObjectMapperFactory {

  private static final Logger LOG = LoggerFactory.getLogger(ApplicationObjectMapperFactory.class);

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

  @Override
  public ObjectMapper createInstance() {

    ObjectMapper mapper = super.createInstance();

    mapper.registerModule(new JavaTimeModule());
    mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    return mapper;
  }

}
