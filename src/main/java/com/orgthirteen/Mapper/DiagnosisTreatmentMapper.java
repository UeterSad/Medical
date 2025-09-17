package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.DiagnosisTreatment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DiagnosisTreatmentMapper {
    List<DiagnosisTreatment> list(String medicalName);
    @Select("select * from diagnosis_treatment where id = #{id}")
    DiagnosisTreatment getById(Integer id);
    @Insert("insert into diagnosis_treatment(medical_name,medical_type,medical_number, country_number, medical_info, medical_exclude, medical_unit, medical_price, remark) values (#{medicalName},#{medicalType} ,#{medicalNumber}, #{countryNumber}, #{medicalInfo}, #{medicalExclude}, #{medicalUnit}, #{medicalPrice}, #{remark})")
    void save(DiagnosisTreatment diagnosisTreatment);

    void update(DiagnosisTreatment diagnosisTreatment);

    void delete(List<Integer> id);
}
