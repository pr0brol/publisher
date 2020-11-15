package com.example.generator;

import com.example.ejb.enums.ActionEnum;
import com.example.ejb.model.Message;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Generator {

    private Map<Integer, ActionEnum> action;

    public void init(){
        action = new HashMap<>();
        action.put(0, ActionEnum.PURCHASE);
        action.put(1, ActionEnum.SUBSCRIPTION);
    }

    public Message generate(){
        Message message = new Message();
        message.setMsisdn((long) (Math.random() * 1000000));
        message.setAction(action.get((int) Math.round(Math.random())));
        message.setSendTime(new Date());
        return message;
    }
}
