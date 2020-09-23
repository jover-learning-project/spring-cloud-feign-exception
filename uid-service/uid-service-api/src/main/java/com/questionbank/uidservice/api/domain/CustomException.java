package com.questionbank.uidservice.api.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Data
@NoArgsConstructor
public class CustomException<T extends Exception> implements Serializable {

    Class<?> clazz;

    String className;

    T exception;

    public CustomException(Class<?> clazz, T exception) {
        this.clazz = clazz;
        this.className = clazz.getName();
        this.exception = exception;
    }

}
