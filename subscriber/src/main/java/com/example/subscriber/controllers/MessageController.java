package com.example.subscriber.controllers;

import com.example.ejb.model.Message;
import com.example.subscriber.services.MessageService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
public class MessageController {

    private MessageService messageService;

    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    public void incomingMessage(@RequestBody Message msg){
        if(msg != null) messageService.saveMessage(msg);
    }
}
