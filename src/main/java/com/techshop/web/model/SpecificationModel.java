package com.techshop.web.model;

import com.techshop.web.entity.SpecificationType;

public class SpecificationModel {
	
	private SpecificationType type;
	private String value;
	
	public SpecificationModel(SpecificationType type, String value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	public SpecificationType getType() {
		return type;
	}
	public void setType(SpecificationType type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
