package com.example.mycloudmusic.util;

import android.os.Build;

import com.example.mycloudmusic.BuildConfig;

/**
 * 常量类
 */
public class Constant {
    /**
     * 端点
     */
    public static final String ENDPOINT = BuildConfig.ENDPOINT;
    /**
     * 资源端点
     */
    public static final String RESOURCE_ENDPOINT = BuildConfig.RESOURCE_ENDPOINT;


    /**
     * ID常量
     * 用作键值
     */
    public static final String ID = "ID";

    /**
     * 手机号正则表达式
     * 移动：134 135 136 137 138 139 147 150 151 152 157 158 159 178 182 183 184 187 188 198
     * 联通：130 131 132 145 155 156 166 171 175 176 185 186
     * 电信：133 149 153 173 177 180 181 189 199
     * 虚拟运营商: 170
     */
    public static final String REGEX_PHONE = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";

    /**
     * 邮箱正则表达式
     */
    public static final String REGEX_EMAIL = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";

    /**
     * 用户详情昵称查询字段
     */
    public static final String NICKNAME = "nickname";
    /**
     * 传递data key
     */
    public static final String DATA = "DATA";
    /**
     * 添加标题 key
     */
    public static final String TITLE = "TITLE";
    /**
     * 添加URL key
     */
    public static final String URL = "URL";
    /**
     * 广告点击了
     */
    public static final String ACTION_AD = "com.example.mycloudmusic.ACTION_AD";
}
