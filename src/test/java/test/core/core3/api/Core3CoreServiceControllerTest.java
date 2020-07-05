package test.core.core3.api;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.cognizant.cosmos.core.utils.execution.ServiceRequestContext;
import com.fasterxml.jackson.databind.ObjectMapper;

import test.core.core3.api.controller.Core3CoreServiceController;
import test.core.core3.model.Order;
import test.core.core3.model.Category;
import test.core.core3.model.User;
import test.core.core3.model.Tag;
import test.core.core3.model.Pet;
import test.core.core3.model.ApiResponse;
import test.core.core3.service.Core3CoreService;

@RunWith(SpringRunner.class)
@WebMvcTest(Core3CoreServiceController.class)
@PropertySource("classpath:log.messages")
public class Core3CoreServiceControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private Core3CoreService core3CoreService;
  private ObjectMapper mapper = new ObjectMapper();

  private static final Object DEFAULT_RETURN = 1;

  private static final long DEFAULT_ID = 111;
  private static final Category DEFAULT_CATEGORY = null;
  private static final String DEFAULT_NAME = "name";
  private static final List<String> DEFAULT_PHOTOURLS = null;
  private static final List<Tag> DEFAULT_TAGS = null;
  private static final Object DEFAULT_STATUS = null;

  private static final int DEFAULT_CODE = 111;
  private static final String DEFAULT_TYPE = "type";
  private static final String DEFAULT_MESSAGE = "message";

  private static final long DEFAULT_PETID = 111;
  private static final int DEFAULT_QUANTITY = 111;
  private static final Date DEFAULT_SHIPDATE = new Date();
  private static final boolean DEFAULT_COMPLETE = true;

  private static final String DEFAULT_USERNAME = "username";
  private static final String DEFAULT_FIRSTNAME = "firstName";
  private static final String DEFAULT_LASTNAME = "lastName";
  private static final String DEFAULT_EMAIL = "email";
  private static final String DEFAULT_PASSWORD = "password";
  private static final String DEFAULT_PHONE = "phone";
  private static final int DEFAULT_USERSTATUS = 111;

  private Pet defaultPet() {
    Pet body = new Pet();
    body.setId(DEFAULT_ID);
    body.setCategory(DEFAULT_CATEGORY);
    body.setName(DEFAULT_NAME);
    body.setPhotoUrls(DEFAULT_PHOTOURLS);
    body.setTags(DEFAULT_TAGS);
    return body;
  }

  @Test
  public void testAddPet() throws Exception {
    Mockito.doNothing().when(core3CoreService).addPet(Mockito.any(ServiceRequestContext.class));
    java.lang.String requestBody = mapper.writeValueAsString(defaultPet());
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/pet")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testUpdatePet() throws Exception {
    Mockito.doNothing().when(core3CoreService).updatePet(Mockito.any(ServiceRequestContext.class));
    java.lang.String requestBody = mapper.writeValueAsString(defaultPet());
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/pet")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testFindPetsByStatus() throws Exception {
    Mockito.when(core3CoreService.findPetsByStatus(Mockito.any(ServiceRequestContext.class)))
        .thenReturn(Arrays.asList(defaultPet()));
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/pet/findByStatus")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .param("status", "null"))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testFindPetsByTags() throws Exception {
    Mockito.when(core3CoreService.findPetsByTags(Mockito.any(ServiceRequestContext.class)))
        .thenReturn(Arrays.asList(defaultPet()));
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/pet/findByTags")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .param("tags", "null"))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testGetPetById() throws Exception {
    Mockito.when(
            core3CoreService.getPetById(
                Mockito.any(long.class), Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultPet());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/pet/111")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testUpdatePetWithForm() throws Exception {
    Mockito.doNothing()
        .when(core3CoreService)
        .updatePetWithForm(Mockito.any(long.class), Mockito.any(ServiceRequestContext.class));
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/pet/111")
                .accept(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testDeletePet() throws Exception {
    Mockito.doNothing()
        .when(core3CoreService)
        .deletePet(Mockito.any(long.class), Mockito.any(ServiceRequestContext.class));
    mockMvc
        .perform(
            MockMvcRequestBuilders.delete("/pet/111")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  private ApiResponse defaultApiResponse() {
    ApiResponse apiResponse = new ApiResponse();
    apiResponse.setCode(DEFAULT_CODE);
    apiResponse.setType(DEFAULT_TYPE);
    apiResponse.setMessage(DEFAULT_MESSAGE);
    return apiResponse;
  }

  @Test
  public void testUploadFile() throws Exception {
    Mockito.when(
            core3CoreService.uploadFile(
                Mockito.any(long.class), Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultApiResponse());
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/pet/111/uploadImage")
                .accept(multipart / form - data)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  private Object defaultObject() {
    Object object = new Object();
    return object;
  }

  @Test
  public void testGetInventory() throws Exception {
    Mockito.when(core3CoreService.getInventory(Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultObject());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/store/inventory")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  private Order defaultOrder() {
    Order order = new Order();
    order.setId(DEFAULT_ID);
    order.setPetId(DEFAULT_PETID);
    order.setQuantity(DEFAULT_QUANTITY);
    order.setShipDate(DEFAULT_SHIPDATE);
    order.setComplete(DEFAULT_COMPLETE);
    return order;
  }

  @Test
  public void testPlaceOrder() throws Exception {
    Mockito.when(core3CoreService.placeOrder(Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultOrder());
    java.lang.String requestBody = mapper.writeValueAsString(defaultOrder());
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/store/order")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testGetOrderById() throws Exception {
    Mockito.when(
            core3CoreService.getOrderById(
                Mockito.any(long.class), Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultOrder());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/store/order/111")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testDeleteOrder() throws Exception {
    Mockito.doNothing()
        .when(core3CoreService)
        .deleteOrder(Mockito.any(long.class), Mockito.any(ServiceRequestContext.class));
    mockMvc
        .perform(
            MockMvcRequestBuilders.delete("/store/order/111")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  private User defaultUser() {
    User body = new User();
    body.setId(DEFAULT_ID);
    body.setUsername(DEFAULT_USERNAME);
    body.setFirstName(DEFAULT_FIRSTNAME);
    body.setLastName(DEFAULT_LASTNAME);
    body.setEmail(DEFAULT_EMAIL);
    body.setPassword(DEFAULT_PASSWORD);
    body.setPhone(DEFAULT_PHONE);
    body.setUserStatus(DEFAULT_USERSTATUS);
    return body;
  }

  @Test
  public void testCreateUser() throws Exception {
    Mockito.doNothing().when(core3CoreService).createUser(Mockito.any(ServiceRequestContext.class));
    java.lang.String requestBody = mapper.writeValueAsString(defaultUser());
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/user")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  private ArrayList<User> defaultUserList() {
    ArrayList<User> body = new ArrayList<User>();
    return body;
  }

  @Test
  public void testCreateUsersWithArrayInput() throws Exception {
    Mockito.doNothing()
        .when(core3CoreService)
        .createUsersWithArrayInput(Mockito.any(ServiceRequestContext.class));
    java.lang.String requestBody = mapper.writeValueAsString(defaultUserList());
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/user/createWithArray")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testCreateUsersWithListInput() throws Exception {
    Mockito.doNothing()
        .when(core3CoreService)
        .createUsersWithListInput(Mockito.any(ServiceRequestContext.class));
    java.lang.String requestBody = mapper.writeValueAsString(defaultUserList());
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/user/createWithList")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testLoginUser() throws Exception {
    Mockito.when(core3CoreService.loginUser(Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultObject());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/user/login")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .param("username", "abc")
                .param("password", "abc"))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testLogoutUser() throws Exception {
    Mockito.doNothing().when(core3CoreService).logoutUser(Mockito.any(ServiceRequestContext.class));
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/user/logout")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testGetUserByName() throws Exception {
    Mockito.when(
            core3CoreService.getUserByName(
                Mockito.any(String.class), Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultUser());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/user/abc")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testUpdateUser() throws Exception {
    Mockito.doNothing()
        .when(core3CoreService)
        .updateUser(Mockito.any(String.class), Mockito.any(ServiceRequestContext.class));
    java.lang.String requestBody = mapper.writeValueAsString(defaultUser());
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/user/abc")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testDeleteUser() throws Exception {
    Mockito.doNothing()
        .when(core3CoreService)
        .deleteUser(Mockito.any(String.class), Mockito.any(ServiceRequestContext.class));
    mockMvc
        .perform(
            MockMvcRequestBuilders.delete("/user/abc")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_XML_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }
}
