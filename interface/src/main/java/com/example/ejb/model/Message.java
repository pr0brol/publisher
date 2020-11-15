package com.example.ejb.model;

import com.example.ejb.enums.ActionEnum;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private Long msisdn;
    private ActionEnum action;
    private Date sendTime;

    public Message() {
    }

    public Message(Long msisdn, ActionEnum action, Date sendTime) {
        this.msisdn = msisdn;
        this.action = action;
        this.sendTime = sendTime;
    }

    public Long getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(Long msisdn) {
        this.msisdn = msisdn;
    }

    public ActionEnum getAction() {
        return action;
    }

    public void setAction(ActionEnum action) {
        this.action = action;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
