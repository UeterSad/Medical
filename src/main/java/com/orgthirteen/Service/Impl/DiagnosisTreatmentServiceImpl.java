package com.orgthirteen.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orgthirteen.Mapper.DiagnosisTreatmentMapper;
import com.orgthirteen.Service.DiagnosisTreatmentService;
import com.orgthirteen.pojo.DiagnosisTreatment;
import com.orgthirteen.pojo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisTreatmentServiceImpl implements DiagnosisTreatmentService {
    @Autowired
    private DiagnosisTreatmentMapper diagnosisTreatmentMapper;
    @Override
    public PageResult<DiagnosisTreatment> page(Integer page, Integer pageSize, String medicalName) {
        PageHelper.startPage(page, pageSize);
        List<DiagnosisTreatment> list = diagnosisTreatmentMapper.list(medicalName);
        PageInfo<DiagnosisTreatment> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public DiagnosisTreatment getById(Integer id) {
        return diagnosisTreatmentMapper.getById(id);
    }

    @Override
    public void save(DiagnosisTreatment diagnosisTreatment) {
        diagnosisTreatmentMapper.save(diagnosisTreatment);
    }

    @Override
    public void update(DiagnosisTreatment diagnosisTreatment) {
        diagnosisTreatmentMapper.update(diagnosisTreatment);
    }

    @Override
    public void delete(List<Integer> ids) {
        diagnosisTreatmentMapper.delete(ids);
    }
}
