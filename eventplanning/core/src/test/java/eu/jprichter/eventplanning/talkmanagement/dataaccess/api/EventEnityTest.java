package eu.jprichter.eventplanning.talkmanagement.dataaccess.api;

import org.junit.Test;

import eu.jprichter.eventplanning.talkmanagement.common.api.Event;
import io.oasp.module.test.common.base.ModuleTest;

/**
 * TODO jrichter This type ...
 *
 * @author jrichter
 * @since 0.0.1
 */
public class EventEnityTest extends ModuleTest {

  /**
   * simply test whether the Entity can be instantiated.
   */
  @Test
  public void eventEntityConstructionTest() {

    Event event = new EventEntity();

    assertThat(event).isNotNull();

  }

}
