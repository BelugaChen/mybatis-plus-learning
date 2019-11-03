package com.beluga.mybatisplus03autogenerator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 陈健Beluga
 */
@SpringBootApplication
@MapperScan("com.beluga.mybatisplus03autogenerator.mapper")
public class MybatisPlus03AutoGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus03AutoGeneratorApplication.class, args);
    }

}
