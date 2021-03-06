package com.example.kafkarest.controller;

import com.example.kafkarest.repo.Address;
import com.example.kafkarest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msg")
public class MsgController {

    @Autowired
    private KafkaTemplate<Long, UserRepo> kafkaTemplate;

    @PostMapping
    public void sendMsg(Long msgId, UserRepo msg){
        msg.setAddress(new Address("eesti","Tallinn", "Pikk",4L,22L));
        ListenableFuture<SendResult<Long,UserRepo>> future = kafkaTemplate.send("msg",msgId,msg);
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }
}
