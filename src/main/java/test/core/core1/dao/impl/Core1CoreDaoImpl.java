package test.core.core1.dao.impl;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import test.core.core1.dao.entity.repository.Core1CoreDaoRepository;

import test.core.core1.dao.Core1CoreDao;

/** Name:-Core1CoreImpl */
@Repository
@EnableMongoRepositories(basePackages = "test.core.core1.dao")
public class Core1CoreDaoImpl implements Core1CoreDao {

  private static final Logger LOG = LoggerFactory.getLogger(Core1CoreDaoImpl.class);

  @Autowired private Environment env;
  @Autowired private Core1CoreDaoRepository core1CoreDaoRepository;

  @Autowired MongoTemplate mongoTemplate;
}
