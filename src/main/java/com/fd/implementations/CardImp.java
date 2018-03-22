package com.fd.implementations;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fd.model.Card;
import com.fd.model.PERE;
import com.fd.model.SCO;
import com.fd.model.SQUA;
import com.fd.model.interfaces.IOperations;

@Component
public class CardImp implements IOperations<Card> {

	@Override
	public boolean validAmount(double money) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkDate(Card tObject) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double calculateRate(Class tObject) throws InstantiationException, IllegalAccessException {
		Object t = tObject.newInstance();
		if (t instanceof SQUA) {
			return (new Date().getYear() / new Date().getMonth());
		} else if (t instanceof SCO) {
			return (new Date().getDay() * 0.5);
		} else if (t instanceof PERE) {
			return (new Date().getMonth() * 0.1);
		}
		return 0;
	}

	@Override
	public Card getInformation(Card tObject) {
		return tObject;
	}

}
