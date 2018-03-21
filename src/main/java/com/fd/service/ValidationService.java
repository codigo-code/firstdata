package com.fd.service;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fd.model.Card;
import com.fd.model.SQUA;
import com.google.gson.Gson;

@RestController
public class ValidationService {

	private ClassPathXmlApplicationContext context;
	
	private void init(){
		this.context = new ClassPathXmlApplicationContext("beanConfiguration.xml");
	}
	
	@GetMapping(value="/validationCard/{number}")
	public String getValidation(@PathVariable("number") String number){
		return "hola mundo " + number;
	}
	
	 @GetMapping(value="/getCardNames/{number}", produces = "application/json")
	  public String getCardNames(@PathVariable("number") int number){
		  List<Card> listCards = new ArrayList<>();
		  System.out.println(number);
		  
		  init();
		  listCards.add((Card)this.context.getBean("SQUA"));
		  listCards.add((Card)this.context.getBean("PERE"));
		  listCards.add((Card)this.context.getBean("SCO"));
		  
		  Gson g = new Gson();
		  return g.toJson(listCards);
	  }	
	  
}
