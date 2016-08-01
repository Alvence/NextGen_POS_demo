package com.unimelb.swen30006.nextgen.domain;

import com.unimelb.swen30006.nextgen.datatype.ItemID;
import com.unimelb.swen30006.nextgen.datatype.Money;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Record the id, price and description of an item. see more on Chap 9.13
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-29
 *
 */
public class ProductDescription {

	//product id
	private ItemID id;
	//product price
	private Money price;
	//product name
	private String description;
	
	/**
	 * Full constructor
	 * @param id is required
	 * @param price is required
	 * @param description is required
	 */
	public ProductDescription(ItemID id, Money price, String description) {
		this.id = id;
		this.price = price;
		this.description = description;
	}

	public ItemID getItemId() {
		return id;
	}

	public Money getPrice() {
		return price;
	}

	public String getDescription() {
		return description;
	}
	
	@Override
	public String toString(){
		return id+ " " + description + " "+ price;
	}
}
