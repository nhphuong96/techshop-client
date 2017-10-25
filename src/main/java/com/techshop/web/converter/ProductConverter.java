package com.techshop.web.converter;

import com.techshop.web.entity.ProductInformation;
import com.techshop.web.model.ProductModel;

public interface ProductConverter {
	public ProductModel convert(ProductInformation pi);
}
