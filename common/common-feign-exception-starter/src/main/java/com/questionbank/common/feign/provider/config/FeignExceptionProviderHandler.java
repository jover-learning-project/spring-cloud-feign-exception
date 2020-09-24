package com.questionbank.common.feign.provider.config;

import com.questionbank.common.feign.exception.BusinessException;
import com.questionbank.common.feign.exception.FeignCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ValidationException;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Slf4j
@RestControllerAdvice
public class FeignExceptionProviderHandler {

    private boolean debug;

    public FeignExceptionProviderHandler setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    /**
     * 业务异常捕获。{@link BusinessException}
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<FeignCustomException<?>> handlerException(BusinessException e) {
        if (debug) {
            log.info("业务异常：" + e.toString());
        }
        FeignCustomException<BusinessException> exception = new FeignCustomException<>(e.getClass(), e);
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * FIXME: 实现不是特别优雅，待定。
     * <p>
     * Hibernate validate异常捕获。(原{@link ValidationException})*
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<FeignCustomException<?>> handlerValidationException(BindException e) {
        if (debug) {
            log.info("参数异常：" + e.toString());
        }
        ValidationException validationException = new ValidationException(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        FeignCustomException<ValidationException> exception = new FeignCustomException<>(ValidationException.class, validationException);
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
