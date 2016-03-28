package eu.jprichter.eventplanning.talkmanagement.dataaccess.api.dao;

import eu.jprichter.eventplanning.general.dataaccess.api.dao.ApplicationDao;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TalkEntity;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Data access interface for Talk entities
 */
public interface TalkDao extends ApplicationDao<TalkEntity> {

  /**
   * Finds the {@link TalkEntity talks} matching the given {@link TalkSearchCriteriaTo}.
   *
   * @param criteria is the {@link TalkSearchCriteriaTo}.
   * @return the {@link PaginatedListTo} with the matching {@link TalkEntity} objects.
   */
  PaginatedListTo<TalkEntity> findTalks(TalkSearchCriteriaTo criteria);
}
