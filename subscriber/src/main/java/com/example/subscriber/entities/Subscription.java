package com.example.subscriber.entities;

import com.example.ejb.enums.ActionEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Subscription")
@Table(name = "subscription")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Subscription {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "subscription_id_seq")
    @Column(name="id", updatable=false, nullable=false)
    private long id;

    @Column(name = "msisdn", nullable = false)
    private Long msisdn;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", nullable = false)
    private ActionEnum action;

    @Column(name = "send_time", nullable = false)
    private Date sendTime;

    public Subscription(Long msisdn, ActionEnum action, Date sendTime) {
        this.msisdn = msisdn;
        this.action = action;
        this.sendTime = sendTime;
    }

}
