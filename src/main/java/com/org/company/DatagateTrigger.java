package com.org.company;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatagateTrigger {

  @Autowired
  DataSource dataSource;

  @Bean
  public SpringLiquibase liquibase() {
    SpringLiquibase liquibase = new SpringLiquibase();
    liquibase.setChangeLog("classpath:db/log/changelog.yml");
    liquibase.setDataSource(dataSource);
    liquibase.setDefaultSchema("liquibase");
    return liquibase;
  }
}
