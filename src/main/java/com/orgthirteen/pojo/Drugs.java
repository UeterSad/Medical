package com.orgthirteen.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Drugs  {

    // 主键
    private Integer id;
    // 分类
    private String insuranceType;
    // 药品中文名称
    private String chinaName;
    // 商品名
    private String goodsName;
    // 规格
    private String specifications;
    // 单位
    private String drugUnit;
    // 生产企业
    private String drugManufacturer;
    // 价格
    private BigDecimal drugPrice;
    // 备注
    private String remarks;
}
