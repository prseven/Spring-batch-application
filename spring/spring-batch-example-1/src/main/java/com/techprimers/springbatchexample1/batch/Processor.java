package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.model.User;
import com.techprimers.springbatchexample1.util.MailUtil;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class Processor {

    @Autowired
    private MailUtil util;

    ItemProcessor<User, User> process = new ItemProcessor<User, User>() {
        @Override
        public User process(User user) throws Exception {
            if (user.getSalary() > 25000) {
                String msg = util.sendEmail(user.getEmail(), buildMessage(user));
            }
            return null;
        }

        private String buildMessage(User user) {
            String mailBody = "Dear" + user.getName()
                    + ","
                    + "\n"
                    + "Your Salary is" + user.getSalary();
            return mailBody;
        }
    };
}

//@Component
//public class Processor implements ItemProcessor<User, User> {
//
//    private static final Map<String, String> DEPT_NAMES =
//            new HashMap<>();
//
//    public Processor() {
//        DEPT_NAMES.put("001", "Technology");
//        DEPT_NAMES.put("002", "Operations");
//        DEPT_NAMES.put("003", "Accounts");
//    }
//
//    @Override
//    public User process(User user) throws Exception {
//        String deptCode = user.getDept();
//        String dept = DEPT_NAMES.get(deptCode);
//        user.setDept(dept);
//        user.setTime(new Date());
//        System.out.println(String.format("Converted from [%s] to [%s]", deptCode, dept));
//        return user;
//    }
//}

