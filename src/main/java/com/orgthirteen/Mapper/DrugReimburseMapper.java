package com.orgthirteen.Mapper;

import com.orgthirteen.pojo.DrugReimburse;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DrugReimburseMapper {
    @Select("select * from drug_reimbursement")
    List<DrugReimburse> findAll();
    @Insert("insert into drug_reimbursement(drug_reimbursement_type,drug_reimbursement_proportion,drug_reimbursement_info,status) values (#{drugReimbursementType},#{drugReimbursementProportion},#{drugReimbursementInfo},#{status})")
    void save(DrugReimburse drugReimburse);
//    @Update("update drug_reimbursement set drug_reimbursement_type=#{drugReimbursementType},drug_reimbursement_proportion=#{drugReimbursementProportion},drug_reimbursement_info=#{drugReimbursementInfo},status=#{status} where id=#{id}")
    void update(DrugReimburse drugReimburse);
    @Delete("delete from drug_reimbursement where id=#{id}")
    void delete(Integer id);
}
