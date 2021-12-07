package com.techprimers.springbatchexample1.controller;

import com.techprimers.springbatchexample1.model.User;
import com.techprimers.springbatchexample1.util.MailUtil;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private MailUtil util;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @GetMapping
    public BatchStatus load() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {


        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution: " + jobExecution.getStatus());

        System.out.println("Batch is Running...");




        while (jobExecution.isRunning()) {
            System.out.println("Job execution running...");
        }

        return jobExecution.getStatus();
    }
}























/*ItemProcessor<User, User> process = new ItemProcessor<User, User>() {
            @Override
            public User process(User user) throws Exception {
                if(user.getSalary()>25000){
                    String msg= util.sendEmail(user.getEmail(), buildMessage(user));
                }
                return null;
            }

            private String buildMessage(User user){
                String mailBody="Dear"+user.getName()
                        +","
                        +"\n"
                        +"Your Salary is" +user.getSalary();
                return mailBody;
            }
        }; */