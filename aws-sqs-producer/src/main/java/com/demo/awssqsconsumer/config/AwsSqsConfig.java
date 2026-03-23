package com.demo.awssqsconsumer.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class AwsSqsConfig {
    //Authentication to aws
    //SQS Template

    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .region(Region.AP_SOUTH_1) // change if needed
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("", "")
                ) )
                .build();
    }

    @Bean
    public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient) {
        return SqsTemplate.builder()
                .sqsAsyncClient(sqsAsyncClient)
                .build();
    }
}
