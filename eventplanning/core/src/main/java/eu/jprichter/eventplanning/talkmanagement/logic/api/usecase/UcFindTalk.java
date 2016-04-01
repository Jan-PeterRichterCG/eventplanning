package eu.jprichter.eventplanning.talkmanagement.logic.api.usecase;

import java.util.List;

import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * This type ... (missing JavaDoc in generated code)
 *
 * @author jrichter
 * @since 0.0.1
 */
public interface UcFindTalk {

  /**
   * Returns a Talk by its id 'id'.
   *
   * @param id The id 'id' of the Talk.
   * @return The {@link TalkEto} with id 'id'
   */
  TalkEto findTalk(Long id);

  /**
   * Returns a paginated list of Talks matching the search criteria.
   *
   * @param criteria the {@link TalkSearchCriteriaTo}.
   * @return the {@link List} of matching {@link TalkEto}s.
   */
  PaginatedListTo<TalkEto> findTalkEtos(TalkSearchCriteriaTo criteria);

}
