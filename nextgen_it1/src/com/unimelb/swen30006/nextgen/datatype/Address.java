package com.unimelb.swen30006.nextgen.datatype;

/**
 * This class is created based on case study of NextGen POS system of "Applying UML and Patterns, 3rd edition by Craig Larman".
 * For demonstration on subject SWEN30006 at The University of Melbourne 
 * 
 * Non-primitive Data Type Class.
 * 
 * 
 * @author 	Yunzhe(Alvin) Jia
 * @version 1.0
 * @since 	2016-08-01
 *
 */
public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	
	/**
	 * full constructor
	 * @param street the street
	 * @param city the city
	 * @param state the state
	 * @param zip the postal code
	 */
	public Address(String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	/**
	 * return the address
	 * @return a string in mailing format
	 */
	@Override
	public String toString(){
		return street + "\n"
				+ city + "," + state + " "+zip;
	}

}
