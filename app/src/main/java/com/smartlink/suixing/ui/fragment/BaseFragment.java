package com.smartlink.suixing.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.smartlink.suixing.presenter.BasePresenter;
import com.smartlink.suixing.presenter.view.IBaseView;
import com.smartlink.suixing.utils.ToastUtils;
import com.smartlink.suixing.view.LoadingDialog;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by 54966 on 2018/3/5.
 */

public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {

	private LoadingDialog mDialog;

	protected P				mPresenter;

	Unbinder unbinder;

	@Override public void onAttach(Context context) {
		super.onAttach(context);
	}

	@Override public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Nullable @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(getContentViewId(), container, false);
		unbinder = ButterKnife.bind(this, view);
		mDialog = new LoadingDialog(getActivity());
		initView();
		initEvent();
		initData();
		return view;
	}

	protected abstract int getContentViewId();

	protected void initView() {

	}

	protected void initEvent() {

	}

	protected void initData() {

	}

	@Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override public void onStart() {
		super.onStart();
	}

	@Override public void onResume() {
		super.onResume();
	}

	@Override public void onPause() {
		super.onPause();
	}

	@Override public void onStop() {
		super.onStop();
	}

	protected void showToast(int resId) {
		ToastUtils.show(resId);
	}

	protected void showToast(String resId) {
		ToastUtils.show(resId);
	}

	@Override public void showLoading() {
		if (mDialog != null && !mDialog.isShowing()) {
			mDialog.mShow();
		}
	}

	@Override public void hideLoading() {
		if (mDialog != null && mDialog.isShowing()) {
			mDialog.cancel();
		}
	}

	@Override public void showError(int resId) {
		showToast(resId);
	}

	@Override public void showError(String error) {
		ToastUtils.show(error);
	}


	@Override public void onDestroyView() {
		super.onDestroyView();
		hideLoading();
		if (mPresenter != null) {
			mPresenter.detachView();
		}
		unbinder.unbind();
	}

	@Override public void onDestroy() {
		super.onDestroy();
	}

	@Override public void onDetach() {
		super.onDetach();
	}

}
