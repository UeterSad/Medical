package com.orgthirteen.pojo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.orgthirteen.config.CustomDateDeserializer;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RegistrPatient {
    // 主键
    private Integer id;
    // 住院号
    private String caseNumber;
    // 患者姓名
    private String realName;
    // 性别
    private String gender;
    // 身份证号
    private String cardNumber;
    // 出生日期
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date birthday;
    // 年龄
    private Integer age;
    // 年龄类型（岁、月、日）
    private String ageType;
    // 家庭住址
    private String homeAddress;
    // 入院日期、时间
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date visitDate;
    // 结算类别（1自费、0医保）
    private String registMethod;
    // 人员类别（0退休、1在职）
    private String peopleType;
}
