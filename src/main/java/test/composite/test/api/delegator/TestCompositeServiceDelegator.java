package test.composite.test.api.delegator;

import com.cognizant.cosmos.core.utils.FutureUtils;
import com.cognizant.cosmos.core.utils.execution.ServiceExecution;
import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import test.composite.test.api.ITestCompositeService;
import test.composite.test.api.helper.ICore1CoreServiceHelper;
import test.composite.test.api.helper.ITestCompositeServiceHelper;

@Component
public class TestCompositeServiceDelegator implements ITestCompositeService {
  private static final Logger LOG = LoggerFactory.getLogger(TestCompositeServiceDelegator.class);

  @Autowired private FutureUtils futureUtils;

  @Autowired private Environment env;

  @Autowired private ITestCompositeServiceHelper testCompositeServiceHelper;

  @Autowired private ICore1CoreServiceHelper core1CoreServiceHelper;

  public ServiceResponseContext findSourceAccounts(ServiceRequestContext serviceRequestContext) {
    ServiceExecution execution = new ServiceExecution(serviceRequestContext);
    testCompositeServiceHelper.processFindSourceAccountsRequest(execution);
    if (execution.getServiceCall("04464947-4e5c-4dba-8ac3-1ca7e7cc9713")) {
      LOG.info(env.getProperty("test-composite-service-delegator.log.message.key.1"));
      execution.setServiceCallResult(
          "04464947-4e5c-4dba-8ac3-1ca7e7cc9713",
          core1CoreServiceHelper.processGetAirportsResponse(
              "04464947-4e5c-4dba-8ac3-1ca7e7cc9713",
              execution,
              core1CoreServiceHelper.getAirports(
                  core1CoreServiceHelper.processGetAirportsRequest(
                      "04464947-4e5c-4dba-8ac3-1ca7e7cc9713", execution, "GetAirports"))));
    } else {
      LOG.info(env.getProperty("test-composite-service-delegator.log.message.key.2"));
    }
    return testCompositeServiceHelper.processFindSourceAccountsResponse(execution);
  }

  public ServiceResponseContext findTargetAccounts(ServiceRequestContext serviceRequestContext) {
    ServiceExecution execution = new ServiceExecution(serviceRequestContext);
    testCompositeServiceHelper.processFindTargetAccountsRequest(execution);
    return testCompositeServiceHelper.processFindTargetAccountsResponse(execution);
  }

  public ServiceResponseContext findAttributes(ServiceRequestContext serviceRequestContext) {
    ServiceExecution execution = new ServiceExecution(serviceRequestContext);
    testCompositeServiceHelper.processFindAttributesRequest(execution);
    return testCompositeServiceHelper.processFindAttributesResponse(execution);
  }

  public ServiceResponseContext validateAttributes(ServiceRequestContext serviceRequestContext) {
    ServiceExecution execution = new ServiceExecution(serviceRequestContext);
    testCompositeServiceHelper.processValidateAttributesRequest(execution);
    return testCompositeServiceHelper.processValidateAttributesResponse(execution);
  }

  public ServiceResponseContext findProfiles(ServiceRequestContext serviceRequestContext) {
    ServiceExecution execution = new ServiceExecution(serviceRequestContext);
    testCompositeServiceHelper.processFindProfilesRequest(execution);
    return testCompositeServiceHelper.processFindProfilesResponse(execution);
  }

  public ServiceResponseContext createProfile(ServiceRequestContext serviceRequestContext) {
    ServiceExecution execution = new ServiceExecution(serviceRequestContext);
    testCompositeServiceHelper.processCreateProfileRequest(execution);
    return testCompositeServiceHelper.processCreateProfileResponse(execution);
  }
}
