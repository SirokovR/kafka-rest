package com.example.kafkarest;

import com.example.kafkarest.repo.UserRepo;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class KafkaRestApplication {

    @KafkaListener(topics="msg")
    public void orderListener(ConsumerRecord<Long, UserRepo> record){
        System.out.println(record.partition());
        System.out.println(record.key());
        System.out.println(record.value());
    }


    public static void main(String[] args) {
        SpringApplication.run(KafkaRestApplication.class, args);
    }

}
