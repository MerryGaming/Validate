package org.aibles.validator.configuration;

import org.aibles.validator.repository.UserRepository;
import org.aibles.validator.service.UserService;
import org.aibles.validator.service.impl.UserServiceImpl;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@Configuration
@ComponentScan(basePackages = {"org.aibles.validator.repository"})
@EnableJpaRepositories(basePackages = {"org.aibles.validator.repository"})
public class UserConfiguration {


 @Bean
  public UserService userService(UserRepository repository) {
   return new UserServiceImpl(repository);
 }




}
