package test.composite.test.api;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;

/** */
public interface ITestCompositeService {

  ServiceResponseContext findSourceAccounts(ServiceRequestContext context);

  ServiceResponseContext findTargetAccounts(ServiceRequestContext context);

  ServiceResponseContext findAttributes(ServiceRequestContext context);

  ServiceResponseContext validateAttributes(ServiceRequestContext context);

  ServiceResponseContext findProfiles(ServiceRequestContext context);

  ServiceResponseContext createProfile(ServiceRequestContext context);
}
