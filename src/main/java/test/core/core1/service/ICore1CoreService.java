package test.core.core1.service;

import java.util.*;
import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import test.core.core1.model.*;

public interface ICore1CoreService {

  List<Airport> getAirports(ServiceRequestContext context);

  void postAirports(ServiceRequestContext context);

  Airport getAirport(long airportId, ServiceRequestContext context);

  void putAirport(long airportId, ServiceRequestContext context);

  void deleteAirport(long airportId, ServiceRequestContext context);
}
