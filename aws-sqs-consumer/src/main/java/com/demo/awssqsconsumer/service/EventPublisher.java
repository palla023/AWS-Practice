package com.demo.awssqsconsumer.service;

import com.demo.awssqsconsumer.dto.Product;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class EventPublisher {
    //Queue endpoint taken from aws sqs endpoint in aws console
    private static final String QUEUE_ENDPOINT = "https://sqs.ap-south-1.amazonaws.com/387642999261/javaspringSQ";
    @Autowired
    private SqsTemplate sqsTemplate;


    public String publishEvent(Product product) throws ExecutionException, InterruptedException {
       var future =  sqsTemplate.sendAsync(QUEUE_ENDPOINT, product);
       return "Message submitted to Queue with ID:" + future.get().messageId().toString();
    }
}
