package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.MedServ;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MedServMapper {
    List<MedServ> list(String medicalName);
    @Select("select * from medical_service where id = #{id}")
    MedServ getById(Integer id);
    //medical_type, medical_number, country_number, medical_name, medical_info, medical_exclude, medical_unit, medical_price, remark
    @Insert("insert into medical_service(medical_type, medical_number, country_number, medical_name, medical_info, medical_exclude, medical_unit, medical_price, remark) values (#{medicalType}, #{medicalNumber}, #{countryNumber}, #{medicalName}, #{medicalInfo}, #{medicalExclude} , #{medicalUnit}, #{medicalPrice}, #{remark})")
    void save(MedServ medServ);

    void update(MedServ medServ);

    void delete(List<Integer> id);
}
