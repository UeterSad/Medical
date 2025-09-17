package com.orgthirteen.Service.Impl;

import com.orgthirteen.Mapper.DrugReimburseMapper;
import com.orgthirteen.Service.DrugReimburseService;
import com.orgthirteen.pojo.DrugReimburse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugReimburseServiceImpl implements DrugReimburseService {
    @Autowired
    private DrugReimburseMapper drugReimburseMapper;

    @Override
    public List<DrugReimburse> findAll() {
        return drugReimburseMapper.findAll();
    }

    @Override
    public void save(DrugReimburse drugReimburse) {
        drugReimburseMapper.save(drugReimburse);
    }

    @Override
    public void update(DrugReimburse drugReimburse) {
        drugReimburseMapper.update(drugReimburse);
    }

    @Override
    public void delete(Integer id) {
        drugReimburseMapper.delete(id);
    }
}
