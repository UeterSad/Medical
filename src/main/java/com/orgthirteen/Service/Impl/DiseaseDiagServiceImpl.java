package com.orgthirteen.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orgthirteen.Mapper.DiseaseDiagMapper;
import com.orgthirteen.Mapper.RegistrPatientMapper;
import com.orgthirteen.Service.DiseaseDiagService;
import com.orgthirteen.pojo.Disease;
import com.orgthirteen.pojo.InpatientDisease;
import com.orgthirteen.pojo.PageResult;
import com.orgthirteen.pojo.RegistrPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseDiagServiceImpl implements DiseaseDiagService {
    @Autowired
    private DiseaseDiagMapper diseaseDiagMapper;
    @Autowired
    private RegistrPatientMapper registrPatientMapper;
    @Override
    public PageResult<RegistrPatient> find(Integer page, Integer pageSize, String realName) {
        PageHelper.startPage(page, pageSize);
        List<RegistrPatient> list = registrPatientMapper.findPatients(realName);
        PageInfo<RegistrPatient> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<Disease> findDisease(String diseaseName) {
        List<Disease> list = diseaseDiagMapper.findDiseases(diseaseName);
        return list;
    }

    @Override
    public void addInpatientDisease(InpatientDisease inpatientDisease) {
        diseaseDiagMapper.addInpatientDisease(inpatientDisease);
    }

}
