package com.orgthirteen.Service;

import com.orgthirteen.pojo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MedOrderService {
    List<RegistrPatient> find(String realName);

    PageResult<Drugs> findDrugs(Integer page, Integer pageSize, String chinaName);

    PageResult<DiagnosisTreatment> findDiagnosisTreatment(Integer page, Integer pageSize, String medicalName);

    PageResult<MedServ> findMedService(Integer page, Integer pageSize, String medicalName);

    void addOrder(OrderBase orderBase);
}
