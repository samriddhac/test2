package test.core.core3.service;

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

import test.core.core3.dao.Core3CoreDao;
import test.core.core3.service.config.TestConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class Core3CoreServiceTest {

  @Autowired private Core3CoreService core3CoreService;
  @MockBean private Core3CoreDao core3CoreDAO;

  @Test
  public void testAddPet() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUpdatePet() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testFindPetsByStatus() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testFindPetsByTags() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetPetById() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUpdatePetWithForm() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeletePet() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUploadFile() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetInventory() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testPlaceOrder() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetOrderById() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeleteOrder() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testCreateUser() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testCreateUsersWithArrayInput() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testCreateUsersWithListInput() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testLoginUser() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testLogoutUser() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testGetUserByName() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testUpdateUser() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }

  @Test
  public void testDeleteUser() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }
}
