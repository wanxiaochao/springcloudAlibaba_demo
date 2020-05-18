package com.realrainy.user.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserNumTotal implements Serializable {

    private static final long serialVersionUID = -4931353099350372913L;

    private Integer friends = 0;// 好友数
    private Integer follows = 0;// 跟随数
    private Integer followeds = 0;// 被跟随数数
    private Integer looks = 0;// 路客数
    private Integer friendCount;// 增加好友数

}
