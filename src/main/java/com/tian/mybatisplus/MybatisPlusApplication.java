package com.tian.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.tian.mybatisplus.dao")//默认扫描
@MapperScan("com.tian.mybatisplus.ts.mapper")//测试自动生成代码ts包扫描
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
