package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.HospReimburse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface HospReimburseMapper {
    @Select("select * from hospital_reimbursement where hospital_level=#{hospitalLevel} ")
    List<HospReimburse> findByLevel(String hospitalLevel);
    @Delete("delete from hospital_reimbursement where id=#{id}")
    void delete(Integer id);
//    @Update("update hospital_reimbursement set min_pay_level=#{minPayLevel},max_pay_level=#{maxPayLevel},people_type=#{peopleType},pay_proportion=#{payProportion},status=#{status} where id=#{id}")
    void update(HospReimburse hospReimburse);
    @Insert("insert into hospital_reimbursement(min_pay_level,max_pay_level,people_type,pay_proportion,status,hospital_level) values (#{minPayLevel},#{maxPayLevel},#{peopleType},#{payProportion},#{status},#{hospitalLevel})")
    void save(HospReimburse hospReimburse);
}
