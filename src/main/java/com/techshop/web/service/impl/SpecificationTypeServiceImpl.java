package com.techshop.web.service.impl;

import javax.ejb.Stateless;

import com.techshop.web.base.Constants;
import com.techshop.web.entity.SpecificationType;
import com.techshop.web.service.SpecificationTypeService;
import com.techshop.web.utils.GsonParser;

@Stateless
public class SpecificationTypeServiceImpl implements SpecificationTypeService {

	private static String GET_SPECIFICATION_API = Constants.PATH + Constants.SPECIFICATION_TYPE + Constants.GET + "?" + Constants.ID + "=";
	
	@Override
	public SpecificationType getById(Long id) {
		SpecificationType si = GsonParser.getResult(GET_SPECIFICATION_API + id, SpecificationType.class);
		return si;
	}

}
