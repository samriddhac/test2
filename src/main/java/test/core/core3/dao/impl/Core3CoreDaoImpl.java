package test.core.core3.dao.impl;

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
import test.core.core3.dao.entity.repository.Core3CoreDaoRepository;

import test.core.core3.dao.Core3CoreDao;

/** Name:-Core3CoreImpl */
@Repository
@EnableMongoRepositories(basePackages = "test.core.core3.dao")
public class Core3CoreDaoImpl implements Core3CoreDao {

  private static final Logger LOG = LoggerFactory.getLogger(Core3CoreDaoImpl.class);

  @Autowired private Environment env;
  @Autowired private Core3CoreDaoRepository core3CoreDaoRepository;

  @Autowired MongoTemplate mongoTemplate;
}
