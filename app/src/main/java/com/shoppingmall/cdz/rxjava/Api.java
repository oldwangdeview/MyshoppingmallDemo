package com.shoppingmall.cdz.rxjava;




/**
 * Author wangshifu
 * Dest  访问网络的方法
 *
 */
public interface Api {
    boolean isRelease=false;
    /**发布地址*/
    String baseUrl="http://120.79.136.125/";
    /**测试地址*/
     String testBaseUrl="http://47.107.94.148/";

//
//     @POST("/user/thridLogin")
//     Observable<StatusCode<LoginBean>> thridLogin(
//             @Query("weixinOpenid") String weixinOpenid,
//             @Query("qqOpenid") String qqOpenid,
//             @Query("languageType") String languageType);




}


