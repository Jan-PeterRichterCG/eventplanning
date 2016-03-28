package eu.jprichter.eventplanning.talkmanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;

import eu.jprichter.eventplanning.general.logic.api.UseCase;
import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TalkEntity;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.usecase.UcManageTalk;
import eu.jprichter.eventplanning.talkmanagement.logic.base.usecase.AbstractTalkUc;

/**
 * Use case implementation for modifying and deleting Talks
 */
@Named
@UseCase
@Validated
public class UcManageTalkImpl extends AbstractTalkUc implements UcManageTalk {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageTalkImpl.class);

  @Override
  public boolean deleteTalk(Long talkId) {

    TalkEntity talk = getTalkDao().find(talkId);
    getTalkDao().delete(talk);
    LOG.debug("The talk with id '{}' has been deleted.", talkId);
    return true;
  }

  @Override
  public TalkEto saveTalk(TalkEto talk) {

    Objects.requireNonNull(talk, "talk");

    TalkEntity talkEntity = getBeanMapper().map(talk, TalkEntity.class);

    // initialize, validate talkEntity here if necessary

    getTalkDao().save(talkEntity);
    LOG.debug("Talk with id '{}' has been created.", talkEntity.getId());
    return getBeanMapper().map(talkEntity, TalkEto.class);
  }
}
