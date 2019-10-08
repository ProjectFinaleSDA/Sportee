package com.sportee.sportee.data.DTO;

import com.sportee.sportee.data.DAO.Subscription;
import lombok.Getter;

import java.util.Date;

@Getter
public class SubscriptionDTO {
    private int id;

    private Date startDate;
    private boolean valid;
    private String memberName;
    private String subscriptionTypeName;
    private int duration;


    public SubscriptionDTO (Subscription subscription){
        this.startDate = subscription.getDate();
        this.valid = subscription.isValid();
        this.memberName = subscription.getSporteeMember().getFirstName()+" "
                + subscription.getSporteeMember().getLastName();
        this.subscriptionTypeName = subscription.getSubscriptionType().getName();
        this.duration = subscription.getSubscriptionType().getDuration();

    }
}
