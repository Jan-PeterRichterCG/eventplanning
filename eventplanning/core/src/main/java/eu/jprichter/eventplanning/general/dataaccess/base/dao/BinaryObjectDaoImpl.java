package eu.jprichter.eventplanning.general.dataaccess.base.dao;

import eu.jprichter.eventplanning.general.dataaccess.api.BinaryObjectEntity;
import eu.jprichter.eventplanning.general.dataaccess.api.dao.BinaryObjectDao;

import javax.inject.Named;

/**
 * Implementation of {@link BinaryObjectDao}.
 *
 * @author sspielma
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}
