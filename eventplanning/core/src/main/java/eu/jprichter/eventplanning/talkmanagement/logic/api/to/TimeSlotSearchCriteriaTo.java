package eu.jprichter.eventplanning.talkmanagement.logic.api.to;

import java.time.Instant;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link eu.jprichter.eventplanning.talkmanagement.common.api.TimeSlot}s.
 *
 */
public class TimeSlotSearchCriteriaTo extends SearchCriteriaTo {

  private static final long serialVersionUID = 1L;

  private Instant start;

  private Instant end;

  /**
   * The constructor.
   */
  public TimeSlotSearchCriteriaTo() {

    super();
  }

  /**
   *
   * @return the start time to search for
   */
  public Instant getStart() {

    return this.start;
  }

  /**
   *
   * @param start
   */
  public void setStart(Instant start) {

    this.start = start;
  }

  /**
   *
   * @return the end time to search for
   */
  public Instant getEnd() {

    return this.end;
  }

  /**
   * @param end
   */
  public void setEnd(Instant end) {

    this.end = end;
  }

}
