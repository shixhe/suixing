package com.smartlink.suixing.utils;

/**
 * Created by 54966 on 2018/3/6.
 */

public class Constant {

	public static final String	SECRET_KEY									= "c159016e9b3335e38011bd7ec65e8c2d";	// 请求参数签名密钥

	public static String		CHANNEL										= "official";							// 渠道

	public static final String	IS_LOGIN									= "islogin";

	public static final String	VERSION_SERVER								= "1.6";								// 调用的接口版本

	public static String		VERSION_APP									= "1.0";								// 客户端版本

	public static final String	APP_ID										= "5";									// 由服务器端统一分配的客户端App id

	public static final String	T											= "t";									// 用户登录票据，登录成功时客户端返回给客户端

	public static final String	UID											= "uid";								// 用户id，登录成功时客户端返回

	public static final String	LANGUAGE									= "language";

	public static final String	COUNTRY										= "country";

	public static final String	LON											= "lon";

	public static final String	LAT											= "lat";

	/***
	 * 测试请求路径 http://39.106.97.108/miningC/api/ 正式请求路径 http://api.tanqian.me/api/
	 */
	public static String		URL_BASE									= "http://39.106.97.108/miningC/api/";

	public static final String	WX_APP_ID									= "wx29cc901ec4442fef";					// 微信分享appid

	public static final String	WX_APP_SECRETE								= "b0980945c98c717113c7b75a2e9878d0";	// 微信分享appSecret

	public static final String	QQ_APP_ID									= "1106748739";							// QQ分享appid

	public static final int		HEIGHT_DIVIDER_LINE							= 1;									// recyclerview的分割线高度
	public static final float		HEIGHT_DIVIDER_LINE_FLOAT							= 0.5f;									// recyclerview的分割线高度

	public static final int		TYPE_LOGOUT									= 3;									// 退出登录

	public static final int		TYPE_DESTROY_RAIDERS_AND_MY					= 4;									// 销毁攻略和我的页面

	public static final int		TYPE_UPDATE_MSG_CENTER						= 1;									// 更新我的界面的消息中心红点

	public static final String	TAG_LOAD_USER_HASHRATE						= "tag_loadUserHashrate";				// 加载用户弹力值

	public static final String	LICENSE_ID									= "tanqian-face-android";				// 申请License取得的APPID

	public static final String	LICENSE_FILE_NAME							= "idl-license.face-android";			// assets目录下License文件名

	public static final String	NAME_AUTH_STATE								= "name_auth_state";					// 实名认证状态 0-表示没有实名1-审核中2-未通过审核3-已认证

	public static final String	IS_FACE_AUTH								= "is_face_auth";						// 是否人脸认证

	public static final int		LIVING_PLANET_0								= 0;									// 火星

	public static final int		LIVING_PLANET_1								= 1;									// 地球

	public static final String	SNS_PLANET									= "snsPlanet";							// 火星地球标识

	public static final String	CITY_STATUS									= "cityStatus";							// 是否认证过标识

	public static final String	BUILDINGNUMS								= "buildingNums";						// 用户需要建筑草坪的数量

	public static final String	HAS_BIND_WEIXIN								= "hasBindWeixin";						// 用户 是否绑定微信

	public static final String	FROM_LOGINOUT								= "from_logout";						// 用户 是否绑定微信

	public static final String	USER_NAME								= "user_name";						// 用户名称

	/**
	 * 1 市政中心 2 服装 3 饰器 4 食物 5 饮品 6 居住 7 医疗 8 公交站 9 4S专卖 10 市政中心 11 广场 12 市政中心
	 */
	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_FREE			= 1;									// 地球-市政中心-免费

	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_CHARGE_10	= 10;									// 地球-市政中心-收费

	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_CHARGE_13	= 13;									// 地球-市政中心-收费

	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_CHARGE_14	= 14;									// 地球-市政中心-收费

	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_CHARGE_15	= 15;									// 地球-市政中心-收费

	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_CHARGE_16	= 16;									// 地球-市政中心-收费

	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_CHARGE_17	= 17;									// 地球-市政中心-收费

	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_CHARGE_18	= 18;									// 地球-市政中心-免费-镇

	public static final int		BUILDING_TYPE_GOVERMENT_CENTER_FREE_MARS	= 12;									// 火星-市政中心

	public static final int		BUILDING_TYPE_CLOTHING						= 2;									// 服装建筑物

