package com.smartlink.suixing.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JSON解析器 封装gson解析
 */
public class GsonUtil {

	private static Gson gson;

	/**
	 * 获取Gson
	 * 
	 * @return
	 */
	public static Gson getGsonFilterNull() {
		if (gson == null) {
			GsonBuilder builder = new GsonBuilder();
			gson = builder.create();
		}

		return gson;
	}

	/**
	 * 获取Gson
	 * 
	 * @return
	 */
	public static Gson getGson() {
		if (gson == null) {
			GsonBuilder builder = new GsonBuilder();
			gson = builder.serializeNulls().create();
		}

		return gson;
	}

	/**
	 * 模型转json串
	 * 
	 * @return
	 */
	public static String getJson(Object obj) {
		if (obj == null || obj.equals("")) {
			return new JSONObject().toString();
		}
		Gson gson = GsonUtil.getGsonFilterNull();
		String s = gson.toJson(obj);
		return s;
	}

	/**
	 * 模型转json串(模型中含有html标准或者=号之类的) xcl
	 * 
	 * @return
	 */
	public static String GetHtmlJson(Object obj) {
		if (obj == null || obj.equals("")) {
			return new JSONObject().toString();
		}
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String s = gson.toJson(obj);
		return s;
	}

	/**
	 * 根据json串和对象类型创建对象
	 * 
	 * @param json
	 * @param type
	 * @return
	 */
	public static Object getModel(String json, Type type) {
		Gson gson = getGson();
		Object o = gson.fromJson(json, type);
		return o;
	}

	/**
	 * 根据json串和对象类型创建对象
	 * 
	 * @param <T>
	 * @param json
	 * @param cls
	 * @return
	 */
	public static <T> T getModel(String json, Class<T> cls) {
		Gson gson = getGson();
		T o = gson.fromJson(json, cls);
		return o;
	}

	/**
	 * 根据json串和对象类型创建对象
	 * 
	 * @param json
	 * @return
	 */
	public static <T> T getModel(String json) {
		Gson gson = getGson();
		T o = gson.fromJson(json, new TypeToken<T>() {}.getType());
		return o;
	}

	/**
	 * 返回集合对象
	 *
	 * @return
	 */
	public static <T> List<T> fromJsonArray(String json, Class<T> clazz) {
		List<T> lst = new ArrayList<T>();
		JsonArray array = new JsonParser().parse(json).getAsJsonArray();
		for (final JsonElement elem : array) {
			lst.add(new Gson().fromJson(elem, clazz));
		}
		return lst;
	}

	/***
	 * 将对象集合转成String
	 * @param list
	 * @return
	 */
	public static <T> String toJsonFromList(List<T> list) {
		Gson gson = new Gson();
		Type type = new TypeToken<List<T>>() {
		}.getType(); // 指定集合对象属性
		String json = gson.toJson(list, type);
		return json;
	}


	/**
	 * 把一个map变成json字符串
	 *
	 * @param map
	 * @return
	 */
	public static String parseMapToJson(Map<?, ?> map) {
		try {
			Gson gson = new Gson();
			return gson.toJson(map);
		} catch (Exception e) {
		}
		return null;
	}

	/***
	 * 将对象转成String
	 * @param object
	 * @return
	 */
	public static <T> String toJsonFromObject(Object object) {
		Gson gson = new Gson();
		String json = gson.toJson(object, Object.class);
		return json;
	}

}
