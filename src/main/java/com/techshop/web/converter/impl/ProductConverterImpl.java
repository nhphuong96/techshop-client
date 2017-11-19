package com.techshop.web.converter.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.techshop.web.converter.ProductConverter;
import com.techshop.web.entity.Category;
import com.techshop.web.entity.Manufacturer;
import com.techshop.web.entity.ProductInformation;
import com.techshop.web.entity.SpecificationInformation;
import com.techshop.web.entity.SpecificationType;
import com.techshop.web.model.ProductModel;
import com.techshop.web.model.SpecificationModel;
import com.techshop.web.service.CategoryService;
import com.techshop.web.service.ManufacturerService;
import com.techshop.web.service.SpecificationTypeService;

@Stateless
public class ProductConverterImpl implements ProductConverter {
	
	@EJB
	private SpecificationTypeService stService; 
	@EJB
	private ManufacturerService manufacturerService;
	@EJB
	private CategoryService categoryService;
	

	@Override
	public ProductModel convert(ProductInformation pi) {
		if (pi == null) {
			return new ProductModel();
		}
		ProductModel pm = new ProductModel();
		pm.setId(pi.getId());
		pm.setProductName(pi.getProductName());
		pm.setAlias(pi.getAlias());
		Category category = categoryService.getById(pi.getCategoryId());
		pm.setCategoryId(category);
		pm.setImage1(pi.getImage1());
		pm.setImage2(pi.getImage2());
		pm.setImage3(pi.getImage3());
		pm.setDescriptionHTML(pi.getDescriptionHTML());
		Manufacturer manufacturer = manufacturerService.getManufacturerById(pi.getManufacturerId());
		pm.setManufacturerId(manufacturer);
		pm.setPrice(Integer.valueOf(pi.getPrice()));
		List<SpecificationModel> specModels = new ArrayList<>();
		List<SpecificationInformation> specInfos = pi.getSpecificationInfos();
		for (SpecificationInformation si : specInfos) {
			SpecificationType st = stService.getById(si.getId());
			specModels.add(new SpecificationModel(st, si.getValue()));
		}
		pm.setSpecificationInfos(specModels);
		return pm;
		
	}

}
