package com.questionbank.userservice.controller;

import com.questionbank.uidservice.api.domain.request.UidRequest;
import com.questionbank.uidservice.api.exception.UidGenerateException;
import com.questionbank.userservice.service.UidService;
import feign.codec.ErrorDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ValidationException;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@RestController
public class UserController {

    @Autowired
    UidService uidService;

    @Autowired
    ErrorDecoder errorDecoder;

    @GetMapping
    public Long get(UidRequest uidRequest) {
        System.out.println("uidRequest = " + uidRequest);
        System.out.println("errorDecoder = " + errorDecoder + errorDecoder.getClass());

        Long id;
        try {
            id = uidService.getId(uidRequest);
        } catch (UidGenerateException e) {
            id = 20000L;
        } catch (ValidationException e) {
            id = 0L;
        }
        return id;
    }

}
