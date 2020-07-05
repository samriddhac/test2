package test.core.core3.api.controller;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.util.*;
import org.springframework.web.bind.annotation.*;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;

import test.core.core3.model.*;
import test.core.core3.service.Core3CoreService;
import io.swagger.annotations.*;
import springfox.documentation.annotations.ApiIgnore;

/** */
@RestController
@Api("swagger-petstore")
public class Core3CoreServiceController {

  private static final Logger LOG = LoggerFactory.getLogger(Core3CoreServiceController.class);
  @Autowired private Environment env;
  @Autowired private Core3CoreService core3CoreService;

  /** */
  @PostMapping(
      value = "/pet",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Add a new pet to the store",
      tags = {"pet"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 405, message = "Invalid input")})
  public ResponseEntity<Void> addPet(
      @ApiParam(value = "Pet object that needs to be added to the store", required = true)
          @RequestBody
          Pet body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.1"));
    core3CoreService.addPet(new ServiceRequestContext(headers, pathParams, queryParams, body));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @PutMapping(
      value = "/pet",
      consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Update an existing pet",
      tags = {"pet"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Pet not found"),
    @ApiResponse(code = 405, message = "Validation exception")
  })
  public ResponseEntity<Void> updatePet(
      @ApiParam(value = "Pet object that needs to be added to the store", required = true)
          @RequestBody
          Pet body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.4"));
    core3CoreService.updatePet(new ServiceRequestContext(headers, pathParams, queryParams, body));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @GetMapping(
      value = "/pet/findByStatus",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Finds Pets by status",
      tags = {"pet"},
      response = Pet.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid status value")
  })
  public ResponseEntity<List<Pet>> findPetsByStatus(
      @ApiParam(value = "Status values that need to be considered for filter", required = true)
          @RequestParam(value = "status", required = true)
          String status,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.5"));
    List<Pet> data =
        core3CoreService.findPetsByStatus(
            new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data) && !data.isEmpty()) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<List<Pet>>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<List<Pet>>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @GetMapping(
      value = "/pet/findByTags",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Finds Pets by tags",
      tags = {"pet"},
      response = Pet.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid tag value")
  })
  public ResponseEntity<List<Pet>> findPetsByTags(
      @ApiParam(value = "Tags to filter by", required = true)
          @RequestParam(value = "tags", required = true)
          String tags,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.6"));
    List<Pet> data =
        core3CoreService.findPetsByTags(
            new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data) && !data.isEmpty()) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<List<Pet>>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<List<Pet>>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @GetMapping(
      value = "/pet/{petId}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Find pet by ID",
      tags = {"pet"},
      response = Pet.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Pet not found")
  })
  public ResponseEntity<Pet> getPetById(
      @ApiParam(value = "ID of pet to return", required = true)
          @PathVariable(value = "petId", required = true)
          long petId,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.7"));
    Pet data =
        core3CoreService.getPetById(
            petId, new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<Pet>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<Pet>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @PostMapping(
      value = "/pet/{petId}",
      consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE},
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Updates a pet in the store with form data",
      tags = {"pet"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 405, message = "Invalid input")})
  public ResponseEntity<Void> updatePetWithForm(
      @ApiParam(value = "ID of pet that needs to be updated", required = true)
          @PathVariable(value = "petId", required = true)
          long petId,
      @ApiParam(value = "Updated name of the pet", required = true) String name,
      @ApiParam(value = "Updated status of the pet", required = true) String status,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.8"));
    core3CoreService.updatePetWithForm(
        petId, new ServiceRequestContext(headers, pathParams, queryParams));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @DeleteMapping(
      value = "/pet/{petId}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Deletes a pet",
      tags = {"pet"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Pet not found")
  })
  public ResponseEntity<Void> deletePet(
      @ApiParam(value = "", required = true) String api_key,
      @ApiParam(value = "Pet id to delete", required = true)
          @PathVariable(value = "petId", required = true)
          long petId,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.9"));
    core3CoreService.deletePet(petId, new ServiceRequestContext(headers, pathParams, queryParams));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @PostMapping(
      value = "/pet/{petId}/uploadImage",
      consumes = {"multipart/form-data"},
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "uploads an image",
      tags = {"pet"},
      response = ApiResponse.class)
  @ApiResponses({@ApiResponse(code = 200, message = "successful operation")})
  public ResponseEntity<ApiResponse> uploadFile(
      @ApiParam(value = "ID of pet to update", required = true)
          @PathVariable(value = "petId", required = true)
          long petId,
      @ApiParam(value = "Additional data to pass to server", required = true)
          String additionalMetadata,
      @ApiParam(value = "file to upload", required = true) Object file,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.10"));
    ApiResponse data =
        core3CoreService.uploadFile(
            petId, new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<ApiResponse>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<ApiResponse>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @GetMapping(
      value = "/store/inventory",
      produces = {MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Returns pet inventories by status",
      tags = {"store"},
      response = Object.class)
  @ApiResponses({@ApiResponse(code = 200, message = "successful operation")})
  public ResponseEntity<Object> getInventory(
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.11"));
    Object data =
        core3CoreService.getInventory(new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<Object>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
  }

  /** */
  @PostMapping(
      value = "/store/order",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Place an order for a pet",
      tags = {"store"},
      response = Order.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid Order")
  })
  public ResponseEntity<Order> placeOrder(
      @ApiParam(value = "order placed for purchasing the pet", required = true) @RequestBody
          Order body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.12"));
    Order data =
        core3CoreService.placeOrder(
            new ServiceRequestContext(headers, pathParams, queryParams, body));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<Order>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @GetMapping(
      value = "/store/order/{orderId}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Find purchase order by ID",
      tags = {"store"},
      response = Order.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Order not found")
  })
  public ResponseEntity<Order> getOrderById(
      @ApiParam(value = "ID of pet that needs to be fetched", required = true)
          @PathVariable(value = "orderId", required = true)
          long orderId,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.13"));
    Order data =
        core3CoreService.getOrderById(
            orderId, new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<Order>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<Order>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @DeleteMapping(
      value = "/store/order/{orderId}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Delete purchase order by ID",
      tags = {"store"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid ID supplied"),
    @ApiResponse(code = 404, message = "Order not found")
  })
  public ResponseEntity<Void> deleteOrder(
      @ApiParam(value = "ID of the order that needs to be deleted", required = true)
          @PathVariable(value = "orderId", required = true)
          long orderId,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.14"));
    core3CoreService.deleteOrder(
        orderId, new ServiceRequestContext(headers, pathParams, queryParams));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @PostMapping(
      value = "/user",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Create user",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 500, message = "successful operation")})
  public ResponseEntity<Void> createUser(
      @ApiParam(value = "Created user object", required = true) @RequestBody User body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.15"));
    core3CoreService.createUser(new ServiceRequestContext(headers, pathParams, queryParams, body));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @PostMapping(
      value = "/user/createWithArray",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Creates list of users with given input array",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 500, message = "successful operation")})
  public ResponseEntity<Void> createUsersWithArrayInput(
      @ApiParam(value = "List of user object", required = true) @RequestBody List<User> body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.16"));
    core3CoreService.createUsersWithArrayInput(
        new ServiceRequestContext(headers, pathParams, queryParams, body));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @PostMapping(
      value = "/user/createWithList",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Creates list of users with given input array",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 500, message = "successful operation")})
  public ResponseEntity<Void> createUsersWithListInput(
      @ApiParam(value = "List of user object", required = true) @RequestBody List<User> body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.17"));
    core3CoreService.createUsersWithListInput(
        new ServiceRequestContext(headers, pathParams, queryParams, body));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @GetMapping(
      value = "/user/login",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Logs user into the system",
      tags = {"user"},
      response = Object.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid username/password supplied")
  })
  public ResponseEntity<Object> loginUser(
      @ApiParam(value = "The user name for login", required = true)
          @RequestParam(value = "username", required = true)
          String username,
      @ApiParam(value = "The password for login in clear text", required = true)
          @RequestParam(value = "password", required = true)
          String password,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.18"));
    Object data =
        core3CoreService.loginUser(new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<Object>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @GetMapping(
      value = "/user/logout",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Logs out current logged in user session",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({@ApiResponse(code = 500, message = "successful operation")})
  public ResponseEntity<Void> logoutUser(
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.19"));
    core3CoreService.logoutUser(new ServiceRequestContext(headers, pathParams, queryParams));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @GetMapping(
      value = "/user/{username}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Get user by user name",
      tags = {"user"},
      response = User.class)
  @ApiResponses({
    @ApiResponse(code = 200, message = "successful operation"),
    @ApiResponse(code = 400, message = "Invalid username supplied"),
    @ApiResponse(code = 404, message = "User not found")
  })
  public ResponseEntity<User> getUserByName(
      @ApiParam(
              value = "The name that needs to be fetched. Use user1 for testing. ",
              required = true)
          @PathVariable(value = "username", required = true)
          String username,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.20"));
    User data =
        core3CoreService.getUserByName(
            username, new ServiceRequestContext(headers, pathParams, queryParams));
    if (!Objects.isNull(data)) {
      LOG.info(env.getProperty("core3-api.log.message.key.2"));
      return new ResponseEntity<User>(data, HttpStatus.OK);
    } else {
      LOG.info(env.getProperty("core3-api.log.message.key.3"));
      return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    }
  }

  /** */
  @PutMapping(
      value = "/user/{username}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Updated user",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid user supplied"),
    @ApiResponse(code = 404, message = "User not found")
  })
  public ResponseEntity<Void> updateUser(
      @ApiParam(value = "name that need to be updated", required = true)
          @PathVariable(value = "username", required = true)
          String username,
      @ApiParam(value = "Updated user object", required = true) @RequestBody User body,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.21"));
    core3CoreService.updateUser(
        username, new ServiceRequestContext(headers, pathParams, queryParams, body));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }

  /** */
  @DeleteMapping(
      value = "/user/{username}",
      produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
  @ApiOperation(
      value = "Delete user",
      tags = {"user"},
      response = Void.class)
  @ApiResponses({
    @ApiResponse(code = 400, message = "Invalid username supplied"),
    @ApiResponse(code = 404, message = "User not found")
  })
  public ResponseEntity<Void> deleteUser(
      @ApiParam(value = "The name that needs to be deleted", required = true)
          @PathVariable(value = "username", required = true)
          String username,
      @ApiIgnore @RequestHeader(required = false) HttpHeaders headers,
      @ApiIgnore @PathVariable(required = false) Map<String, String> pathParams,
      @ApiIgnore @RequestParam(required = false) MultiValueMap<String, String> queryParams) {

    LOG.info(env.getProperty("core3-api.log.message.key.22"));
    core3CoreService.deleteUser(
        username, new ServiceRequestContext(headers, pathParams, queryParams));
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
}
