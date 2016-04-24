package eu.jprichter.eventplanning.general.dataaccess.base.hibernate;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This {@link Converter} is used to map the JSR-310 data type {@link Instant} to the SQL data type TIMESTAMP Note: This
 * mapping makes the assumption that a zone-less TIMESTAMP is UTC, NOT local time!
 *
 * @author jrichter
 * @since 0.0.1
 */
@Converter(autoApply = true)
public class JSR310InstantToUtcTimeStampConverter implements AttributeConverter<Instant, Timestamp> {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(JSR310InstantToUtcTimeStampConverter.class);

  @Override
  public Timestamp convertToDatabaseColumn(Instant instant) {

    if (instant == null) {
      return null;
    }

    // convert the instant to a localDateTime, i.e. interpret (!) "local" to be UTC
    LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC+00:00"));
    // convert the localDateTime to java.sql.Timestamp
    Timestamp timestamp = Timestamp.valueOf(localDateTime);

    LOG.debug(
        "XXX instant: " + instant + " --> localDateTime: " + localDateTime + " --> timestamp: " + timestamp.toString());
    return timestamp;
  }

  @Override
  public Instant convertToEntityAttribute(Timestamp timestamp) {

    if (timestamp == null) {
      return null;
    }

    // first, convert the timestamp to a LocalDateTime what it actually is since it doesn't contain a time zone
    LocalDateTime localDateTime = timestamp.toLocalDateTime();
    // next add the "time zone" of UTC to it, i.e. interpret (!) the time stamp as a UTC zoned date time
    ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC+00:00"));
    // finally create a proper instant from it
    Instant instant = Instant.from(zonedDateTime);

    LOG.debug("XXX timestamp: " + timestamp + "(" + timestamp.getTime() + ") --> " + "localDateTime: " + localDateTime
        + " --> " + "zonesDateTime: " + zonedDateTime + " --> " + "instant: " + instant);

    return instant;
  }
}
