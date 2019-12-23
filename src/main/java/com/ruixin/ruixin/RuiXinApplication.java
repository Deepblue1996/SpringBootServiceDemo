package com.ruixin.ruixin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 使用内部Tomcat
 * 直接 @SpringBootApplication 即可
 *
 * 使用外部Tomcat
 * 1：继承 @{ org.springframework.boot.web.servlet.support.SpringBootServletInitializer };
 * 2: 重写configure函数，定位Class.
 */
@SpringBootApplication
public class RuiXinApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RuiXinApplication.class, args);
    }

    //重写configure方法
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RuiXinApplication.class);
    }
}
