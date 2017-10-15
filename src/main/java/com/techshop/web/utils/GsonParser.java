package com.techshop.web.utils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

public final class GsonParser {

	private GsonParser() {}
	
	public static <T> T getResult(String api, Class<T> type) throws InstantiationException, IllegalAccessException {
		try {
			URL url = new URL(api);
			InputStreamReader reader = new InputStreamReader(url.openStream(), "UTF-8");
			Gson gson = new Gson();
			T object = gson.fromJson(reader, type);
			return object;
		}
		catch(IOException e) {
			return type.newInstance();
		}
	}
	
}
