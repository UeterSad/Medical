package com.orgthirteen.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orgthirteen.Mapper.*;
import com.orgthirteen.Service.MedOrderService;
import com.orgthirteen.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedOrderServiceImpl implements MedOrderService {
    @Autowired
    private RegistrPatientMapper registrPatientMapper;
    @Autowired
    private DrugMapper drugMapper;
    @Autowired
    private DiagnosisTreatmentMapper diagnosisTreatmentMapper;
    @Autowired
    private MedServMapper medServMapper;
    @Autowired
    private MedOrderMapper medOrderMapper;
    @Override
    public List<RegistrPatient> find(String realName) {
        return registrPatientMapper.findPatients(realName);
    }

    @Override
    public PageResult<Drugs> findDrugs(Integer page, Integer pageSize, String chinaName) {
        PageHelper.startPage(page,pageSize);
        List<Drugs> list = drugMapper.list(chinaName);
        PageInfo<Drugs> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public PageResult<DiagnosisTreatment> findDiagnosisTreatment(Integer page, Integer pageSize, String medicalName) {
        PageHelper.startPage(page,pageSize);
        List<DiagnosisTreatment> list = diagnosisTreatmentMapper.list(medicalName);
        PageInfo<DiagnosisTreatment> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public PageResult<MedServ> findMedService(Integer page,Integer pageSize,String medicalName) {
        PageHelper.startPage(page,pageSize);
        List<MedServ> list = medServMapper.list(medicalName);
        PageInfo<MedServ> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public void addOrder(OrderBase orderBase) {
        medOrderMapper.add(orderBase);
    }
}
