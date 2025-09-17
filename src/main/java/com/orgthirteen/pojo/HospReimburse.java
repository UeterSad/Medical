package com.orgthirteen.pojo;

import lombok.Data;

/**
 * 医院报销等级信息实体类
 *
 * @author 你的名字
 */
@Data
public class HospReimburse {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 报销起付金额
     */
    private String minPayLevel;
    /**
     * 报销等级线
     */
    private String maxPayLevel;
    /**
     * 人员类别(1 在职人员，0 退休人员)
     */
    private String peopleType;
    /**
     * 报销比例
     */
    private String payProportion;
    /**
     * 医院等级
     */
    private String hospitalLevel;
    /**
     * 状态：1-正常 0-禁用
     */
    private String status;
}

