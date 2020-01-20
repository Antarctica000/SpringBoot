package com.example.rabbitmq.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello2")
public class Receiver1 {


    @RabbitHandler
    public void process(String message){

        System.out.println("Receiver1:"+message);
    }


}