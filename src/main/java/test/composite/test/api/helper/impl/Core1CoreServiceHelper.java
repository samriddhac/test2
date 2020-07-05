package test.composite.test.api.helper.impl;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.cognizant.cosmos.core.utils.execution.ServiceData;
import com.cognizant.cosmos.core.utils.execution.ServiceExecution;
import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;

import test.composite.test.api.helper.ICore1CoreServiceHelper;
import test.composite.test.api.helper.AbstractCore1CoreServiceHelper;
import test.composite.test.model.*;

@Component
public class Core1CoreServiceHelper extends AbstractCore1CoreServiceHelper {

  private static final Logger LOG = LoggerFactory.getLogger(Core1CoreServiceHelper.class);

  @Autowired private Environment env;

  @Override
  public ServiceData processGetAirportsRequest(
      String stepIdentifier, ServiceExecution execution, Object... args) {
    ServiceData serviceData = new ServiceData();
    ServiceRequestContext serviceRequestContext = new ServiceRequestContext();
    // TODO: your code goes here

    serviceData.setServiceRequestContext(serviceRequestContext);
    return serviceData;
  }

  @Override
  public ServiceData processGetAirportsResponse(
      String stepIdentifier, ServiceExecution execution, ServiceData serviceData) {
    // TODO: your code goes here

    return serviceData;
  }

  @Override
  public ServiceData processGetAirportsFallback(ServiceData serviceData, Throwable throwable) {
    serviceData.setFallbackFlag(true);
    serviceData.setThrowable(throwable);
    serviceData.setServiceResponseContext(null);
    return serviceData;
  }
}
