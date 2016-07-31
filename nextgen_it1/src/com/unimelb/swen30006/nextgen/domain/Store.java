package com.unimelb.swen30006.nextgen.domain;

public class Store{
	
	private ProductCatalog catalog = new ProductCatalog("products//");
	private Register register = new Register(catalog);
	
	public Register getRegister() { 
		return register; 
	}
}
