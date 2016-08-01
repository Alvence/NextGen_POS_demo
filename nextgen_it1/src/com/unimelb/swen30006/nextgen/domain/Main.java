package com.unimelb.swen30006.nextgen.domain;

import com.unimelb.swen30006.nextgen.datatype.Address;
import com.unimelb.swen30006.nextgen.ui.ProcessSaleJFrame;

public class Main {
	public static void main(String[] args){
		Address address = new Address("foo street","Melbourne","VIC","3000");
		ProductCatalog catalog = new ProductCatalog("products/");
		//Store is the initial domain
		Store store = new Store(address,"Foo Store", catalog);
		
		Register register = store.getRegister();
		
		ProcessSaleJFrame jframe = new ProcessSaleJFrame(register,catalog);
		jframe.setVisible(true);
	}
}
