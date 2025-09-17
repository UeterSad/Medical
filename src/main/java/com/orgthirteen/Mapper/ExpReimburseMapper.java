package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.DiagnosisTreatment;
import com.orgthirteen.pojo.Drugs;
import com.orgthirteen.pojo.MedServ;
import com.orgthirteen.pojo.RegistrPatient;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Mapper
public interface ExpReimburseMapper {
    List<RegistrPatient> find(String realName);
    @Select("select * from drug_info where insurance_type=#{insuranceType} and id in (select drug_id from inpatient_drugs where patient_id = #{patientId})")
    List<Drugs> findDrugInfo(String insuranceType,String patientId);
    @Select("select * from diagnosis_treatment where id in (select diagnosis_id from inpatient_diagnosis where patient_id = #{patientId})")
    List<DiagnosisTreatment> findDiagnosisInfo(String patientId);
    @Select("select * from medical_service where id in (select medical_id from inpatient_medical where patient_id = #{patientId})")
    List<MedServ> findMedServiceInfo(String patientId);
    @Select("select real_name,regist_method,people_type from patient_registration where id = #{patientId}")
    RegistrPatient findPat(String patientId);

    List<BigDecimal> getFee(String patientId);
    @MapKey("drugType")
    List<Map<String,Object>> getDrugData(String patientId);

    List<BigDecimal> getDividedFee(String patientId);
}
