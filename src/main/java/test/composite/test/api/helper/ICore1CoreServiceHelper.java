package test.composite.test.api.helper;

import com.cognizant.cosmos.core.utils.execution.ServiceData;
import com.cognizant.cosmos.core.utils.execution.ServiceExecution;

public interface ICore1CoreServiceHelper {

  public ServiceData getAirports(ServiceData serviceData);

  public ServiceData processGetAirportsRequest(
      String stepIdentifier, ServiceExecution execution, Object... args);

  public ServiceData processGetAirportsResponse(
      String stepIdentifier, ServiceExecution execution, ServiceData serviceData);

  public ServiceData processGetAirportsFallback(ServiceData serviceData, Throwable throwable);
}
