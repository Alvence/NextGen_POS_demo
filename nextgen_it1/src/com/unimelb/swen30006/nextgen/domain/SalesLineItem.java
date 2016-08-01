package com.unimelb.swen30006.nextgen.domain;

import com.unimelb.swen30006.nextgen.datatype.Money;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-29
 *
 */
public class SalesLineItem
{
	private int quantity;
	private ProductDescription description;

	/**
	 * full constructor
	 * @param desc the description
	 * @param quantity the quantity
	 */
	public SalesLineItem (ProductDescription desc, int quantity ){
		this.description = desc;
		this.quantity = quantity;
	}

	/**
	 * get subtotal price
	 * @return subtotal price
	 */
	public Money getSubtotal(){
		return description.getPrice().times(quantity);
	}
	/**
	 * output string in "ID description quantity" format
	 * @return
	 */
	@Override
	public String toString(){
		return description.toString() +"  Qty:"+quantity;
	}
}