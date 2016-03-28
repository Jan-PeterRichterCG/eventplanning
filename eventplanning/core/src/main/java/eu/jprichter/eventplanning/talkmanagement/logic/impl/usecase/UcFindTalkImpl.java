package eu.jprichter.eventplanning.talkmanagement.logic.impl.usecase;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import eu.jprichter.eventplanning.general.logic.api.UseCase;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TalkEntity;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkSearchCriteriaTo;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcFindTalk;
import eu.jprichter.eventplanning.talkmanagement.logic.base.usecase.AbstractTalkUc;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Use case implementation for searching, filtering and getting Talks
 */
@Named
@UseCase
@Validated
public class UcFindTalkImpl extends AbstractTalkUc implements UcFindTalk {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcFindTalkImpl.class);

  @Override
  public TalkEto findTalk(Long id) {

    LOG.debug("Get Talk with id {} from database.", id);
    return getBeanMapper().map(getTalkDao().findOne(id), TalkEto.class);
  }

  @Override
  public PaginatedListTo<TalkEto> findTalkEtos(TalkSearchCriteriaTo criteria) {

    criteria.limitMaximumPageSize(MAXIMUM_HIT_LIMIT);
    PaginatedListTo<TalkEntity> talks = getTalkDao().findTalks(criteria);
    return mapPaginatedEntityList(talks, TalkEto.class);
  }

}
