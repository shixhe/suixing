package com.smartlink.suixing.utils;




import com.smartlink.suixing.ui.activity.BaseActivity;

import java.util.Stack;

/**
 * Created by wuxiaojun on 17-8-7.
 */

public class ActivityManager {

    private static Stack<BaseActivity> activityStack;

    private static ActivityManager instance;

    public static ActivityManager getActivityManager() {
        if (instance == null) {
            instance = new ActivityManager();
            activityStack = new Stack<>();
        }
        return instance;
    }

    public void addActivity(BaseActivity activity) {
        activityStack.add(activity);
    }

    public BaseActivity getCurrentActivity() {
        BaseActivity activity = activityStack.lastElement();
        return activity;
    }

    public void removeActivity(BaseActivity activity) {
        if (activityStack.contains(activity)) {
            activityStack.remove(activity);
        }
    }

    public void finishActivity() {
        BaseActivity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    public void finishActivity(BaseActivity activity) {
        if (activity != null) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    public void finishActivity(Class<?> cls) {
        for (BaseActivity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    public void finishAllActivity() {
        int size = activityStack.size();
        for (int i = 0; i < size; i++) {
            if (activityStack.get(i) != null) {
                activityStack.get(i).finish();
            }
        }
    }

//	public void finishAllActivityAlsoStartLoginActivity() {
//		int size = activityStack.size();
//		for (int i = 0; i < size; i++) {
//			if (activityStack.get(i) != null) {
//				if (i == size - 1) {
//					activityStack.get(i).startActivity(new Intent(activityStack.get(i), LoginActivity.class));
//				}
//				activityStack.get(i).finish();
//			}
//		}
//	}

    /***
     * 获取当前上一个activity
     *
     * @return
     */
    public BaseActivity getCurrentLastActivity() {
        int size = activityStack.size();
        if (size > 0) {
            if (size == 1) {
                return getCurrentActivity();
            } else {
                return activityStack.get(size - 2);
            }
        }
        return null;
    }

    /***
     * 关闭除MainActivity之外的其他Activity
     */
//	public void finishOtherActivity() {
//		int size = activityStack.size();
//		for (int i = 0; i < size; i++) {
//			if (activityStack.get(i) != null) {
//				if (!activityStack.get(i).getClass().getName().equals(MainActivity.class.getName())) {
//					activityStack.get(i).finish();
//				}
//			}
//		}
//	}

    /***
     * 跳转到登录
     */
//	public void startLoginActivity() {
//		Intent mIntent = new Intent(getCurrentActivity(), LoginActivity.class);
    // mIntent.putExtra(ActionUtils.ACTION_LOGIN, new LoginAction(true,
    // getCurrentActivity().getClass().getName(), -1));
//		getCurrentActivity().startActivity(mIntent);
//	}


}
