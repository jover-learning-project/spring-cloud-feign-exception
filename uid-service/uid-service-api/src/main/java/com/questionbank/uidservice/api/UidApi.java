package com.questionbank.uidservice.api;

import com.questionbank.uidservice.api.domain.request.UidRequest;
import com.questionbank.uidservice.api.exception.UidGenerateException;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * TODO
 *
 * @author Jover Zhang
 */
public interface UidApi {

    @PostMapping("/uid")
    Long getId(@SpringQueryMap @Valid UidRequest uidRequest) throws UidGenerateException;

}
