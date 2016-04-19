package eu.jprichter.eventplanning.general.dataaccess.base.hibernate;

import java.sql.Timestamp;
import java.time.Instant;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * This {@link Converter} is used to map the JSR-310 data type {@link Instant} to the SQL data type TIMESTAMP
 *
 * @author jrichter
 * @since 0.0.1
 */
@Converter(autoApply = true)
public class JSR310InstantConverter implements AttributeConverter<Instant, Timestamp> {

  @Override
  public Timestamp convertToDatabaseColumn(Instant instant) {

    if (instant == null) {
      return null;
    }
    return Timestamp.from(instant);
  }

  @Override
  public Instant convertToEntityAttribute(Timestamp value) {

    if (value == null) {
      return null;
    }
    return Instant.ofEpochMilli(value.getTime());
  }
}
