package test.composite.test.api.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;

import test.composite.test.model.*;
import test.composite.test.api.ITestCompositeService;

import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/** */
@RestController
@Api("transfer-service")
public class TestCompositeServiceController {

  private static final Logger LOG = LoggerFactory.getLogger(TestCompositeServiceController.class);
  @Autowired private Environment env;
  @Autowired private ITestCompositeService testCompositeService;

  /** */
  @PostMapping(
      value = "/accounts/source",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "Find source accounts", tags = "", response = TransferInfo.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "All source accounts for user successfully returned")
  })
  public ResponseEntity<TransferInfo> findSourceAccounts(
      @ApiParam(value = "", required = true) @RequestBody TransferInfo body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("transfer-service.log.message.key.1"));
    TransferInfo data =
        (TransferInfo)
            testCompositeService
                .findSourceAccounts(
                    new ServiceRequestContext(headers, pathParams, queryParams, body))
                .getBody();
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("transfer-service.log.message.key.2"));
      return new ResponseEntity<TransferInfo>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("transfer-service.log.message.key.3"));
      return new ResponseEntity<TransferInfo>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @PostMapping(
      value = "/accounts/target",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "Find target accounts", tags = "", response = TransferInfo.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "All target accounts for user successfully returned")
  })
  public ResponseEntity<TransferInfo> findTargetAccounts(
      @ApiParam(value = "", required = true) @RequestBody TransferInfo body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("transfer-service.log.message.key.4"));
    TransferInfo data =
        (TransferInfo)
            testCompositeService
                .findTargetAccounts(
                    new ServiceRequestContext(headers, pathParams, queryParams, body))
                .getBody();
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("transfer-service.log.message.key.2"));
      return new ResponseEntity<TransferInfo>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("transfer-service.log.message.key.3"));
      return new ResponseEntity<TransferInfo>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @PostMapping(
      value = "/attributes/find",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Display fund transfer attributes",
      tags = "",
      response = TransferInfo.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "All fund transfer attributes successfully returned")
  })
  public ResponseEntity<TransferInfo> findAttributes(
      @ApiParam(value = "", required = true) @RequestBody TransferInfo body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("transfer-service.log.message.key.5"));
    TransferInfo data =
        (TransferInfo)
            testCompositeService
                .findAttributes(new ServiceRequestContext(headers, pathParams, queryParams, body))
                .getBody();
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("transfer-service.log.message.key.2"));
      return new ResponseEntity<TransferInfo>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("transfer-service.log.message.key.3"));
      return new ResponseEntity<TransferInfo>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @PostMapping(
      value = "/attributes/validate",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Validate fund transfer attributes",
      tags = "",
      response = TransferInfo.class)
  @ApiResponses({@ApiResponse(code = 200, message = "All fund transfer attributes validated")})
  public ResponseEntity<TransferInfo> validateAttributes(
      @ApiParam(value = "", required = true) @RequestBody TransferInfo body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("transfer-service.log.message.key.6"));
    TransferInfo data =
        (TransferInfo)
            testCompositeService
                .validateAttributes(
                    new ServiceRequestContext(headers, pathParams, queryParams, body))
                .getBody();
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("transfer-service.log.message.key.2"));
      return new ResponseEntity<TransferInfo>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("transfer-service.log.message.key.3"));
      return new ResponseEntity<TransferInfo>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @GetMapping(
      value = "/profiles",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "Find transfer profiles", tags = "", response = Profile.class)
  @ApiResponses({@ApiResponse(code = 200, message = "All transfer profiles successfully returned")})
  public ResponseEntity<List<Profile>> findProfiles(
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("transfer-service.log.message.key.7"));
    List<Profile> data =
        (List<Profile>)
            testCompositeService
                .findProfiles(new ServiceRequestContext(headers, pathParams, queryParams))
                .getBody();
    if (!Objects.isNull(data) && !data.isEmpty()) {
      LOG.info(env.getProperty("transfer-service.log.message.key.2"));
      return new ResponseEntity<List<Profile>>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("transfer-service.log.message.key.3"));
      return new ResponseEntity<List<Profile>>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @PostMapping(
      value = "/profiles",
      consumes = {MediaType.APPLICATION_JSON_VALUE},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(value = "Create transfer profile", tags = "", response = Profile.class)
  @ApiResponses({@ApiResponse(code = 200, message = "Transfer profile created sussessfully")})
  public ResponseEntity<Profile> createProfile(
      @ApiParam(value = "", required = true) @RequestBody TransferInfo body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("transfer-service.log.message.key.8"));
    Profile data =
        (Profile)
            testCompositeService
                .createProfile(new ServiceRequestContext(headers, pathParams, queryParams, body))
                .getBody();
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("transfer-service.log.message.key.2"));
      return new ResponseEntity<Profile>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("transfer-service.log.message.key.3"));
      return new ResponseEntity<Profile>(HttpStatus.NOT_FOUND);
    }
  }
}
