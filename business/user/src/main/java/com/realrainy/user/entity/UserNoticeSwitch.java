package com.realrainy.user.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserNoticeSwitch implements Serializable {

    private static final long serialVersionUID = 6196276286792205567L;

    private Integer isHot = 1;// 是否接收热点推送
    private Integer isNotice = 1;// 是否接收通知消息
    private Integer isMessageAccept = 1;// 是否接收聊天消息通知
    private Integer isMessage = 1;// 显示聊天内容
    private Integer isLookReward = 1;// 路客打赏到账
    private Integer isQuestion = 1;// 关注的问题更新
    private Integer isGift = 1;// 收礼物
    private Integer isVideoAudit = 1;// 视频审核结果通知
    private Integer isAtRemind = 1;// @消息提醒
    private Integer isAtAccept = 1;// 接收@消息
    private Integer isReview = 1;// 评论提醒
    private Integer isAnswer = 1;// 问题回答提醒
    private Integer isRunGame = 1;// 游戏被超越提醒
    private Integer isPMRemind = 1;// 私信消息提醒
    private Integer isReceivePM = 1;// 接收私信消息
    private Integer isTempMatching = 1;//是否开启随聊 0不开启 1开启
    private Integer isExtraLikes = 1;//是否使用vip特权增加额外点赞 0不使用 1使用

}
