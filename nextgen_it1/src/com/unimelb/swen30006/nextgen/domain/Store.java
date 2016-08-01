package com.unimelb.swen30006.nextgen.domain;

import java.util.ArrayList;
import java.util.List;

import com.unimelb.swen30006.nextgen.datatype.Address;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Represent a store, which contains information about address, name, product catalog, register and sale history.
 * 
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-29
 *
 */
public class Store{
	
	private Address address;
	private String name;
	private ProductCatalog catalog;
	private Register register;
	private List<Sale> completeSales = new ArrayList<Sale>();
	
	public Store(Address address,String name,ProductCatalog catalog){
		this.address = address;
		this.name = name;
		this.catalog = catalog;
		register = new Register(catalog,this);
	}
	
	/**
	 * add complete sale for log purpose. Acceptable for early stage where Store does not have many responsibilities.
	 * @param sale
	 */
	public void addCompleteSale(Sale sale){
		completeSales.add(sale);
	}
	
	public Register getRegister() { 
		return register; 
	}

	public Address getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	public ProductCatalog getCatalog() {
		return catalog;
	}
	
	
}
