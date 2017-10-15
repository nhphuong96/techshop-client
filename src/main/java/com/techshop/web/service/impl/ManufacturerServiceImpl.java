package com.techshop.web.service.impl;

import java.util.Arrays;
import java.util.List;

import com.techshop.web.base.Constants;
import com.techshop.web.entity.Manufacturer;
import com.techshop.web.service.ManufacturerService;
import com.techshop.web.utils.GsonParser;

public class ManufacturerServiceImpl implements ManufacturerService {

	private static String GET_ALL_MANUFACTURER = Constants.PATH + Constants.MANUFACTURER + Constants.GET_ALL;

	@Override
	public List<Manufacturer> getAllManufacturer() throws InstantiationException, IllegalAccessException {
		return Arrays.asList(GsonParser.getResult(GET_ALL_MANUFACTURER, Manufacturer[].class));
	}

}
