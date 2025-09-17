package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.RegistrPatient;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegistrPatientMapper {
    public List<RegistrPatient> findPatients(String realName);
    @Insert("insert into patient_registration(case_number, real_name, gender, card_number, birthday, age, age_type, home_address, visit_date, regist_method,people_type) VALUES (#{caseNumber}, #{realName}, #{gender}, #{cardNumber}, #{birthday}, #{age}, #{ageType}, #{homeAddress}, #{visitDate}, #{registMethod}, #{peopleType})")
    void save(RegistrPatient registrPatient);
}
