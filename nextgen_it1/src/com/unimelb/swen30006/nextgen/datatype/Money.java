package com.unimelb.swen30006.nextgen.datatype;

import java.math.BigDecimal;
import java.util.Currency;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Represent an amount of money in any currency, together with the calculation of addition, subtraction, multiplication and division.
 * 
 * This class is created based on Chap 7.7, and partially adopted from http://www.javapractices.com/topic/TopicAction.do?Id=13 
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-29
 *
 */
public final class Money implements Comparable<Money>{
	private static Currency DEFAULT_CURRENCY = Currency.getInstance("AUD");
	

	//The money amount. Never null. 
	private BigDecimal amount; 
	//The currency of the money, such as AUD, USD or Euro
	private Currency currency;
	
	/**
	 * Thrown when a set of  <tt>Money</tt> objects do not have matching currencies. 
	 * 
	 * <P>For example, adding together Euros and Dollars does not make any sense.
	 */
	public static final class MismatchedCurrencyException extends RuntimeException { 
		private static final long serialVersionUID = 1L;

		MismatchedCurrencyException(String aMessage){
	      super(aMessage);
	   }
	}
	
	public Money(){
		this.amount = BigDecimal.ZERO;
		this.currency = DEFAULT_CURRENCY;
	}
	
	/**
	 * Full constructor
	 * @param amount is required, can be positive or negative.
	 * @param currency is required.
	 */
	public Money(BigDecimal amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	/**
	 * Constructor taking only the money amount. 
	 * @param amount is required, can be positive or negative.
	 */
	public Money(BigDecimal amount) {
		this(amount, DEFAULT_CURRENCY);
	}
	
	/**
	 * Full constructor with double type amount
	 * @param amount is required, can be positive or negative.
	 * @param currency is required.
	 */
	public Money(double amount, Currency currency) {
		this.amount = new BigDecimal(Double.toString(amount));
		this.currency = currency;
	}
	
	/**
	 * Constructor taking only the money amount of double type. 
	 * @param amount is required, can be positive or negative.
	 */
	public Money(double amount) {
		this(amount, DEFAULT_CURRENCY);
	}
	
	/**
	 * Full constructor with int type amount
	 * @param amount is required, can be positive or negative.
	 * @param currency is required.
	 */
	public Money(int amount, Currency currency) {
		this.amount = new BigDecimal(Integer.toString(amount));
		this.currency = currency;
	}
	
	/**
	 * Constructor taking only the money amount of int type. 
	 * @param amount is required, can be positive or negative.
	 */
	public Money(int amount) {
		this(amount, DEFAULT_CURRENCY);
	}
	
	
	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}
	
	@Override
	public int compareTo(Money m) {
		checkCurrenciesMatch(m);
		return this.amount.compareTo(m.amount);
	}
	
	/** 
	 * Add <tt>aThat</tt> <tt>Money</tt> to this <tt>Money</tt>.
	 * Currencies must match.  
	 */
	public Money add(Money aThat){
	    checkCurrenciesMatch(aThat);
	    return new Money(amount.add(aThat.amount), currency);
	}

	/** 
	 * Subtract <tt>aThat</tt> <tt>Money</tt> from this <tt>Money</tt>. 
	 * Currencies must match.  
	 */
	public Money minus(Money aThat){
	    checkCurrenciesMatch(aThat);
	    return new Money(amount.subtract(aThat.amount), currency);
	}

	/**
	 * Multiply this <tt>Money</tt> by an integral factor.
	 * 
	 * The scale of the returned <tt>Money</tt> is equal to the scale of 'this' 
	 * <tt>Money</tt>.
	*/
	public Money times(int aFactor){  
	    BigDecimal factor = new BigDecimal(aFactor);
	    BigDecimal newAmount = amount.multiply(factor);
	    return new Money(newAmount, currency);
	}
	
	/**
	  * Divide this <tt>Money</tt> by an integral divisor.
	  * 
	  * <P>The scale of the returned <tt>Money</tt> is equal to the scale of 
	  * 'this' <tt>Money</tt>. 
	  */
	public Money div(int aDivisor){
	    BigDecimal divisor = new BigDecimal(aDivisor);
	    BigDecimal newAmount = amount.divide(divisor);
	    return new Money(newAmount, currency);
	}
	
	/**
	 * Divide this <tt>Money</tt> by an non-integral divisor.
	 * 
	 * <P>The scale of the returned <tt>Money</tt> is equal to the scale of 
	 * 'this' <tt>Money</tt>. 
	 */
	 public Money div(double aDivisor){  
		 BigDecimal newAmount = amount.divide(new BigDecimal(aDivisor));
		 return new Money(newAmount, currency);
	}
	 
	 
	private void checkCurrenciesMatch(Money aThat){
		if (! this.currency.equals(aThat.getCurrency())) {
			throw new MismatchedCurrencyException(
		         aThat.getCurrency() + " doesn't match the expected currency : " + currency
		       ); 
		 }
	}
	
	/**
	 * Returns 
	 * {@link #getAmount()}.getPlainString() + space + {@link #getCurrency()}.toString().
	 * 
	 */
	public String toString(){
		return amount.toPlainString() + " " + currency.toString();
	}

}
