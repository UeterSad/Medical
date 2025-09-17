package com.orgthirteen.pojo;

import lombok.Data;

/**
 * 疾病信息表实体类，对应表 disease
 * 使用 Lombok 的 @Data 注解简化代码，自动生成 getter、setter、toString 等方法
 */
@Data
public class Disease {
    // 主键
    private Integer id;
    // 疾病编码
    private String diseaseCode;
    // 疾病名称
    private String diseaseName;
    // 国际疾病 ICD 编码
    private String diseaseICD;
    // 疾病类型
    private String diseaseCategory;
}
