package com.fd.implementations;

import java.util.Date;

import com.fd.model.Card;
import com.fd.model.PERE;
import com.fd.model.SCO;
import com.fd.model.SQUA;
import com.fd.model.interfaces.IOperations;

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
	public double calculateRate(Card tObject) {
		if (tObject instanceof SQUA) {
			return (new Date().getYear() / new Date().getMonth());
		} else if (tObject instanceof SCO) {
			return (new Date().getDay() * 0.5);
		} else if (tObject instanceof PERE) {
			return (new Date().getMonth() * 0.1);
		}
		return 0;
	}

	@Override
	public Card getInformation(Card tObject) {
		return tObject;
	}

}
