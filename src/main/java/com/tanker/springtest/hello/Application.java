package com.tanker.springtest.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class Application {
	
	@Bean
	MessageService getMessageService(){
		return new MessageService() {
			
			public String getMessage() {
				return "Hello world!";
			}
		};
	}
	
	
	@Bean
	@Qualifier("haha")
	MessageService getAnotherMessageService(){
		return new MessageService() {
			
			public String getMessage() {
				return "Hello world! haha";
			}
		};
	}
	
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		printer.printMessage();
	}
}
