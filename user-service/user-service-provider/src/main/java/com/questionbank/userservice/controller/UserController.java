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
        Long id;
        try {
            id = uidService.getId(uidRequest);
        } catch (UidGenerateException e) {
            System.err.println("UidGenerateException: " + e);
            id = 0L;
        } catch (ValidationException e) {
            System.err.println("ValidationException: " + e);
            id = 1L;
        }
        return id;
    }

}
