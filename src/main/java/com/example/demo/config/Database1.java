package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Database1 {
  private static final String DATABASE1_DATASOURE = "db1";
  private static final String DATABASE1_TEMPLATE = "db1Template";

  @Bean(DATABASE1_DATASOURE)
  @ConfigurationProperties(prefix = "spring.datasource.db1")
  public DataSource createDataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(DATABASE1_TEMPLATE)
  public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
