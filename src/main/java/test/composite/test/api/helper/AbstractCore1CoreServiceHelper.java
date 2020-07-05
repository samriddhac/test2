package test.composite.test.api.helper;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cognizant.cosmos.core.utils.IConstants;
import com.cognizant.cosmos.core.utils.execution.ServiceData;
import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import com.cognizant.cosmos.core.utils.execution.ServiceResponseContext;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import test.core.core1.model.*;

public abstract class AbstractCore1CoreServiceHelper implements ICore1CoreServiceHelper {

  private static final Logger LOG = LoggerFactory.getLogger(AbstractCore1CoreServiceHelper.class);
  private static final String BASE_URI = "http://airport-service/airport-service/1.0";

  @Autowired
  @Qualifier(IConstants.BEAN_ID_LOAD_BALANCED_REST_TEMPLATE)
  private RestTemplate restTemplate;

  @Autowired private Environment env;

  /** */
  public String getServiceName() {
    return "airport-service";
  }

  public String getServiceVersion() {
    return "1.0";
  }

  @Override
  @CircuitBreaker(name = "getAirports", fallbackMethod = "processGetAirportsFallback")
  public ServiceData getAirports(ServiceData serviceData) {
    try {
      LOG.info(env.getProperty("abstract-core1-core-service.log.message.key.1"));
      serviceData.setName(getServiceName());
      serviceData.setVersion(getServiceVersion());
      ServiceRequestContext serviceRequestContext = serviceData.getServiceRequestContext();
      serviceRequestContext.setUrl(
          UriComponentsBuilder.fromHttpUrl((BASE_URI + "/airports"))
              .queryParams(serviceRequestContext.getQueryParams())
              .toUriString());
      serviceRequestContext.setMethod(HttpMethod.GET.name());
      ResponseEntity<Airport[]> responseEntity =
          restTemplate.exchange(
              serviceRequestContext.getUrl(),
              HttpMethod.GET,
              new HttpEntity<>(serviceRequestContext.getHttpHeaders()),
              Airport[].class);
      Airport[] response = responseEntity.getBody();
      ServiceResponseContext serviceResponseContext = new ServiceResponseContext();
      serviceResponseContext.setBody(response);
      serviceResponseContext.setHeaders(responseEntity.getHeaders());
      serviceData.setServiceResponseContext(serviceResponseContext);
      LOG.info((env.getProperty("abstract-core1-core-service.log.message.key.2") + serviceData));
      return serviceData;
    } catch (Exception e) {
      LOG.error(
          (env.getProperty("abstract-core1-core-service.log.message.key.3") + serviceData), e);
      throw e;
    }
  }
}
