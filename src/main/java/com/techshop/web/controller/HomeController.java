package com.techshop.web.controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.google.gson.Gson;
import com.techshop.web.base.Constants;
import com.techshop.web.entity.Category;

@ManagedBean
@ViewScoped
public class HomeController {

	private static String GET_ALL_CATEGORY_API = Constants.PATH + "category/getAll";

	public String message() {
		return "Hello World!";
	}

	public List<Category> getAllCategory() {
		try {
			URL url = new URL(GET_ALL_CATEGORY_API);
			InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
			Gson gson = new Gson();
			Category[] categories = gson.fromJson(reader, Category[].class);
			return Arrays.asList(categories);
		}
		catch(IOException e) {
			return new ArrayList<>();
		}
	}
}
