package com.questionbank.questionbankcomposite.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * TODO
 *
 * @author Jover Zhang
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

//    @GetMapping
//    public Mono<List<String>> list() throws InterruptedException {
//        System.out.println(port);
//        Thread.sleep(1000L);
//        return Mono.just(new ArrayList<String>(Arrays.asList("a", "b", "c", port)));
//    }

    @GetMapping
    public List<String> list2() throws InterruptedException {
        System.out.println(port);
        Thread.sleep(1000L);
        return new ArrayList<>(Arrays.asList("a", "b", "c", port));
    }

}
