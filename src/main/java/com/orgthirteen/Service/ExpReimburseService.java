package com.orgthirteen.Service;

import com.orgthirteen.pojo.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public interface ExpReimburseService {
    PageResult<RegistrPatient> find(Integer page, Integer pageSize, String realName);

    List<Drugs> findDrugInfo(String drugType,String patientId);

    List<DiagnosisTreatment> findDiagnosisInfo(String patientId);

    List<MedServ> findMedServiceInfo(String patientId);

    List<String> findPat(String patientId);

    List<BigDecimal> getFee(String patientId);

    PairList getDrugData(String patientId);

    PairList<String,BigDecimal> getOtherData(String patientId);
}
