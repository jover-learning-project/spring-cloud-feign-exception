package com.questionbank.uidservice.controller;

import com.questionbank.uidservice.api.UidApi;
import com.questionbank.uidservice.api.domain.request.UidRequest;
import com.questionbank.uidservice.api.exception.UidGenerateException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@Validated
@RestController
public class UidController implements UidApi {

    @Override
    public Long getId(UidRequest uidRequest) throws UidGenerateException {
        if (uidRequest.getDatacenterId().equals(100L)) {
            throw new UidGenerateException("error");
        }
        return 999L;
    }

}
