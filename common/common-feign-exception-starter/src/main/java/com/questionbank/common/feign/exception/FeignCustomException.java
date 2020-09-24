package com.questionbank.common.feign.exception;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Data
@Getter
@NoArgsConstructor
public class FeignCustomException<T extends Exception> implements Serializable {

    Class<?> clazz;

    String className;

    T exception;

    public FeignCustomException(Class<?> clazz, T exception) {
        this.clazz = clazz;
        this.className = clazz.getName();
        this.exception = exception;
    }

}
