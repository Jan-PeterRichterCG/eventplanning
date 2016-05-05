package eu.jprichter.eventplanning.talkmanagement.dataaccess.api.dao;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eu.jprichter.eventplanning.talkmanagement.dataaccess.api.TimeSlotEntity;

/**
 * Helper class for the TimeSlotDaoTest. Needed to have a proxied interface so that the transaction advison can create
 * the new transactions.
 *
 * @author jrichter
 * @since 0.0.1
 */
@Named
public class TimeSlotDaoTestHelper {

  @Inject
  TimeSlotDao timeSlotDao;

  /**
   * @param timeSlot the TimeSlotEntity to save
   * @return the saved TimeSlotEntity
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public TimeSlotEntity saveTimeSlot(TimeSlotEntity timeSlot) {

    return this.timeSlotDao.save(timeSlot);
  }

  /**
   * @param id the ID to look for
   * @return TimeSlotEntity with the ID to look for - or null
   */
  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public TimeSlotEntity readTimeSlot(Long id) {

    return this.timeSlotDao.find(id);
  }

}
