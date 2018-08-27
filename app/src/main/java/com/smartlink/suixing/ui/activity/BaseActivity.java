package com.smartlink.suixing.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.smartlink.suixing.R;
import com.smartlink.suixing.presenter.BasePresenter;
import com.smartlink.suixing.presenter.view.IBaseView;
import com.smartlink.suixing.utils.ActivityManager;
import com.smartlink.suixing.utils.StatusBarUtil;
import com.smartlink.suixing.utils.ToastUtils;
import com.smartlink.suixing.view.LoadingDialog;

import butterknife.ButterKnife;

/**
 * Created by wuxiaojun on 2018/8/27.
 */

public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements IBaseView {

    protected P				mPresenter;
    private LoadingDialog mDialog;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 系统 6.0 以上 状态栏白底黑字的实现方法
        setContentView(getContentViewId());
        ButterKnife.bind(this);
//        initOnCreate(savedInstanceState);
        ActivityManager.getActivityManager().addActivity(this);
        mDialog = new LoadingDialog(this);

        initView();
        initEvent();
        initData();
    }

    protected abstract int getContentViewId();

//    private void initOnCreate(Bundle savedInstanceState) {
//        if (null != savedInstanceState) {
//            Intent mIntent = new Intent(this, SplashActivity.class);
//            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(mIntent);
//            finish();
//        }
//    }

    protected void initView() {}

    protected void initEvent() {

    }

    protected void initData() {}

    @Override protected void onDestroy() {
        hideLoading();
        if (mPresenter != null) {
            mPresenter.unsubscribe();
            mPresenter.detachView();
        }
        super.onDestroy();
        ActivityManager.getActivityManager().removeActivity(this);
        // RefWatcher refWatcher = App.getRefWatcher(this);// 1
        // refWatcher.watch(this);
    }

    @Override protected void onPause() {
        super.onPause();
    }

    @Override protected void onResume() {
        super.onResume();
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override protected void onStart() {
        super.onStart();
        setStatusBar();
    }

    protected void setStatusBar() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.color_000000), 60);
    }

    @Override protected void onStop() {
        super.onStop();

    }

    protected void showToast(String resourceStr) {
        ToastUtils.show(resourceStr);
    }

    /**
     * 展示加载提示框
     */
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

    @Override public void showError(String error) {
        ToastUtils.show(error);
    }

    @Override public void showError(int resId) {
        showToast(resId);
    }

    protected void showToast(int resId) {
        ToastUtils.show(resId);
    }

    @Override protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

}
