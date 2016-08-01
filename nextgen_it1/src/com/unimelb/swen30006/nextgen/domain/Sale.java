package com.unimelb.swen30006.nextgen.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unimelb.swen30006.nextgen.datatype.Money;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Represent a sale
 * 
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-29
 *
 */
public class Sale{
	
	private List<SalesLineItem> lineItems = new ArrayList<SalesLineItem>();
	private Date time = new Date();
	private boolean isComplete = false;
	private Payment payment;

	/**
	 * calculate the balance
	 * @return balance of current payment
	 */
	public Money getBalance(){
		return payment.getAmount().minus(getTotal());
	}
	
	/**
	 * complete the sale
	 */
	public void becomeComplete(){ 
		isComplete = true; 
	}
	
	/**
	 * check if the sale is complete
	 * @return true if it is complete, false otherwise
	 */
	public boolean isComplete(){ 
		return isComplete; 
	}

	/**
	 * add new item
	 * @param desc the description of an item
	 * @param quantity the quantity 
	 */
	public void makeLineItem(ProductDescription desc, int quantity){
		SalesLineItem newItem = new SalesLineItem(desc, quantity);
		lineItems.add(newItem);
	}

	/**
	 * calculate the total price
	 * @return the total price
	 */
	public Money getTotal(){
		Money total = new Money();
		for ( SalesLineItem lineItem : lineItems){
			Money subtotal = lineItem.getSubtotal();
			total = total.add( subtotal );
		}
		return total;
	}
	
	/**
	 * make a payment for the sale
	 * @param cashTendered the cash tendered
	 */
	public void makePayment(Money cashTendered)
	{
		payment = new Payment(cashTendered);
		payment.authorize();
	}
	
	public Date getTime(){
		return time;
	}

	
	public String printReceipt() {
		StringBuilder receipt = new StringBuilder();
		for(SalesLineItem item : lineItems){
			receipt.append(item.toString());
			receipt.append("\n");
		}
		receipt.append("Total:       " + getTotal()+"\n");
		receipt.append("Paid amount: " + payment.getAmount()+"\n");
		receipt.append("Balance:     " + getBalance());
		return receipt.toString();
	}
}