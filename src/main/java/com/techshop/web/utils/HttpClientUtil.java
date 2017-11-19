package com.techshop.web.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

public class HttpClientUtil {

	public static EntityResult excutePostMethod(String api, String obj) throws ClientProtocolException, IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		
		try {

		    HttpPost request = new HttpPost(api);
		    StringEntity params = new StringEntity(obj, Charset.forName("UTF-8"));
		    request.addHeader("content-type", "application/json;charset=utf-8");
		    request.setEntity(params);
		    HttpResponse response = httpClient.execute(request);
		    
		    String result = EntityUtils.toString(response.getEntity());
		    System.out.println(result);
		    return new Gson().fromJson(result, EntityResult.class);
		}
		catch (Exception ex) {
			return new EntityResult(null, "Fail", false);
		}
	}
}
