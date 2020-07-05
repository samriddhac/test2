package test.core.core1.service.impl;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import test.core.core1.dao.Core1CoreDao;
import test.core.core1.model.*;
import test.core.core1.service.Core1CoreService;

/** */
@Service("core1CoreService")
public class Core1CoreServiceImpl implements Core1CoreService {

  private static final Logger LOG = LoggerFactory.getLogger(Core1CoreServiceImpl.class);

  @Autowired private Environment env;

  @Autowired private Core1CoreDao core1CoreDao;

  @Override
  public List<Airport> getAirports(ServiceRequestContext context) {
    LOG.info(env.getProperty("core1-service.log.message.key.1"));
    // TODO

    // TODO
    return null;
  }

  @Override
  public void postAirports(ServiceRequestContext context) {
    LOG.info(env.getProperty("core1-service.log.message.key.2"));
    // TODO

    // TODO
  }

  @Override
  public Airport getAirport(long airportId, ServiceRequestContext context) {
    LOG.info(env.getProperty("core1-service.log.message.key.3"));
    // TODO

    // TODO
    return null;
  }

  @Override
  public void putAirport(long airportId, ServiceRequestContext context) {
    LOG.info(env.getProperty("core1-service.log.message.key.4"));
    // TODO

    // TODO
  }

  @Override
  public void deleteAirport(long airportId, ServiceRequestContext context) {
    LOG.info(env.getProperty("core1-service.log.message.key.5"));
    // TODO

    // TODO
  }
}
