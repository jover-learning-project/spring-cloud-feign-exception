package com.questionbank.uidservice.config;

import com.questionbank.uidservice.api.domain.CustomException;
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
public class GlobalException {

    /**
     * FIXME: 捕获粗度略大，待定。
     * <p>
     * 全局异常捕获。
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomException<?>> handlerException(Exception e) {
        CustomException<Exception> exception = new CustomException<>(e.getClass(), e);
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * FIXME: 实现不是特别优雅，待定。
     * <p>
     * Hibernate validate异常捕获。(原{@link ValidationException})*
     */
    @ExceptionHandler(BindException.class)
    public ResponseEntity<CustomException<?>> handlerValidationException(BindException e) {
        ValidationException validationException = new ValidationException(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        CustomException<Exception> exception = new CustomException<>(ValidationException.class, validationException);
        return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
