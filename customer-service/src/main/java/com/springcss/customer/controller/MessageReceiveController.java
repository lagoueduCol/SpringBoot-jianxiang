//package com.springcss.customer.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.springcss.customer.message.AccountChangedReceiver;
//
//@RestController
//@RequestMapping(value="messagereceive")
//public class MessageReceiveController {
//    
//    @Autowired
////    @Qualifier("activeMQAccountChangedReceiver")
//    @Qualifier("rabbitMQAccountChangedReceiver")
//    private AccountChangedReceiver accountChangedReceiver; 
//	
//	@RequestMapping(value = "", method = RequestMethod.GET)
//	public void receiveAccountChangedEvent() {
//		accountChangedReceiver.receiveAccountChangedEvent();
//	}	
//}
