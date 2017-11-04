package com.techshop.web.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.ejb.Stateless;

import com.techshop.web.base.Constants;
import com.techshop.web.entity.Manufacturer;
import com.techshop.web.service.ManufacturerService;
import com.techshop.web.utils.GsonParser;

@Stateless
public class ManufacturerServiceImpl implements ManufacturerService {

	private static String GET_ALL_MANUFACTURER = Constants.PATH + Constants.MANUFACTURER + Constants.GET_ALL;
	private static String GET_MANUFACTURER = Constants.PATH + Constants.MANUFACTURER + Constants.GET + "?" + Constants.ID + "=";
	
	@Override
	public List<Manufacturer> getAllManufacturer() {
		return Arrays.asList(GsonParser.getResult(GET_ALL_MANUFACTURER, Manufacturer[].class));
	}

	@Override
	public Manufacturer getManufacturerById(Long id) {
		return GsonParser.getResult(GET_MANUFACTURER + id, Manufacturer.class);
	}

}
