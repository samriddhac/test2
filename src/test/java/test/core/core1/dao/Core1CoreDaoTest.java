package test.core.core1.dao;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import test.core.core1.dao.config.TestConfiguration;
import test.core.core1.dao.entity.repository.Core1CoreDaoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
public class Core1CoreDaoTest {

  @Autowired private Core1CoreDao airportDao;
  @MockBean private Core1CoreDaoRepository core1CoreDaoRepository;
  @MockBean private MongoTemplate mongoTemplate;

  @Mock Query query = new Query();

  @Test
  public void testDummy() {
    // TODO: your code goes here...
    Assert.assertEquals(true, true);
  }
}
