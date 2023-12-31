package com.tony.subscibe;

import com.tony.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscribeController {

    @Autowired
    private SubscribeProducer subscribeProducer;

    @RequestMapping("/subscribe/send")
    public String send() {
        subscribeProducer.send(new Student(1, "Tonyyy"));
        return "success";
    }
}
