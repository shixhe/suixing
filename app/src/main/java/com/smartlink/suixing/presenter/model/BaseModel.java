package com.smartlink.suixing.presenter.model;

import android.util.Log;


import com.smartlink.suixing.bean.BaseBean;
import com.smartlink.suixing.manager.http.RequestCallBack;
import com.smartlink.suixing.manager.http.RetrofitHttp;
import com.smartlink.suixing.manager.rxbus.RxBus;
import com.smartlink.suixing.utils.ActivityManager;
import com.smartlink.suixing.utils.GsonUtil;
import com.smartlink.suixing.utils.LogUtils;
import com.smartlink.suixing.utils.ToastUtils;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscription;

/**
 * 数据模型基类 Created by shixhe on 2017/10/17.
 */

public class BaseModel implements RequestCallBack {

    public Subscription subscription;

    protected void request(Observable<ResponseBody> observable) {
        subscription = RetrofitHttp.getMyRequest().onRequest(observable, this);
    }

    protected void request(Observable<ResponseBody> observable, String tag) {
        subscription = RetrofitHttp.getMyRequest().onRequest(observable, tag, this);
    }

    public void unsubscribe() {
        RetrofitHttp.getMyRequest().unsubscribe(subscription);
    }

    @Override
    public void onStart(String tag) {

    }

    @Override
    public void onCompleted(String tag) {

    }

    @Override
    public void onFail(Throwable error, String tag) {
        LogUtils.e("onFail=" + error.toString());
        Log.e("onFail", "onFail=" + error.toString());
        // modelCallBack.fail(R.string.general_request_fail, tag);
    }

    @Override
    public void onNext(String result, String tag) {
        if (result != null) {
            BaseBean baseBean = GsonUtil.getModel(result, BaseBean.class);
            if (baseBean.getState() == 0) {
                // onSucceed(GsonUtil.getJson(baseBean.getData()), tag);
                onSucceed(getResult(result), tag);
            } else {
//				onStateResponseErrorInfo(baseBean.getMsgText(), tag);
                onStateResponseErrorInfo(baseBean.getMsgText(), baseBean.getMsgCode(), tag);
            }
        }
    }

    public void onSucceed(String result, String tag) {

    }

    private String getResult(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if (jsonObject.has("data")) {
                return jsonObject.getString("data");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

//	public void onStateResponseErrorInfo(String result, String tag) {}

    public void onStateResponseErrorInfo(String result, String msgCode, String tag) {
    }

}
