package com.questionbank.common.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionbank.common.feign.comsumer.handler.FeignExceptionConsumerErrorDecoder;
import com.questionbank.common.feign.provider.config.FeignExceptionProviderHandler;
import feign.codec.ErrorDecoder;
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

    private static final String PROPERTY_PREFIX = "feign-exception";

    @Value("${" + PROPERTY_PREFIX + ".debug:false}")
    private Boolean debug;


    @Bean
    @ConditionalOnProperty(prefix = PROPERTY_PREFIX, value = "provider.enable", havingValue = "true", matchIfMissing = true)
    public FeignExceptionProviderHandler feignExceptionProviderHandler() {
        if (debug) {
            log.info("Load FeignExceptionProviderHandler");
        }
        return new FeignExceptionProviderHandler().setDebug(debug);
    }

    @Bean
    @ConditionalOnProperty(prefix = PROPERTY_PREFIX, value = "consumer.enable", havingValue = "true", matchIfMissing = true)
    public ErrorDecoder feignExceptionConsumerErrorDecoder() {
        if (debug) {
            log.info("Load FeignExceptionConsumerErrorDecoder");
        }
        return new FeignExceptionConsumerErrorDecoder(new ObjectMapper()).setDebug(debug);
    }

}
