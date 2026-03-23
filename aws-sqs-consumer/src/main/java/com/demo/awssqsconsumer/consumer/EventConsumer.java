package com.demo.awssqsconsumer.consumer;

import com.demo.awssqsconsumer.dto.Product;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class EventConsumer {
    //Queue endpoint taken from aws sqs endpoint in aws console

//    @SqsListener("javaspringSQ")
//    public void consume(@Payload Product product) {
//        try {
//            System.out.println("Received: " + product);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
@SqsListener("javaspringSQ")
public void receive(Product product) {

    System.out.println("Received Product:");
    System.out.println("ID: " + product.getProductId());
    System.out.println("Name: " + product.getProductName());
    System.out.println("Price: " + product.getPrice());
}
}
