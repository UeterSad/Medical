package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.Disease;
import com.orgthirteen.pojo.InpatientDisease;
import com.orgthirteen.pojo.RegistrPatient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DiseaseDiagMapper {

    List<Disease> findDiseases(String diseaseName);
    @Insert("insert into inpatient_disease(patient_id, disease_id, order_time, disease_type) values (#{patientId}, #{diseaseId}, #{orderTime}, #{diseaseType})")
    void addInpatientDisease(InpatientDisease inpatientDisease);
}
