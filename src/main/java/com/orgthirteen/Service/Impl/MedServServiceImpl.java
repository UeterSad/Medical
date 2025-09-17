package com.orgthirteen.Service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.orgthirteen.Mapper.MedServMapper;
import com.orgthirteen.Service.MedServService;
import com.orgthirteen.pojo.MedServ;
import com.orgthirteen.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedServServiceImpl implements MedServService {
    @Autowired
    private MedServMapper medServMapper;
    @Override
    public PageResult<MedServ> page(Integer page, Integer pageSize, String medicalName) {
        PageHelper.startPage(page,pageSize);
        List<MedServ> medServList = medServMapper.list(medicalName);
        Page<MedServ> p=(Page<MedServ>) medServList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public MedServ getById(Integer id) {
        MedServ medServ= medServMapper.getById(id);
        return medServ;
    }

    @Override
    public void save(MedServ medServ) {
        medServMapper.save(medServ);
    }

    @Override
    public void update(MedServ medServ) {
        medServMapper.update(medServ);
    }

    @Override
    public void delete(List<Integer> id) {
        medServMapper.delete(id);
    }
}
