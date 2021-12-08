package com.techprimers.springbatchexample1;

import com.techprimers.springbatchexample1.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBatchExample1Application {

	public static void main(String[] args) {

		SpringApplication.run(SpringBatchExample1Application.class, args);
	}
}
















//@EventListener(ApplicationReadyEvent.class)
//	public void triggermail () {
//		mail.sendEmail("1dt17is059@gmail.com" ,"Mail banthu guru", "Mail bantha guru" );
//
//	}