	public static final int		BUILDING_TYPE_ORNAMENTS						= 3;									// 饰品建筑物

	public static final int		BUILDING_TYPE_FOOD							= 4;									// 美食建筑物

	public static final int		BUILDING_TYPE_DRINK							= 5;									// 饮品建筑物

	public static final int		BUILDING_TYPE_LIVING						= 6;									// 居住建筑物

	public static final int		BUILDING_TYPE_HEALTHY						= 7;									// 医疗健康建筑物

	public static final int		BUILDING_TYPE_BUS_STOP						= 8;									// 公交站建筑物

	public static final int		BUILDING_TYPE_4s							= 9;									// 4s建筑物

	public static final int		BUILDING_TYPE_EMPTY							= 11;									// 空地广场建筑物


	public static final int BUILDING_CATEGORY_1 = 1; // 市政中心
	public static final int BUILDING_CATEGORY_2 = 2; // 服装
	public static final int BUILDING_CATEGORY_3 = 3;// 饰器
	public static final int BUILDING_CATEGORY_4 = 4;// 食物
	public static final int BUILDING_CATEGORY_5 = 5;// 饮品
	public static final int BUILDING_CATEGORY_6 = 6;// 居住
	public static final int BUILDING_CATEGORY_7 = 7;// 医疗
	public static final int BUILDING_CATEGORY_8 = 8;// 公共交通
	public static final int BUILDING_CATEGORY_9 = 9;// 4s专卖
	public static final int BUILDING_CATEGORY_10 = 10;// 广场




	public static final int		BUILDING_LEVEL_1							= 1;									// 建筑物一级

	public static final int		BUILDING_LEVEL_2							= 2;									// 建筑物二级

	public static final int		BUILDING_LEVEL_3							= 3;									// 建筑物三级

	public static final int		PERSON_LEVEL_VILLAGE_1						= 1;									// 村级

	public static final int		PERSON_LEVEL_VILLAGE_2						= 2;									// 村级

	public static final int		PERSON_LEVEL_MAYOR_1						= 3;									// 镇级

	public static final int		PERSON_LEVEL_MAYOR_2						= 4;									// 镇级

	public static final int		PERSON_LEVEL_MAYOR_3						= 5;									// 镇级

	public static final String	IS_WECHAT_LOGIN								= "iswechatlogin";						// 是否是微信登录

	public static final String	TYPE_IS_HIRER								= "type_is_hirer";						// 是否为雇主

	public static final String	WXHEAD_HEAD_ICON							= "wxHeadicon";							// 微信头像

	public static final String	LOGIN_FROM									= "from";

	public static final String USER_GENDER_WOMAN = "F"; // 女性

	public static final String USER_GENDER_MAN = "M"; // 男性

	public static final String USER_INVI_CODE = "invitationCode"; // 邀请码

	public static final String USER_FACE_STATUS = "faceStatus"; // 是否人脸识别

	public static final String USER_CARD_STATUS = "cardStatus"; // 是否身份认证

	public static final String USER_START_TIME = "startTime";//用户进入应用的开始时间

	public static final String USER_END_TIME = "endTime";//用户退出应用时的时间

	public static final String USER_STAY_TIME = "stayTime";//用户在应用中停留的时间


//	public static final String	LOGIN_FROM_LOGIN_PAGE						= "login_page";
//
//	public static final String	LOGIN_FROM_SPLASH_PAGE						= "splash_page";

//	public static final int	LOGIN_FROM_LANUCHER  	= 0;   //应用程序启动
	public static final int	LOGIN_FROM_LOGIN_PAGE	= 1;   //从登录页面过来
	public static final int	LOGIN_FROM_SPLASH_PAGE	= 2;   //从splash页面过来
	public static final int	LOGIN_FROM_REGISTER_PAGE	= 3;   //从登录（注册）页面过来

	public static final String	GD_MAP_KEY	= "605c5af663904385607eeffff5dda8ff";   //高德地图key

	// 注册方式
	public static final int N_REG_TYPE_EMAIL  = 1;   // 使用email注册
	public static final int N_REG_TYPE_PHONE  = 2;   // 使用phone注册

	//inmobi广告sdk
	public static final String INMOBI_ACOUNT_ID  = "1a8e99efd4db48ae8ccb32acbeab7e93";//账户id
	public static final long INMOBI_INTER_ID  = 1534893934657L;//间隙式广告
	public static final long INMOBI_AWARD_VIDEO  = 1533182381388L ;//奖励视频

}
