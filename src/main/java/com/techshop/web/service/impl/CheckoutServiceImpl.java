package com.techshop.web.service.impl;

import java.io.IOException;

import javax.ejb.Stateless;

import org.apache.http.client.ClientProtocolException;

import com.google.gson.Gson;
import com.techshop.web.base.Constants;
import com.techshop.web.model.CheckoutInformationModel;
import com.techshop.web.service.CheckoutService;
import com.techshop.web.utils.EntityResult;
import com.techshop.web.utils.HttpClientUtil;

@Stateless
public class CheckoutServiceImpl implements CheckoutService {

	private static String SAVE_CHECKOUT_INFORMATION = Constants.PATH + Constants.CHECKOUT + Constants.SAVE;
	
	@Override
	public void saveCheckOutInformation(CheckoutInformationModel model) throws ClientProtocolException, IOException {
		String checkoutJSON = new Gson().toJson(model);
		EntityResult result = HttpClientUtil.excutePostMethod(SAVE_CHECKOUT_INFORMATION, checkoutJSON);
		if (result.getSuccess() == false) {
			throw new IOException();
		}
	}

//	private Customer parseCustomerInformation(CheckoutInformationModel model) {
//		Customer customer = new Customer();
//		customer.setAddress(model.getAddress());
//		customer.setCity(model.getCity());
//		customer.setCompany(model.getCompany());
//		customer.setEmail(model.getEmail());
//		customer.setFullname(model.getFullname());
//		customer.setPhoneNumber(model.getPhoneNumber());
//		return customer;
//	}
}
