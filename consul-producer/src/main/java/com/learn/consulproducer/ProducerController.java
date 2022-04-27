package com.learn.consulproducer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class ProducerController {

    @RequestMapping("hello")
    public String hello() {

        return "hello consul";
    }
}
