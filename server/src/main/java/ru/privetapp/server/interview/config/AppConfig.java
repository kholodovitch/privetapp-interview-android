package ru.privetapp.server.interview.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("ru.privetapp")
@EnableWebMvc
public class AppConfig {
}