package cn.liangyy.myblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn/liangyy/myblog/mapper")
@SpringBootApplication
public class MyblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyblogApplication.class, args);
    }

}
