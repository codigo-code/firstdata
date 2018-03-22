package com.fd.model.interfaces;

import com.fd.model.Card;

public interface IOperations<T extends Card> {
	
	public T getInformation(T tObject);
	
	public boolean validAmount(double money);
	
	public boolean checkDate(T tObject);
	
	double calculateRate(Class tObject) throws InstantiationException, IllegalAccessException;
	
	

}
