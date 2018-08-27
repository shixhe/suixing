package com.smartlink.suixing.bean;

/**
 * Created by 54966 on 2018/3/6.
 */

public class BaseBean<T> {

	int		state;

	T	data;

	String	msgCode;

	String	msgText;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Object getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsgText() {
		return msgText;
	}

	public void setMsgText(String msgText) {
		this.msgText = msgText;
	}
}
