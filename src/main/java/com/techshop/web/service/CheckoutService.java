package com.techshop.web.service;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import com.techshop.web.model.CheckoutInformationModel;

public interface CheckoutService {
	public void saveCheckOutInformation(CheckoutInformationModel model) throws ClientProtocolException, IOException;
}
