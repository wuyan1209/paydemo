package com.example.demo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;

/*
这是一个控制层
* 支付主控(启动的时候一定要把main方法的注释去掉，配置好支付宝、微信以及银联相关参数)
*
* */
@EnableDubboConfiguration
@SpringBootApplication
//@ImportResource({"classpath:spring-context-dubbo.xml"})
public class PaydemoApplication extends WebMvcConfigurerAdapter {
    private static final Logger logger = Logger.getLogger(PaydemoApplication.class);

    public static void main(String[] args) throws InterruptedException,
            IOException {
        SpringApplication.run(PaydemoApplication.class, args);
        logger.info("支付项目启动 ");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/cert/**").addResourceLocations(
                "classpath:/cert/");
        super.addResourceHandlers(registry);
        logger.info("自定义静态资源目录,这只是个Demo,生产肯定不会暴露");
    }

}
