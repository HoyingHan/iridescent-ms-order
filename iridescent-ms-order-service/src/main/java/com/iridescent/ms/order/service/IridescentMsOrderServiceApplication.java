package com.iridescent.ms.order.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;



/**
 * Description:
 *
 * @author  陌北有棵树
 * @version 2019/3/11
 */


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.iridescent.ms.product.api","com.iridescent.ms.order.api",
                                "com.iridescent.ms.order.service.service"})
@EnableFeignClients(basePackages = {"com.iridescent.ms.product.api"})

@Slf4j
public class IridescentMsOrderServiceApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(IridescentMsOrderServiceApplication.class, args);
        String[] beanNames = context.getBeanDefinitionNames();
        log.info("bean总数:{}", context.getBeanDefinitionCount());
        int i = 0;
        for (String str : beanNames) {
            log.info("{},beanName:{}", ++i, str);
        }


    }

}
