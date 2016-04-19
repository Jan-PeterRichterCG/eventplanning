package eu.jprichter.eventplanning.general.service.impl.rest;

import java.time.Instant;

import javax.inject.Named;

import com.fasterxml.jackson.databind.jsontype.NamedType;
// import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.module.SimpleModule;

import eu.jprichter.eventplanning.general.service.impl.rest.json.InstantJsonSerializer;
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

    // register custom JSON serializer and deserializer

    SimpleModule module = getExtensionModule();

    // module.addDeserializer(Instant.class, new InstantJsonDeserializer());
    module.addSerializer(Instant.class, new InstantJsonSerializer());

    // register polymorphic base classes

    @SuppressWarnings("unused") // not used yet
    NamedType[] subtypes;
    // register mapping for polymorphic sub-classes

  }
}
