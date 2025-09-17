package com.orgthirteen.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 诊疗项目表实体类
 * 对应表：diagnosis_treatment
 */
@Data
public class DiagnosisTreatment{

    /**
     * 主键
     */
    private Integer id;

    /**
     * 项目类别
     */
    private String medicalType;

    /**
     * 项目编码
     */
    private String medicalNumber;

    /**
     * 项目国家编码
     */
    private String countryNumber;

    /**
     * 项目名称
     */
    private String medicalName;

    /**
     * 项目说明
     */
    private String medicalInfo;

    /**
     * 除外内容
     */
    private String medicalExclude;

    /**
     * 计价单位
     */
    private String medicalUnit;

    /**
     * 价格
     */
    private BigDecimal medicalPrice;

    /**
     * 备注
     */
    private String remark;
}
