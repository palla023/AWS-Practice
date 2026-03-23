package com.demo.awssnsmovies.service;

import com.demo.awssnsmovies.dto.MessageEvents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.SubscribeRequest;

@Service
public class AwsSNSService {

    /*
    Get the topic arn from aws console after creating the topic in sns service
     */
    public static final String TOPIC_ARN = "arn:aws:sns:us-east-1:387642999261:movies-topic";

    @Autowired
    private SnsClient snsClient;

    public String publishMessage(MessageEvents events) {

        var publishRequest = PublishRequest.builder()
                .topicArn(TOPIC_ARN)
                .message(events.getEvent())
                .build();
        return snsClient.publish(publishRequest).messageId() ;
    }

    public String autoSubscription(String protocol, String endpoint) {

        SubscribeRequest subscribeRequest = SubscribeRequest.builder()
                .topicArn(TOPIC_ARN)
                .protocol(protocol)
                .endpoint(endpoint)
                .build();
       return snsClient.subscribe(subscribeRequest).subscriptionArn();
    }
}
