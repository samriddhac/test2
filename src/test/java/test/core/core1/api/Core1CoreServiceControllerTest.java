package test.core.core1.api;

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

import test.core.core1.api.controller.Core1CoreServiceController;
import test.core.core1.model.Airport;
import test.core.core1.service.Core1CoreService;

@RunWith(SpringRunner.class)
@WebMvcTest(Core1CoreServiceController.class)
@PropertySource("classpath:log.messages")
public class Core1CoreServiceControllerTest {

  @Autowired private MockMvc mockMvc;
  @MockBean private Core1CoreService core1CoreService;
  private ObjectMapper mapper = new ObjectMapper();

  private static final Object DEFAULT_RETURN = 1;

  private static final long DEFAULT_ID = 111;
  private static final long DEFAULT_CITYID = 111;
  private static final String DEFAULT_IATACODE = "iataCode";
  private static final String DEFAULT_NAME = "name";
  private static final String DEFAULT_STATUS = "status";
  private static final double DEFAULT_LATITUDE = 111.10;
  private static final double DEFAULT_LONGITUDE = 111.10;
  private static final String DEFAULT_URL = "url";

  private Airport defaultAirport() {
    Airport airport = new Airport();
    airport.setId(DEFAULT_ID);
    airport.setCityId(DEFAULT_CITYID);
    airport.setIataCode(DEFAULT_IATACODE);
    airport.setName(DEFAULT_NAME);
    airport.setStatus(DEFAULT_STATUS);
    airport.setLatitude(DEFAULT_LATITUDE);
    airport.setLongitude(DEFAULT_LONGITUDE);
    airport.setUrl(DEFAULT_URL);
    return airport;
  }

  @Test
  public void testGetAirports() throws Exception {
    Mockito.when(core1CoreService.getAirports(Mockito.any(ServiceRequestContext.class)))
        .thenReturn(Arrays.asList(defaultAirport()));
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/airports")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testPostAirports() throws Exception {
    Mockito.doNothing()
        .when(core1CoreService)
        .postAirports(Mockito.any(ServiceRequestContext.class));
    java.lang.String requestBody = mapper.writeValueAsString(defaultAirport());
    mockMvc
        .perform(
            MockMvcRequestBuilders.post("/airports")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.CREATED.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testGetAirport() throws Exception {
    Mockito.when(
            core1CoreService.getAirport(
                Mockito.any(long.class), Mockito.any(ServiceRequestContext.class)))
        .thenReturn(defaultAirport());
    mockMvc
        .perform(
            MockMvcRequestBuilders.get("/airports/111")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testPutAirport() throws Exception {
    Mockito.doNothing()
        .when(core1CoreService)
        .putAirport(Mockito.any(long.class), Mockito.any(ServiceRequestContext.class));
    java.lang.String requestBody = mapper.writeValueAsString(defaultAirport());
    mockMvc
        .perform(
            MockMvcRequestBuilders.put("/airports/111")
                .content(requestBody)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NO_CONTENT.value()))
        .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void testDeleteAirport() throws Exception {
    Mockito.doNothing()
        .when(core1CoreService)
        .deleteAirport(Mockito.any(long.class), Mockito.any(ServiceRequestContext.class));
    mockMvc
        .perform(
            MockMvcRequestBuilders.delete("/airports/111")
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
        .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NO_CONTENT.value()))
        .andDo(MockMvcResultHandlers.print());
  }
}
