package com.htpp.config;

public class Config {
    //支付宝为应用分配的ID号
    public static final String APPID = "";

    //支付宝请求公共链接
    public static final String ALI_PUBLIC_PATH = "https://openapi.alipay.com/gateway.do";

    //用户设置的私钥
    public static final String ALI_PRIVATE_KEY = "";

    //支付宝设置的公钥
    public static final String ALI_PUBLIC_KEY = "";

    //用户确认支付后，支付宝get请求returnUrl（商户入参传入），返回同步返回参数。
    public static final String ALI_RETURN_URL = "";

    //交易成功后，支付宝post请求notifyUrl（商户入参传入），返回异步通知参数。
    public static final String ALI_NOTIFY_URL = "";
}
