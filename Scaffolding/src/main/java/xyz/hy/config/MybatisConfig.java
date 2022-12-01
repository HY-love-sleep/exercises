package xyz.hy.config;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：hongyan
 * @date ：Created in 2022/12/1 18:49
 * @description：mybatis配置类
 */
@Configuration
@MapperScan("xyz.hy.mapper")
public class MybatisConfig {
}
