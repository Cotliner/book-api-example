package com.khaled.bookapi.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.web.server.ServerHttpSecurity

@Configuration class AppConfig {

  @Bean fun securityWebFilterChain(
    http: ServerHttpSecurity
  ) = http
    .csrf().disable()
    .formLogin().disable()
    .httpBasic().disable()
    .build()
}