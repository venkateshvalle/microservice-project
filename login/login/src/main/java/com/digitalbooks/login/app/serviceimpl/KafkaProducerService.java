package com.digitalbooks.login.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.digitalbooks.login.app.entity.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class KafkaProducerService {
     
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
 
    public void sendMessage(String list) throws JsonProcessingException
    {
        this.kafkaTemplate.send("Book_List", list);
    }

}
