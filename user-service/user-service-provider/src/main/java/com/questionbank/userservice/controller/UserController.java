package com.questionbank.userservice.controller;

import com.questionbank.uidservice.api.domain.request.UidRequest;
import com.questionbank.uidservice.api.exception.UidGenerateException;
import com.questionbank.userservice.service.UidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@RestController
public class UserController {

    @Autowired
    UidService uidService;

    @GetMapping
    public Long get(UidRequest uidRequest) {
        System.out.println("uidRequest = " + uidRequest);
        Long id;
        try {
            id = uidService.getId(uidRequest);
        } catch (UidGenerateException e) {
            id = 20000L;
        }
        return id;
    }

}
