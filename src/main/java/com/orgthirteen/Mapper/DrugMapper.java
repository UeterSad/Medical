package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.Drugs;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface DrugMapper {
    public List<Drugs> list(String drugName);
    @Select("select * from drug_info where id=#{id}")
    Drugs findById(Integer id);
    void update(Drugs drugs);
    @Insert("insert into drug_info(china_name,drug_price,insurance_type,goods_name,specifications,drug_unit,drug_manufacturer,remarks) values (#{chinaName},#{drugPrice},#{insuranceType},#{goodsName},#{specifications},#{drugUnit},#{drugManufacturer},#{remarks})")
    void save(Drugs drugs);

    void delete(List<Integer> id);
}
