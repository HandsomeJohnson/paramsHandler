package com.hexincad.test;

import com.hexincad.util.HttpClientUtils;

public class HttpClientTest {
	
	public static void main(String[] args){
		
		String result = HttpClientUtils.httpGetRequest("https://www.hao123.com");
		System.out.println(result);
	}

}
