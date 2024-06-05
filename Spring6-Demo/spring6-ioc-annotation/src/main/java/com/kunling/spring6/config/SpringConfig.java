package com.kunling.spring6.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration  // 配置类
@ComponentScan("com.kunling.spring6")   // 也可以在配置文件中开启扫描
public class SpringConfig {
}
