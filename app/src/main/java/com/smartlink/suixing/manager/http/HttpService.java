package com.smartlink.suixing.manager.http;

import android.os.Build;
import android.util.Log;
import android.webkit.WebSettings;

import com.smartlink.suixing.App;
import com.smartlink.suixing.manager.api.ServiceApi;
import com.smartlink.suixing.utils.Constant;
import com.smartlink.suixing.utils.LogUtils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shixhe on 2017/10/17.
 */

public class HttpService {

	private final static int	DEFAULT_TIMEOUT	= 15;

	private static ServiceApi requestInterface;

	private static String		userAgent;

	public static ServiceApi getRequestInterface() {
		if (requestInterface == null) {
			HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {

				@Override public void log(String message) {
					// 打印retrofit日志
					Log.i("返回数据", "retrofitBack = " + message);
				}
			});
			loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

			// 添加head
			Interceptor interceptor = new Interceptor() {

				@Override public Response intercept(Chain chain) throws IOException {
					// 移除旧的user-agent，添加新的
					if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
						userAgent = WebSettings.getDefaultUserAgent(App.getAppContext());
					} else {
						userAgent = getUserAgent();
					}
					LogUtils.e("User-Agent=" + userAgent);
					Request build = chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", userAgent).build();
					return chain.proceed(build);
				}
			};

			OkHttpClient client = new OkHttpClient.Builder().addInterceptor(loggingInterceptor).addInterceptor(interceptor).connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
					.writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS).build();

			requestInterface = new Retrofit.Builder().baseUrl(Constant.URL_BASE).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create())
					.client(client).build().create(ServiceApi.class);
		}
		return requestInterface;
	}

	/**
	 * 返回正确的UserAgent
	 * 
	 * @return
	 */
	private static String getUserAgent() {
		String userAgent = "";
		StringBuffer sb = new StringBuffer();
		userAgent = System.getProperty("http.agent");// Dalvik/2.1.0 (Linux; U; Android 6.0.1; vivo X9L Build/MMB29M)

		for (int i = 0, length = userAgent.length(); i < length; i++) {
			char c = userAgent.charAt(i);
			if (c <= '\u001f' || c >= '\u007f') {
				sb.append(String.format("\\u%04x", (int) c));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
