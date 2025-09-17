package com.orgthirteen.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class InpatientDrug {
    private Integer id;
    private Date startTime;
    private Date endTime;
    private String doctorOrder;
    private Integer orderNumber;
    private String useMethod;
    private Integer drugId;
    private Integer status;
    private Integer patientId; // 新增的 patientId 字段
}
