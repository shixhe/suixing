package com.smartlink.suixing.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.smartlink.suixing.R;


/***
 * loading图
 */
public class LoadingDialog extends Dialog {

	private Context			context;

	private ImageView		img_loading;

	private TextView		id_tv_loading;

	private RelativeLayout	layout_dialog;

	private Animation		operatingAnim;

	public LoadingDialog(Context context) {
		super(context, R.style.Dialog_bocop);
		this.context = context;
	}

	public void mShow(String msg) {
		id_tv_loading.setText(msg);
		mShow();
	}

	public void mShow() {
		this.show();
		Window window = this.getWindow();
		WindowManager.LayoutParams lp = window.getAttributes();
		lp.width = WindowManager.LayoutParams.MATCH_PARENT;
		lp.height = WindowManager.LayoutParams.MATCH_PARENT;
		// window.setGravity(Gravity.CENTER);
		window.setAttributes(lp);
		window.setWindowAnimations(R.style.loadingWindowAnim);
		if (Build.VERSION.SDK_INT >= 21) {
			View decorView = getWindow().getDecorView();
			int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
			decorView.setSystemUiVisibility(option);
			getWindow().setStatusBarColor(Color.TRANSPARENT);
		}
		setCanceledOnTouchOutside(false);
		operatingAnim = AnimationUtils.loadAnimation(context, R.anim.anim_circle);
		LinearInterpolator lin = new LinearInterpolator();
		operatingAnim.setInterpolator(lin);
		img_loading.startAnimation(operatingAnim);
	}

	@Override public void show() {
		super.show();
	}

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_loading);
		initView();
	}

	public void initView() {
		img_loading = findViewById(R.id.img_loading);
		id_tv_loading = findViewById(R.id.id_tv_loading);
		layout_dialog = findViewById(R.id.layout_dialog);
		layout_dialog.setOnClickListener(new View.OnClickListener() {

			@Override public void onClick(View v) {

			}
		});
		getWindow().setWindowAnimations(R.style.CustomProgressDialog);
	}

	@Override protected void onStop() {
		super.onStop();
		if (operatingAnim != null) {
			operatingAnim.cancel();
		}
	}

	@Override public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
		}
		return false;
	}

	public void show(String loadingText) {
		id_tv_loading.setText(loadingText);
		show();
	}

}
