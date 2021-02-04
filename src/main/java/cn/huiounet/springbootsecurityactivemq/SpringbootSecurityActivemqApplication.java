package cn.huiounet.springbootsecurityactivemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("cn.huiounet.springbootsecurityactivemq.dao")
@EnableJms
public class SpringbootSecurityActivemqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSecurityActivemqApplication.class, args);
    }

}
