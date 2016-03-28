package eu.jprichter.eventplanning.talkmanagement.service.impl.rest;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.transaction.annotation.Transactional;

import eu.jprichter.eventplanning.talkmanagement.logic.api.Talkmanagement;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkEto;
import eu.jprichter.eventplanning.talkmanagement.logic.api.to.TalkSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * The service class for REST calls in order to execute the methods in {@link Talkmanagement}.
 *
 */
@Path("/talkmanagement/v1")
@Named("TalkmanagementRestService")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class TalkmanagementRestServiceImpl {

  private Talkmanagement talkmanagement;

  /**
   * This method sets the field <tt>talkmanagement</tt>.
   *
   * @param talkmanagement the new value of the field talkmanagement
   */
  @Inject
  public void setTalkmanagement(Talkmanagement talkmanagement) {

    this.talkmanagement = talkmanagement;
  }

  /**
   * Delegates to {@link Talkmanagement#findTalk}.
   *
   * @param id the ID of the {@link TalkEto}
   * @return the {@link TalkEto}
   */
  @GET
  @Path("/talk/{id}/")
  public TalkEto getTalk(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("talk not found");
    }
    return this.talkmanagement.findTalk(idAsLong);
  }

  /**
   * Delegates to {@link Talkmanagement#saveTalk}.
   *
   * @param talk the {@link TalkEto} to be saved
   * @return the recently created {@link TalkEto}
   */
  @POST
  @Path("/talk/")
  public TalkEto saveTalk(TalkEto talk) {

    return this.talkmanagement.saveTalk(talk);
  }

  /**
   * Delegates to {@link Talkmanagement#deleteTalk}.
   *
   * @param id ID of the {@link TalkEto} to be deleted
   */
  @DELETE
  @Path("/talk/{id}/")
  public void deleteTalk(@PathParam("id") String id) {

    Long idAsLong;
    if (id == null) {
      throw new BadRequestException("missing id");
    }
    try {
      idAsLong = Long.parseLong(id);
    } catch (NumberFormatException e) {
      throw new BadRequestException("id is not a number");
    } catch (NotFoundException e) {
      throw new BadRequestException("talk not found");
    }
    this.talkmanagement.deleteTalk(idAsLong);
  }

  /**
   * Delegates to {@link Talkmanagement#findTalkEtos}.
   *
   * @param searchCriteriaTo the pagination and search criteria to be used for finding talks.
   * @return the {@link PaginatedListTo list} of matching {@link TalkEto}s.
   */
  @Path("/talk/search")
  @POST
  public PaginatedListTo<TalkEto> findTalksByPost(TalkSearchCriteriaTo searchCriteriaTo) {

    return this.talkmanagement.findTalkEtos(searchCriteriaTo);
  }

}