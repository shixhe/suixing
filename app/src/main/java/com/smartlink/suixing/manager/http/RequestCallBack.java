package com.smartlink.suixing.manager.http;

/**
 * 网络请求回掉接口
 * Created by shixhe on 2017/10/17.
 */

public interface RequestCallBack {
    /**
     * 请求开始
     * @param tag
     */
    void onStart(String tag);

    /**
     * 请求结束
     * @param tag
     */
    void onCompleted(String tag);

    /**
     * 请求失败
     * @param error
     * @param tag
     */
    void onFail(Throwable error, String tag);

    /**
     * 请求成功
     * @param result
     * @param tag
     */
    void onNext(String result, String tag);
}
