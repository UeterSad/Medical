package com.orgthirteen.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class OrderBase {
    // 主键
    private Integer id;
    // 医嘱相关描述内容（不同表场景下含义适配，如诊疗项目信息、药品医嘱内容等）
    private String doctorOrder;
    // 用法说明
    private String useMethod;
    // 医嘱状态：1-正常执行 0-作废 2-停止
    private Integer status;
    // 患者唯一标识
    private Integer patientId;
    // 药品唯一标识
    private Integer drugId;
    // 诊疗项目唯一标识
    private Integer diagnosisId;
    // 医疗服务唯一标识
    private Integer medicalId;
    // 开始时间
    private Date startTime;
    // 结束时间
    private Date endTime;
    // 医嘱频次
    private Integer orderNumber;
    // 开立时间
    private Date orderTime;

}
