package test.composite.test.api.helper;

import com.cognizant.cosmos.core.utils.execution.ServiceExecution;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;

public interface ITestCompositeServiceHelper {

  public void processFindSourceAccountsRequest(ServiceExecution execution);

  public ServiceResponseContext processFindSourceAccountsResponse(ServiceExecution execution);

  public void processFindTargetAccountsRequest(ServiceExecution execution);

  public ServiceResponseContext processFindTargetAccountsResponse(ServiceExecution execution);

  public void processFindAttributesRequest(ServiceExecution execution);

  public ServiceResponseContext processFindAttributesResponse(ServiceExecution execution);

  public void processValidateAttributesRequest(ServiceExecution execution);

  public ServiceResponseContext processValidateAttributesResponse(ServiceExecution execution);

  public void processFindProfilesRequest(ServiceExecution execution);

  public ServiceResponseContext processFindProfilesResponse(ServiceExecution execution);

  public void processCreateProfileRequest(ServiceExecution execution);

  public ServiceResponseContext processCreateProfileResponse(ServiceExecution execution);
}
