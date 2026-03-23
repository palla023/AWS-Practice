package com.demo.awssnsmovies.Controller;

import com.demo.awssnsmovies.dto.MessageEvents;
import com.demo.awssnsmovies.service.AwsSNSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sns")
public class MovieNotificationContoller {

    @Autowired
    private AwsSNSService awsSNSService;

    /*
    message -> we are sending the message to the topic
     */
    @PostMapping("/publish")
    public String publishMessage(@RequestBody MessageEvents events){
       return awsSNSService.publishMessage(events);

    }

   /*
   Like we are creating a subscription in the sns
   1. Create a topic name
   2. protocol -> http / email / mobile <- choose one
   3. endpoint -> url -> http://localhost:8080/subscribe or email id <-Give the original mail
    */

    @GetMapping("/subscribe")
    public String subscribe( @RequestParam String protocol, @RequestParam String endpoint){
        return awsSNSService.autoSubscription(protocol, endpoint);
    }
}
