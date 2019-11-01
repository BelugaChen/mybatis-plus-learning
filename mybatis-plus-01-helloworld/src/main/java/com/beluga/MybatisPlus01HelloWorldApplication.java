package com.beluga;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 陈健Beluga
 */
@SpringBootApplication
@MapperScan("com.beluga.mapper")
public class MybatisPlus01HelloWorldApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlus01HelloWorldApplication.class, args);
    }

}
