package com.smartlink.suixing.utils;

import android.view.Gravity;
import android.widget.Toast;

import com.smartlink.suixing.App;


/**
 * Created by wuxiaojun on 16-10-2.
 */
public class ToastUtils {

	private static Toast	mToast;

	private static Toast	mLongToast;

	public static void show(String content) {
		if (mToast == null) {
			mToast = Toast.makeText(App.getAppContext(), content, Toast.LENGTH_SHORT);
		}

		mToast.setText(content);
		mToast.setDuration(Toast.LENGTH_SHORT);
		mToast.setGravity(Gravity.CENTER,0,0);
		mToast.show();
	}

	public static void show(int resId) {
		if (mToast == null) {
			mToast = Toast.makeText(App.getAppContext(), App.getAppContext().getResources().getString(resId), Toast.LENGTH_SHORT);
		}
		mToast.setText(App.getAppContext().getResources().getString(resId));
		mToast.setDuration(Toast.LENGTH_SHORT);
		mToast.setGravity(Gravity.CENTER,0,0);
		mToast.show();
	}

	public static void cancel() {
		if (mToast != null) {
			mToast.cancel();
		}
		if (mLongToast != null) {
			mLongToast.cancel();
		}
	}

	public static void showThree(int resId) {
		if (mLongToast == null) {
			mLongToast = Toast.makeText(App.getAppContext(), App.getAppContext().getResources().getString(resId), Toast.LENGTH_LONG);
		}
		mLongToast.setText(App.getAppContext().getResources().getString(resId));
		mLongToast.setDuration(Toast.LENGTH_LONG);
		mLongToast.setGravity(Gravity.CENTER,0,0);
		mLongToast.show();
	}

}
