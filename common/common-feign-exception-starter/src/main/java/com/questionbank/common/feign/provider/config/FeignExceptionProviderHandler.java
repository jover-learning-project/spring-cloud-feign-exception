package com.questionbank.common.feign.provider.config;

import com.questionbank.common.feign.exception.FeignCustomException;
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
@RestControllerAdvice
public class FeignExceptionProviderHandler {

    /**
     * FIXME: 捕获粗度略大，待定。
     * <p>
     * 全局异常捕获。
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<FeignCustomException<?>> handlerException(Exception e) {
        FeignCustomException<Exception> exception = new FeignCustomException<>(e.getClass(), e);
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * FIXME: 实现不是特别优雅，待定。
     * <p>
     * Hibernate validate异常捕获。(原{@link ValidationException})*
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<FeignCustomException<?>> handlerValidationException(BindException e) {
        ValidationException validationException = new ValidationException(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        FeignCustomException<ValidationException> exception = new FeignCustomException<>(ValidationException.class, validationException);
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
