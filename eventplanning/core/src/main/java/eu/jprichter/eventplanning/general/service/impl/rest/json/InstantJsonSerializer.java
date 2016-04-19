package eu.jprichter.eventplanning.general.service.impl.rest.json;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Custon JSON serializer for the {@link java.time.Instant} class.
 *
 * @author jrichter
 * @since 0.0.1
 */
public class InstantJsonSerializer extends JsonSerializer<Instant> {

  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss Z").withZone(ZoneId.of("MET"));

  @Override
  public void serialize(Instant value, JsonGenerator gen, SerializerProvider serializers)
      throws IOException, JsonProcessingException {

    if (value != null) {
      gen.writeString(this.formatter.format(value));
    }

  }

}
