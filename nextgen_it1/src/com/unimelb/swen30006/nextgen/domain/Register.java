package com.unimelb.swen30006.nextgen.domain;

import com.unimelb.swen30006.nextgen.datatype.ItemID;
import com.unimelb.swen30006.nextgen.datatype.Money;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Represent a register, based on Figure 20.3
 * 
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-08-01
 *
 */
public class Register {
	private Store store;
	private ProductCatalog catalog;
	private Sale currentSale = null;
	
	public Register(ProductCatalog catalog, Store store) {
		this.catalog = catalog;
		this.store = store;
	}

	/**
	 * start a new sale
	 */
	public void makeNewSale(){
		currentSale = new Sale();
	}
	
	/**
	 * end current sale
	 */
	public void endSale(){
		//TODO should first check whether whether there is a new sale started and not complete yet.
		currentSale.becomeComplete();
	}
	
	/**
	 * Method for entering a new item. specified in Figure 20.2
	 * @param id item id
	 * @param quantity item quantity
	 */
	public void enterItem(ItemID id, int quantity){
		//TODO should first check whether whether there is a new sale started and not complete yet.
		ProductDescription desc = catalog.getProductDescription(id);
		currentSale.makeLineItem(desc, quantity);
	}
	
	/**
	 * payment for current sale, based on Figure 18.15
	 * @param cashTendered
	 */
	public void makePayment(Money cashTendered){
		//TODO should first check whether the sale is complete or not
		currentSale.makePayment(cashTendered);
		store.addCompleteSale(currentSale);
	}
	
	/**
	 * output a simple format receipt
	 * @return
	 */
	public String printReceipt(){
		return currentSale.printReceipt();
	}

	public Money getTotal(){
		return currentSale.getTotal();
	}
}
