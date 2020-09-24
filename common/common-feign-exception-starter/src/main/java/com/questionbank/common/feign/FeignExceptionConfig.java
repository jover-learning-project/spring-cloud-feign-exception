package com.questionbank.common.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionbank.common.feign.comsumer.handler.FeignExceptionConsumerErrorDecoder;
import com.questionbank.common.feign.provider.config.FeignExceptionProviderHandler;
import feign.codec.ErrorDecoder;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Slf4j
@Configuration
public class FeignExceptionConfig {

    @Value("${feign-exception.debug:false}")
    private Boolean debug;

    @Value("feign-exception.provider.enable:true")
    private Boolean enableProvider;

//    @Value("feign-exception.consumer.enable:true")
//    private Boolean enableConsumer;

    @Bean
    @ConditionalOnProperty("feign-exception.consumer.enable")
    public ErrorDecoder feignExceptionConsumerErrorDecoder() {
        System.out.println("debug = " + debug);
        if (debug) {
            log.info("Load FeignExceptionConsumerErrorDecoder");
        }
        return new FeignExceptionConsumerErrorDecoder(new ObjectMapper());
    }

    @Bean
    public FeignExceptionProviderHandler feignExceptionProviderHandler() {
        log.info("debug = " + debug);
        if (debug) {
            log.info("Load FeignExceptionConsumerErrorDecoder");
        }
        return new FeignExceptionProviderHandler();
    }

}
