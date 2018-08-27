package com.smartlink.suixing.presenter;

import com.smartlink.suixing.R;
import com.smartlink.suixing.presenter.model.BaseModel;
import com.smartlink.suixing.presenter.view.IBaseView;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by 54966 on 2018/3/26.
 */

public class BasePresenter<V extends IBaseView> extends BaseModel {

	protected V mView;

	public BasePresenter(V view) {
		attachView(view);
	}

	public void attachView(V view) {
		this.mView = view;
	}

	protected void request2(Observable<ResponseBody> observable) {
		if (mView != null) {
			mView.showLoading();
		}
		request(observable);
	}

	protected void request2(Observable<ResponseBody> observable, String tag) {
		if (mView != null) {
			mView.showLoading();
		}
		request(observable, tag);
	}

	@Override
	public void onSucceed(String result, String tag) {
		onSucceed2(result,tag);
		super.onSucceed(result, tag);
	}

	protected void onSucceed2(String result, String tag) {
		if (mView != null) {
			mView.hideLoading();
		}
		super.onSucceed(result, tag);
	}

	@Override public void onFail(Throwable error, String tag) {
		super.onFail(error, tag);
		if (mView != null) {
			mView.hideLoading();
			mView.showError(R.string.string_general_fail);
		}
	}

//	@Override public void onStateResponseErrorInfo(String result, String tag) {
//		super.onStateResponseErrorInfo(result, tag);
//        onStateResponseErrorInfo(result,"",tag);
//	}

	@Override
	public void onStateResponseErrorInfo(String result, String msgCode, String tag) {
		super.onStateResponseErrorInfo(result, msgCode, tag);
        if (mView != null) {
            mView.hideLoading();
            mView.showError(result);
        }
	}

	public void detachView() {
		if (mView != null) {
			mView = null;
		}
	}

}
