package com.nudt.demo_02.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Lzy
 * @Time: 2022/4/12
 */
@Configuration
@MapperScan("com.nudt.demo_02.mapper")
public class MyBatisConfig {
}
