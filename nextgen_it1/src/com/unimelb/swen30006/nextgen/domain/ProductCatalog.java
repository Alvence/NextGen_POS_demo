package com.unimelb.swen30006.nextgen.domain;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.unimelb.swen30006.nextgen.datatype.ItemID;
import com.unimelb.swen30006.nextgen.datatype.Money;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Represent a product catalog
 * 
 * This class is created based on Chap 20.11
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-07-29
 *
 */
public class ProductCatalog
{
	private Map<ItemID, ProductDescription> descriptions = new HashMap<ItemID, ProductDescription>();
	
	/**
	 * constructor with directory of product description files
	 * @param dir directory of product description files
	 */
	public ProductCatalog(String dir){
		loadProduct(dir);
	}
	
	/**
	 * @param id item id
	 * @return the product description of give id
	 */
	public ProductDescription getProductDescription(ItemID id)
	{
		return descriptions.get(id);
	}
	
	public Set<ItemID> getIDs(){
		return descriptions.keySet();
	}
	
	private void loadProduct(String dir){
		final File folder = new File(dir);
		for (final File fileEntry : folder.listFiles()) {
			Properties prop = new Properties();
			try {
				prop.load(new FileReader(fileEntry.getPath()));
				ItemID id = new ItemID(prop.get("itemId").toString());
				Money price = new Money(new BigDecimal(prop.getProperty("price")));
				String description = prop.getProperty("description");
			
				ProductDescription desc = new ProductDescription(id,price,description);
				descriptions.put(id,desc);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
