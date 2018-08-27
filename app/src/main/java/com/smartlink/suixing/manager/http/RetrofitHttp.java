package com.smartlink.suixing.manager.http;

/**
 * 获取网络请求工具类对象 Created by shixhe on 2017/10/17.
 */

public class RetrofitHttp {

	private static MyRequest myRequest;

	public static MyRequest getMyRequest() {
		if (myRequest == null) {
			myRequest = new MyRequest();
		}
		return myRequest;
	}
}
