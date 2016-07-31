package com.unimelb.swen30006.nextgen.domain;

public class Register {
	private ProductCatalog catalog;
	
	public Register(ProductCatalog catalog) {
		this.catalog = catalog;
	}

	public ProductCatalog getCatalog(){
		return catalog;
	}

}
