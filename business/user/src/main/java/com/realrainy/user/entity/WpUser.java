package com.realrainy.user.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * <p>
 * Description:用户信息实体类
 * </p>
 *
 * @author mazhiqiang 2019年3月4日
 */
@Data
public class WpUser implements Serializable {

    private static final long serialVersionUID = 2707716990635288429L;
    @Id
    private String id;
    private String name;// 内么：系统用户名，只可以更改一次（字段不为空则不允许更改），如果注册未填写，默认使用手机号（前端控制）,实名认证之后自动添加为真实姓名；
    private String nickName;// 昵称：可以随便更改
    private String countryCode;// 国家区号
    private String telphone;// 手机号，用户唯一标示（用户名），当name为空时候，前端将name显示为手机号
    private String password;// 用户密码，采用加密存储。。。
    private String head;// 头像： 存储《七牛云》 url
    private String signature;// 签名
    private Integer status = 2;// 注册状态： {1：注册过，2：没有注册过，3：审核通过未完成注册，4：审核未通过，5：审核中，6：随机注册失败} ，default：2
    private String mainRoadId;// 主路ID
    private String subRoadId;// 辅路ID
    private String jpushId; // 极光id
    private String devicetoken;// 设备token
    private Integer role = 0;// 用户类型{0：普通用户，1：认证用户，2：高级用户，4：管理员，5：超级管理员 6:签约用户 7:客服 9:系统管理员}，default：0
    private String gender = "男";// 性别：{男，女} default：男
    private String genderPublic = "完全公开";// 性别是否公开，{完全公开，路友可见，完全保密}，default：完全公开
    private String sexof;// 性取向{"男" "女" "男&女" "禁欲系"}
    private String sexofPublic = "完全公开";// 性取向是否公开{完全公开 好友可见 完全保密 },default 完全公开
    private String invitationUid;// 邀请者ID(使用特殊邀请码时没有此字段)
    private String backGround;// 个人背景图
    private String adCode;// 行政区划编码
    private Integer realAuth = 0;// 是否实名认证{0未认证 1正在审核 2实名认证成功 3实名认证失败}
    private Double complete = 0.18;// 个人信息完成度 (0-1)
    private Integer completeDrawLottery;// 个人完成度是否增加过抽奖次数签到
    private String email;// 邮箱
    private Integer invalidStatus = 0;//注销状态 0未注销 1已注销
    private Integer searchStatus = -1;
    private Integer isSearchByBook = 0;
    private Long createTime;
    private Long updateTime;
    private UserOtherDetails userOtherDetails;
    private UserNumTotal userNumTotal;
    private UserDeviceRecord userDeviceRecord;
    private UserNoticeSwitch userNoticeSwitch;
}
