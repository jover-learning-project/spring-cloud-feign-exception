package com.questionbank.userservice.config;

import com.alibaba.fastjson.JSON;
import com.questionbank.uidservice.api.domain.CustomException;
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
public class MyErrDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String methodKey, Response response) {
        Exception exception;
        try {
            String body = Util.toString(response.body().asReader(Charset.defaultCharset()));
            CustomException<?> customException = JSON.parseObject(body, CustomException.class);

            Class<?> exceptionClazz = customException.getClazz();
            exception = (Exception) exceptionClazz.getConstructor().newInstance();
            BeanUtils.copyProperties(customException.getException(), exception);
        } catch (IOException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            exception = new InternalException(e.getMessage());
        }
        return exception;
    }

}
