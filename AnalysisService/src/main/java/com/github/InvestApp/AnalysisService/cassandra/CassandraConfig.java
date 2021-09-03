package com.github.InvestApp.AnalysisService.cassandra;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.AbstractReactiveCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;




@EnableReactiveCassandraRepositories
@Configuration
@PropertySource("classpath:application.properties")
public class CassandraConfig extends AbstractReactiveCassandraConfiguration {

  @Value("${cassandra.keyspace-name}")
    private String keyspace;

  @Value("${cassandra.contact-points}")
  private String contactPoint;

  // @Value("${spring.data.cassandra.schema-action}")
  // private SchemaAction schemaAction = SchemaAction.CREATE_IF_NOT_EXISTS;

  @Override
  protected String getKeyspaceName() {
    return keyspace;
  }

   public String[] getEntityBasePackage() {
     return new String[] {"com.github.InvestApp.AnalysisService.domain"};
  }

  @Override
  protected String getContactPoints() {
    return contactPoint;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.CREATE_IF_NOT_EXISTS;
  }

}