package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.model.User;
import com.techprimers.springbatchexample1.util.MailUtil;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Processor implements ItemProcessor<User, User> {

    @Autowired
    private MailUtil mail;

    @Override
    public User process(User user) throws Exception {
        String notificationSent = user.getNotification_sent();
        if(notificationSent.equals("yes")){
            mail.sendEmail(user.getMail_id(), "Hi"+user.getName()+"notification has been sent", " "+user.getId());
        }
        return user;
    }
}

