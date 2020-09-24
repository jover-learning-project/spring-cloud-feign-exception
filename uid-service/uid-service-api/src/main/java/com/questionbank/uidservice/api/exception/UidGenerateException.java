package com.questionbank.uidservice.api.exception;

import com.questionbank.common.feign.exception.BusinessException;
import lombok.NoArgsConstructor;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@NoArgsConstructor
public class UidGenerateException extends BusinessException {

    public UidGenerateException(String message) {
        super(message);
    }

}
