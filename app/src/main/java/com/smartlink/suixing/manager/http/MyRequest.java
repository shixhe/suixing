package com.smartlink.suixing.manager.http;

import java.io.IOException;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 网络请求 Created by shixhe on 2017/10/17.
 */

public class MyRequest implements HttpRequset {

	@Override public Subscription onRequest(Observable<ResponseBody> observable, RequestCallBack callBack) {
		return onRequest(observable, "", callBack);
	}

	@Override public Subscription onRequest(Observable<ResponseBody> observable, String tag, RequestCallBack callBack) {
		return observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new RequestSubscriber(tag, callBack));
	}

	public void unsubscribe(Subscription subscribe) {
		if (subscribe != null && !subscribe.isUnsubscribed()) {
			subscribe.unsubscribe();
		}
	}

	private class RequestSubscriber extends Subscriber<ResponseBody> {

		private String			tag;

		private RequestCallBack	requestCallBack;

		public RequestSubscriber(String tag, RequestCallBack requestCallBack) {
			this.tag = tag;
			this.requestCallBack = requestCallBack;
		}

		@Override public void onStart() {
			super.onStart();
			if (requestCallBack != null) {
				requestCallBack.onStart(tag);
			}
		}

		@Override public void onCompleted() {
			if (requestCallBack != null) {
				requestCallBack.onCompleted(tag);
			}
		}

		@Override public void onError(Throwable e) {
			if (requestCallBack != null) {
				requestCallBack.onFail(e, tag);
			}
		}

		@Override public void onNext(ResponseBody responseBody) {
			String result = "";
			try {
				result = responseBody.string().trim();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (requestCallBack != null) {
				requestCallBack.onNext(result, tag);
			}
		}
	}
}
