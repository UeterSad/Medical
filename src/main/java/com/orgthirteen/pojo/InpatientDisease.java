package com.orgthirteen.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

/**
 * 患者诊断疾病表实体类
 * 对应表 inpatient_disease
 */
@Data
public class InpatientDisease {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 住院患者表外键
     */
    private Integer patientId;

    /**
     * 疾病表外键
     */
    private Integer diseaseId;

    /**
     * 疾病诊断时间
     */
    private Date orderTime;

    /**
     * 诊断类型（1、入院诊断，2、主要诊断，3、其他诊断）
     */
    private Byte diseaseType;
}

