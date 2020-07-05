package test.core.core3.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends AbstractMongoConfiguration {

  @Value("${spring.data.mongodb.host}")
  private String mongoHost;

  @Value("${spring.data.mongodb.port}")
  private String mongoPort;

  @Value("${spring.data.mongodb.database}")
  private String mongoDB;

  @Override
  protected String getDatabaseName() {
    return mongoDB;
  }

  @Override
  public MongoClient mongoClient() {
    return new MongoClient(mongoHost, Integer.parseInt(mongoPort));
  }

  @Override
  protected String getMappingBasePackage() {
    return "demo.cosmos.core.airport.dao";
  }

  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongoClient(), getDatabaseName());
  }
}
