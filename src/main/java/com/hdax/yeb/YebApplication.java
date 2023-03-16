package com.hdax.yeb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.hdax.yeb.dao")
public class YebApplication {

    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class, args);

//        Logger logger = LoggerFactory.getLogger(CmfzMenuServiceImpl.class);使用日志
    }

}
