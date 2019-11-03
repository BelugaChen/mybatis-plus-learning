package com.beluga.mybatisplus02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 陈健Beluga
 */
@SpringBootApplication
@MapperScan("com.beluga.mybatisplus02.mapper")
public class MybatisPlus02Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus02Application.class, args);
    }

}
