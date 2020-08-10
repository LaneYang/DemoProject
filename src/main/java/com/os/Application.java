package com.os;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author youyuan.lv
 */

@SpringBootApplication
@MapperScan("com.os.dao")
public class Application {


    // SpringBoot启动器
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
