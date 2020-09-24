package com.questionbank.common.feign.comsumer.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.questionbank.common.feign.exception.FeignCustomException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Slf4j
public class FeignExceptionConsumerErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper;

    public FeignExceptionConsumerErrorDecoder(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    /**
     * 从{@link Response#body()}中包装了provider抛出的`异常信息`，并根据`异常信息`实例化`异常实体`。
     * <p>
     * FIXME: 当consumer接收到provider抛出的未知异常时({@link ClassNotFoundException})，暂未进行处理。
     * <p>
     * {@link Response#body()}的结构:
     * {@link FeignCustomException#getClazz()} 异常类型
     * {@link FeignCustomException#getClassName()} 异常类型名
     * {@link FeignCustomException#getException()} 异常实体信息
     *
     * @return 根据`异常信息`实例化的`异常实体`
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception;
        try {
            String body = Util.toString(response.body().asReader(Charset.defaultCharset()));
            FeignCustomException<?> feignCustomException = mapper.readValue(body, FeignCustomException.class);

            Class<?> exceptionClazz = feignCustomException.getClazz();
            exception = (Exception) exceptionClazz.getConstructor().newInstance();
            BeanUtils.copyProperties(feignCustomException.getException(), exception);
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            exception = new InternalException(e.getMessage());
        }
        return exception;
    }

}
