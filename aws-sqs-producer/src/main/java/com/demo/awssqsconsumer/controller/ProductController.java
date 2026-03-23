package com.demo.awssqsconsumer.controller;

import com.demo.awssqsconsumer.dto.Product;
import com.demo.awssqsconsumer.service.EventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/events")
public class ProductController {

    @Autowired
    private EventPublisher eventPublisher;

    @PostMapping("/publish")
    public String publishEvent(@RequestBody Product product) throws ExecutionException, InterruptedException {
        return eventPublisher.publishEvent(product);
    }
}
