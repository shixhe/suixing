package com.smartlink.suixing.manager.http;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscription;

/**
 * 网络请求规范
 * Created by shixhe on 2017/10/17.
 */

public interface HttpRequset {

    /**
     * 网络请求
     * @param observable
     * @param callBack
     */
    Subscription onRequest(Observable<ResponseBody> observable, RequestCallBack callBack);

    /**
     * @param observable
     * @param tag
     * @param callBack
     */
    Subscription onRequest(Observable<ResponseBody> observable, String tag, RequestCallBack callBack);

}
