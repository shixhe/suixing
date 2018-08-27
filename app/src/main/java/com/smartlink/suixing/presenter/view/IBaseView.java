package com.smartlink.suixing.presenter.view;

/**
 * View层接口 Created by shixhe on 2017/10/18.
 */

public interface IBaseView {

	/**
	 * 显示加载图
	 */
	public void showLoading();

	/**
	 * 隐藏加载图
	 */
	public void hideLoading();

	/**
	 * 加载错误信息展示
	 * 
	 * @param error
	 */
	public void showError(String error);

	public void showError(int resId);
}
