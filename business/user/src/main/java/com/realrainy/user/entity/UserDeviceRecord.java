package com.realrainy.user.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDeviceRecord implements Serializable {

    private static final long serialVersionUID = 7254531543267217460L;

    private String client;// 通过哪一端注册的
    private String loginClient;//最近一次登录的客户端
    private String deviceType;// 注册设备类型(iphone,oppo,mi,windows,mac等)
    private String deviceModel;// 注册设备型号(ios12,安卓系统，浏览器等)
    private String loginDeviceType;// 登录设备类型(iphone,oppo,mi,windows,mac等)
    private String loginDeviceModel;// 登录设备型号(ios12,安卓系统，浏览器等)

}
