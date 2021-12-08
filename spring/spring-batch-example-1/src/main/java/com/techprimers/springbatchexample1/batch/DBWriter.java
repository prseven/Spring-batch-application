package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.model.User;
import com.techprimers.springbatchexample1.repository.UserRepository;
import com.techprimers.springbatchexample1.util.MailUtil;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

   import java.util.List;

   @Component
   public class DBWriter implements ItemWriter<User> {


       private UserRepository userRepository;

       @Autowired
       private MailUtil mail;

       @Override
       public void write(List<? extends User> users) throws Exception{
           for(int i=0;i< users.size();i++){
               userRepository.save(users.get(i));
               if(users.get(i).getNotification_sent().equals("yes")){
                   mail.sendEmail(
                           users.get(i).getMail_id(),
                           "Hi"+users.get(i).getName()+"Your data has been updated succesfully",
                           "Data Updated");
               }
           }
            userRepository.saveAll(users);
   }
}
