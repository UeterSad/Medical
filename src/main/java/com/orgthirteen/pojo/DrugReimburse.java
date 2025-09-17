package com.orgthirteen.pojo;

import lombok.Data;

@Data
public class DrugReimburse {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 报销等级类型
     */
    private String drugReimbursementType;

    /**
     * 报销比例
     */
    private Integer drugReimbursementProportion;

    /**
     * 报销等级信息
     */
    private String drugReimbursementInfo;

    /**
     * 状态：1-正常 0-禁用
     */
    private Integer status;
}
