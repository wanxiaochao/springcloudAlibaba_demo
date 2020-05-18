package com.realrainy.user.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.io.Serializable;
import java.util.List;

@Data
public class UserOtherDetails implements Serializable {

    private static final long serialVersionUID = 3755738484583121175L;

    private Long birthday;// 生日
    private String birthMonthDay;// 生日年月日 (格式 xxxx-xx-xx)
    private List<String> hobby;// 爱好{音乐、影视、动漫、游戏、小说、聚会、上网、运动、健身、美食、旅游、摄影、交友、唱K、睡觉（最多3种）}
    // 学校{格式[大学,高中,职专,初中,小学]}
    private String university;// 大学
    private String highSchool;// 高中
    private String college;// 职专
    private String middle;// 初中
    private String primary;// 小学
    private String workingInfo;// 工作{a.销售/客服/市场、b.财务/人力资源/行政、c.项目/质量/高级管理/、d.IT/互联网/通信、e.房产/建筑/物业管理、f.金融、g.采购/贸易/交通/物流、h.生产/制造、i.传媒/印刷/艺术/设计、j.咨询/法律/教育/翻译、k.服务业、l.能源/环保/农业/科研、m兼职/实习/社工/自由职业}
    private String emotion;// 情感状态｛(a.要你管 b.单身 c.求勾搭 d.暧昧期 e.恋爱中 f.已婚 g.失恋 h.挖墙脚 i.绿帽ing )｝
    private String emotionPublic;// 情感状态是否公开｛a.完全公开 b.好友可见 c.完全保密｝
    private String personality;// 性格{a.完美型、b.全爱型、c.成就型、d.艺术型、e.智慧型、f.忠诚型、g.活跃型、h.领袖型、i.和平型}
    private String homeland;// 故乡
    private String cardNumber;// 身份证号
    private String currentAdCode;// 行政区划编码(定位)
    private GeoJsonPoint currentLocation;// 当前位置定位(格式：经度,纬度，如：0,0)
    private Long currentTime;// 定位时间

}
