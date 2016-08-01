package com.unimelb.swen30006.nextgen.domain;

import com.unimelb.swen30006.nextgen.datatype.Money;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Represent a payment
 * 
 * This class is created based on Chap 20.11
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-29
 *
 */
public class Payment
{
	private Money amount;
	
	public Payment(Money cashTendered ){ 
		amount = cashTendered; 
	}
	
	public void authorize(){
		//do nothing now.
	}
	
	public Money getAmount() {
		return amount; 
	}
}
