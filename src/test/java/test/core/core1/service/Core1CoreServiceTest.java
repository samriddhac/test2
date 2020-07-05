package test.core.core1.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import test.core.core1.dao.Core1CoreDao;
import test.core.core1.service.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class Core1CoreServiceTest {

  @Autowired private Core1CoreService core1CoreService;
  @MockBean private Core1CoreDao core1CoreDAO;

  @Test
  public void testGetAirports() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testPostAirports() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetAirport() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testPutAirport() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeleteAirport() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }
}
