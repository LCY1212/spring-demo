package com.practice.conf;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "com.practice")
@EnableAspectJAutoProxy
@PropertySource("jdbc.properties")
@Import(JdbcConfig.class)
public class SpringConfig {

}
