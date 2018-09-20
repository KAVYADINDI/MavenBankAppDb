package com.capgemini.bankApp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages={"com.capgemini.bankApp"})
@PropertySource("Application.properties")
public class AppConfig {

}