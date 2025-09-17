package com.orgthirteen.Service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.orgthirteen.Mapper.ExpReimburseMapper;
import com.orgthirteen.Mapper.RegistrPatientMapper;
import com.orgthirteen.Service.ExpReimburseService;
import com.orgthirteen.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ExpReimburseServiceImpl implements ExpReimburseService {
    @Autowired
    private ExpReimburseMapper expReimburseMapper;
    @Override
    public PageResult<RegistrPatient> find(Integer page, Integer pageSize, String realName) {
        PageHelper.startPage(page, pageSize);
        List<RegistrPatient> list = expReimburseMapper.find(realName);
        PageInfo<RegistrPatient> pageInfo = new PageInfo<>(list);
        return new PageResult<>(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public List<Drugs> findDrugInfo(String drugType,String patientId) {
        return expReimburseMapper.findDrugInfo(drugType,patientId);
    }

    @Override
    public List<DiagnosisTreatment> findDiagnosisInfo(String patientId) {
        return expReimburseMapper.findDiagnosisInfo(patientId);
    }

    @Override
    public List<MedServ> findMedServiceInfo(String patientId) {
        return expReimburseMapper.findMedServiceInfo(patientId);
    }

    @Override
    public List<String> findPat(String patientId) {
        RegistrPatient registrPatient= expReimburseMapper.findPat(patientId);
        List<String> strList = new ArrayList<>();
        strList.add(registrPatient.getRealName());
        strList.add(registrPatient.getRegistMethod());
        strList.add(registrPatient.getPeopleType());
        return strList;
    }

    @Override
    public List<BigDecimal> getFee(String patientId) {
        List<BigDecimal> list = expReimburseMapper.getFee(patientId);
        // 处理列表本身为null的情况
        if (list == null) {
            list = new ArrayList<>();
        }
        // 计算总和时过滤掉null元素
        BigDecimal totalFee = list.stream()
                .filter(Objects::nonNull) // 只保留非null元素
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        list.add(totalFee);
        return list;
    }


    public PairList getDrugData(String patientId) {
        List<Map<String,Object>> list = expReimburseMapper.getDrugData(patientId);
        List<Object> typeList = list.stream().map(dataMap -> dataMap.get("drugType")).toList();
        List<Object> feeList = list.stream().map(dataMap -> dataMap.get("price")).toList();
        return new PairList(typeList,feeList);
    }

    @Override
    public PairList<String, BigDecimal> getOtherData(String patientId) {
        List<BigDecimal> list = expReimburseMapper.getDividedFee(patientId);
        List<String> nameList = Arrays.asList("保险药品","诊疗项目","医疗服务");
        PairList<String,BigDecimal> pairList = new PairList<>(nameList,list);
        return pairList;
    }
}
