package com.example.subscriber.services;

import com.example.ejb.enums.ActionEnum;
import com.example.ejb.model.Message;
import com.example.subscriber.entities.Purchase;
import com.example.subscriber.entities.Subscription;
import com.example.subscriber.repository.PurchaseRepository;
import com.example.subscriber.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private PurchaseRepository purchaseRepository;
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public void setPurchaseRepository(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @Autowired
    public void setSubscriptionRepository(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public void saveMessage(Message msg){
        if(msg == null) return;

        if(msg.getAction().equals(ActionEnum.PURCHASE)){
            Purchase purchase = savePurchase(msg);
            System.out.println(purchase);
        }
        if(msg.getAction().equals(ActionEnum.SUBSCRIPTION)) {
            Subscription subscription = saveSubscription(msg);
            System.out.println(subscription);
        }
    }

    private Subscription saveSubscription(Message msg) {
        Subscription result = new Subscription(msg.getMsisdn(), msg.getAction(), msg.getSendTime());
        return subscriptionRepository.save(result);
    }

    private Purchase savePurchase(Message msg) {
        Purchase result = new Purchase(msg.getMsisdn(), msg.getAction(), msg.getSendTime());
        return purchaseRepository.save(result);
    }
}
