package eu.jprichter.eventplanning.talkmanagement.dataaccess.impl.dao;

import javax.inject.Named;

import com.mysema.query.alias.Alias;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.path.EntityPathBase;

import eu.jprichter.eventplanning.general.dataaccess.base.dao.ApplicationDaoImpl;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TalkEntity;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.dao.TalkDao;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This is the implementation of {@link TalkDao}.
 */
@Named
public class TalkDaoImpl extends ApplicationDaoImpl<TalkEntity> implements TalkDao {

  /**
   * The constructor.
   */
  public TalkDaoImpl() {

    super();
  }

  @Override
  public Class<TalkEntity> getEntityClass() {

    return TalkEntity.class;
  }

  @Override
  public PaginatedListTo<TalkEntity> findTalks(TalkSearchCriteriaTo criteria) {

    TalkEntity talk = Alias.alias(TalkEntity.class);
    EntityPathBase<TalkEntity> alias = Alias.$(talk);
    JPAQuery query = new JPAQuery(getEntityManager()).from(alias);

    String title = criteria.getTitle();
    if (title != null) {
      query.where(Alias.$(talk.getTitle()).eq(title));
    }

    String speakerFirstName = criteria.getSpeakerFirstName();
    if (speakerFirstName != null) {
      query.where(Alias.$(talk.getSpeakerFirstName()).eq(speakerFirstName));
    }

    String speakerLastName = criteria.getSpeakerLastName();
    if (speakerLastName != null) {
      query.where(Alias.$(talk.getSpeakerLastName()).eq(speakerLastName));
    }

    return findPaginated(criteria, query, alias);
  }

}