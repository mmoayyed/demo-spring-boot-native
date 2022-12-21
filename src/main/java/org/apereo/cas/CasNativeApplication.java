package org.apereo.cas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(proxyBeanMethods = false)
@EnableScheduling
public class CasNativeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CasNativeApplication.class, args);
    }
}
