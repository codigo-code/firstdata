package com.fd.model.interfaces;

import org.springframework.stereotype.Component;

/**
 * 
 * @author Dante
 * pending of implementation
 */
@Component
public interface IDebitCharge {

	public void printCheck();
	
	public void sendInfoTC();
	
	public void informCharge();
	
	public void updateBalance(Object client);
}
