package com.example.sender;

import com.example.ejb.model.Message;
import org.springframework.web.client.RestTemplate;

public class MessageSender {

    private final String URL = "http://localhost:8181/subscriber";
    private RestTemplate template;

    public void init(){
        template = new RestTemplate();
    }

    public void sendMessage(Message msg) {
        if(msg != null) template.postForEntity(URL + "/message", msg, Message.class);
    }
}
