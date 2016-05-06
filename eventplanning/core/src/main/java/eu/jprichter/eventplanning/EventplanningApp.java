package eu.jprichter.eventplanning;

import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import io.oasp.module.jpa.dataaccess.api.AdvancedRevisionEntity;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class })
/**
 * This is the main boot class of the event planning server application.
 *
 * @author jrichter
 * @since 0.0.1
 */
@SpringBootApplication(exclude = { EndpointAutoConfiguration.class })
@EntityScan(basePackages = { "eu.jprichter.eventplanning" }, basePackageClasses = { AdvancedRevisionEntity.class })
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class EventplanningApp {

  private static Logger LOG = Logger.getLogger(EventplanningApp.class);

  /**
   * Entry point for spring-boot based app
   *
   * @param args - arguments
   */
  public static void main(String[] args) {

    /*
     * This line is necessary in order to set the JVM's time zone to UTC so that the mapping of java.time.Instant <->
     * SQL TIMESTAMP works properly
     *
     * This code is left here intentionally so that it is not forgotten that the hibernate mapping is actually broken
     */
    LOG.info("Set default time zone to UTC");
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

    // ApplicationContext context =
    SpringApplication.run(EventplanningApp.class, args);

  }
}
