package com.fd.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fd.helper.ValidationNumberHelper;
import com.fd.implementations.CardImp;
import com.fd.model.Card;
import com.google.gson.Gson;

@RestController
public class ValidationService {

	private ClassPathXmlApplicationContext context;
	final static Logger logger = Logger.getLogger(ValidationService.class);

	@Autowired
	private CardImp cardImp;

	private void init() {
		this.context = new ClassPathXmlApplicationContext("beanConfiguration.xml");
	}

	@GetMapping(value = "/validationCard/{number}")
	public String getValidation(@PathVariable("number") String number) {
		return "hola mundo " + number;
	}

	@GetMapping(value = "/getCardNames/{number}", produces = "application/json")
	public String getCardNames(@PathVariable("number") String number) {
		try {

			List<Card> listCards = new ArrayList<>();
			System.out.println(number);
			String res = null;
			if (ValidationNumberHelper.validation(number)) {
				res = "OK";
			} else {
				res = "Invalido";
			}
			init();
			listCards.add((Card) this.context.getBean("SQUA"));
			listCards.add((Card) this.context.getBean("PERE"));
			listCards.add((Card) this.context.getBean("SCO"));
			System.out.println(res);
			Gson g = new Gson();
			logger.info("Metodo: getCardNames : sin errores");
			return g.toJson(res);// listCards
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;

		}
	}

	@GetMapping(value = "/validate/{typeCard}")
	public String getInformation(@PathVariable("typeCard") String typeCard) {

		try {

			Gson g = new Gson();
			init();
			logger.info("Metodo: getInformation : sin errores");
			return g.toJson((Card) this.context.getBean(typeCard));
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;
		}
	}

	@GetMapping(value = "/rates/{typeCard}")
	public String getRates(@PathVariable("typeCard") String typeCard) {
		try {
			Gson g = new Gson();
			init();
			logger.info("metodo getRates: sin errores");
			return g.toJson(cardImp.calculateRate(Class.forName(typeCard)));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return e.getMessage();
		} catch (InstantiationException e) {
			logger.error(e.getMessage());
			return e.getMessage();
		} catch (IllegalAccessException e) {
			logger.error(e.getMessage());
			return e.getMessage();
		}

	}
	
	@GetMapping(value = "/getAll", produces = "application/json")
	public String getall() {
		try {

			List<Card> listCards = new ArrayList<>();
			init();
			listCards.add((Card) this.context.getBean("SQUA"));
			listCards.add((Card) this.context.getBean("PERE"));
			listCards.add((Card) this.context.getBean("SCO"));
			Gson g = new Gson();
			logger.info("Metodo: getCardNames : sin errores");
			return g.toJson(listCards);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;

		}
	}

}
