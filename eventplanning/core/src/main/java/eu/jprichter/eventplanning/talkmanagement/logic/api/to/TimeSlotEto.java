package eu.jprichter.eventplanning.talkmanagement.logic.api.to;

import java.time.Instant;

import eu.jprichter.eventplanning.general.common.api.to.AbstractEto;
import eu.jprichter.eventplanning.talkmanagement.common.api.TimeSlot;

/**
 * Entity transport object of TimeSlot
 */
public class TimeSlotEto extends AbstractEto implements TimeSlot {

  private static final long serialVersionUID = 1L;

  private Instant start;

  private Instant end;

  /**
   * {@inheritDoc}
   */
  @Override
  public Instant getStart() {

    return this.start;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setStart(Instant start) {

    this.start = start;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Instant getEnd() {

    return this.end;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEnd(Instant end) {

    this.end = end;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.start == null) ? 0 : this.start.hashCode());
    result = prime * result + ((this.end == null) ? 0 : this.end.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    TimeSlotEto other = (TimeSlotEto) obj;
    if (this.start == null) {
      if (other.start != null) {
        return false;
      }
    } else if (!this.start.equals(other.start)) {
      return false;
    }
    if (this.end == null) {
      if (other.end != null) {
        return false;
      }
    } else if (!this.end.equals(other.end)) {
      return false;
    }
    return true;
  }
}
