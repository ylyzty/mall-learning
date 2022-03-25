package com.nudt.demo_01.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Lzy
 * @Time: 2022/3/14
 */

/**
 * @Configuration: 定义配置类, 该类内部包含多个@Bean注解的方法, 将被扫描并用于构建bean, 初始化Spring容器
 * @MapperScan: 指定路径下的所有接口都会自动生成相应的实现类
 */
@Configuration
@MapperScan("com.nudt.demo_01.mbg.mapper")
public class MyBatisConfig {
}
