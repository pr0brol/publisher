package com.example.sender;

import com.example.ejb.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class MessageSender{

    private Logger logger = LoggerFactory.getLogger(MessageSender.class);

    private final String URL = "http://localhost:8181/subscriber";
    private RestTemplate template;

    public void init(){
        template = new RestTemplate();
    }

    public void sendMessage(Message msg) {
        if(msg != null) {
            try {
                template.postForEntity(URL + "/message", msg, Message.class);
                logger.info("message send");
            }catch (RestClientException e){
                logger.error("message not send. error: " + e.getMessage());
            }
        }else {
            logger.warn("message not send because null");
        }
    }
}
