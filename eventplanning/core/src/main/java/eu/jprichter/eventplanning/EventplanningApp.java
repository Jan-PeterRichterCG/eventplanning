package eu.jprichter.eventplanning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import io.oasp.module.jpa.dataaccess.api.AdvancedRevisionEntity;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, SecurityFilterAutoConfiguration.class })
/**
 * This type ... (missing JavaDoc in generated code)
 *
 * @author jrichter
 * @since 0.0.1
 */
@SpringBootApplication(exclude = { EndpointAutoConfiguration.class })
@EntityScan(basePackages = { "eu.jprichter.eventplanning" }, basePackageClasses = { AdvancedRevisionEntity.class })
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class EventplanningApp {

  /**
   * Entry point for spring-boot based app
   *
   * @param args - arguments
   */
  public static void main(String[] args) {

    SpringApplication.run(EventplanningApp.class, args);
  }
}
