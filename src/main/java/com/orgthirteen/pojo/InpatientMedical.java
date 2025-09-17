package com.orgthirteen.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class InpatientMedical {
    private Integer id;
    private Date orderTime;
    private String doctorOrder;
    private String useMethod;
    private Integer medicalId;
    private Integer status;
    private Integer patientId; // 新增的 patientId 字段
}
