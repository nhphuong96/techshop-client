package com.techshop.web.base;

import javax.faces.context.FacesContext;

public class Constants {
	
	public static final String CONTEXT_PATH = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
	public static final String PATH = "http://localhost:8080/techshop-data/api";
	public static final String CATEGORY = "/category";
	public static final String MANUFACTURER = "/manufacturer";
	public static final String PRODUCT = "/product";
	public static final String SPECIFICATION_TYPE = "/specificationtype";
	public static final String ORDER = "/order";
	public static final String CUSTOMER = "/customer";
	public static final String PAYMENT = "/payment";
	public static final String CHECKOUT = "/checkout";
	
	/** API */
	public static final String GET_ALL = "/getAll";
	public static final String GET = "/get";
	public static final String SAVE = "/save";
	public static final String DELETE_BY_ID = "/deleteById";
	public static final String UPDATE = "/update";
	
	/** COMMON QUERY PARAM*/
	public static final String ID = "id";
	
}
