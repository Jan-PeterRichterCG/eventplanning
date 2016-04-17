package eu.jprichter.eventplanning.talkmanagement.dataaccess.impl.dao;

import java.time.Instant;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import eu.jprichter.eventplanning.general.dataaccess.base.dao.ApplicationDaoImpl;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TimeSlotEntity;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.dao.TimeSlotDao;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TimeSlotSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link TimeSlotDao}.
 */
@Named
public class TimeSlotDaoImpl extends ApplicationDaoImpl<TimeSlotEntity> implements TimeSlotDao {

  /**
   * The constructor.
   */
  public TimeSlotDaoImpl() {

    super();
  }

  @Override
  public Class<TimeSlotEntity> getEntityClass() {

    return TimeSlotEntity.class;
  }

  @Override
  public PaginatedListTo<TimeSlotEntity> findTimeSlots(TimeSlotSearchCriteriaTo criteria) {

    TimeSlotEntity timeslot = Alias.alias(TimeSlotEntity.class);
    EntityPathBase<TimeSlotEntity> alias = Alias.$(timeslot);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    Instant start = criteria.getStart();
    if (start != null) {
      query.where(Alias.$(timeslot.getStart()).eq(start));
    }

    Instant end = criteria.getEnd();
    if (end != null) {
      query.where(Alias.$(timeslot.getEnd()).eq(end));
    }

    return findPaginated(criteria, query, alias);
  }

}