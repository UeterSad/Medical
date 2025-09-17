package com.orgthirteen.Service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orgthirteen.Mapper.DrugMapper;
import com.orgthirteen.Service.DrugService;
import com.orgthirteen.pojo.Drugs;
import com.orgthirteen.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugServiceImpl implements DrugService {
    @Autowired
    private DrugMapper drugMapper;

    @Override
    public PageResult<Drugs> page(Integer page, Integer pageSize, String drugName) {
        PageHelper.startPage(page, pageSize);
        List<Drugs> drugsList = drugMapper.list(drugName);
        Page<Drugs> p=(Page<Drugs>) drugsList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public Drugs findById(Integer id) {
        Drugs drugs = drugMapper.findById(id);
        return drugs;
    }

    @Override
    public void update(Drugs drugs) {
        // 更新操作
        drugMapper.update(drugs);
    }

    @Override
    public void save(Drugs drugs) {
        // 保存操作
        drugMapper.save(drugs);
    }

    @Override
    public void delete(List<Integer> id) {
        // 删除操作
        drugMapper.delete(id);
    }
}
