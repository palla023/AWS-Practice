package com.demo.awssnsmovies.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;


@Configuration
public class AwsSnsConfig {
    //Authentication to aws
    //SnS Template

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
                .region(Region.US_EAST_1) // change if needed
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create("AKIAVUQKSYHO2PDPPG4Q", "tTQy3arY9in8fe4XIqkMwUDaXmljdT0SFDaETAx+")
                ) )
                .build();
    }


}
