package test.core.core1.api.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;

import test.core.core1.model.*;
import test.core.core1.service.Core1CoreService;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/** */
@RestController
@Api("airport-service")
public class Core1CoreServiceController {

  private static final Logger LOG = LoggerFactory.getLogger(Core1CoreServiceController.class);
  @Autowired private Environment env;
  @Autowired private Core1CoreService core1CoreService;

  /** */
  @GetMapping(
      value = "/airports",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "", tags = "", response = Airport.class)
  @ApiResponses({@ApiResponse(code = 200, message = "success")})
  public ResponseEntity<List<Airport>> getAirports(
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core1-api.log.message.key.1"));
    List<Airport> data =
        core1CoreService.getAirports(new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data) && !data.isEmpty()) {
      LOG.info(env.getProperty("core1-api.log.message.key.2"));
      return new ResponseEntity<List<Airport>>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core1-api.log.message.key.3"));
      return new ResponseEntity<List<Airport>>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @PostMapping(
      value = "/airports",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "", tags = "", response = Void.class)
  @ApiResponses({@ApiResponse(code = 201, message = "success")})
  public ResponseEntity<Void> postAirports(
      @ApiParam(value = "", required = true) @RequestBody Airport body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core1-api.log.message.key.4"));
    core1CoreService.postAirports(
        new ServiceRequestContext(headers, pathParams, queryParams, body));
    return new ResponseEntity<Void>(HttpStatus.CREATED);
  }

  /** */
  @GetMapping(
      value = "/airports/{airportId}",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "", tags = "", response = Airport.class)
  @ApiResponses({@ApiResponse(code = 200, message = "success")})
  public ResponseEntity<Airport> getAirport(
      @ApiParam(value = "", required = true) @PathVariable(value = "airportId", required = true)
          long airportId,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core1-api.log.message.key.5"));
    Airport data =
        core1CoreService.getAirport(
            airportId, new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("core1-api.log.message.key.2"));
      return new ResponseEntity<Airport>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core1-api.log.message.key.3"));
      return new ResponseEntity<Airport>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @PutMapping(
      value = "/airports/{airportId}",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "", tags = "", response = Void.class)
  @ApiResponses({@ApiResponse(code = 204, message = "success")})
  public ResponseEntity<Void> putAirport(
      @ApiParam(value = "", required = true) @PathVariable(value = "airportId", required = true)
          long airportId,
      @ApiParam(value = "", required = true) @RequestBody Airport body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core1-api.log.message.key.6"));
    core1CoreService.putAirport(
        airportId, new ServiceRequestContext(headers, pathParams, queryParams, body));
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }

  /** */
  @DeleteMapping(
      value = "/airports/{airportId}",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "", tags = "", response = Void.class)
  @ApiResponses({@ApiResponse(code = 204, message = "success")})
  public ResponseEntity<Void> deleteAirport(
      @ApiParam(value = "", required = true) @PathVariable(value = "airportId", required = true)
          long airportId,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core1-api.log.message.key.7"));
    core1CoreService.deleteAirport(
        airportId, new ServiceRequestContext(headers, pathParams, queryParams));
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
  }
}
