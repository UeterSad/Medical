package com.orgthirteen.Service.Impl;

import com.orgthirteen.Mapper.RegistrPatientMapper;
import com.orgthirteen.Service.RegistrPatientService;
import com.orgthirteen.pojo.RegistrPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrPatientServiceImpl implements RegistrPatientService {
    @Autowired
    private RegistrPatientMapper registrPatientMapper;
    @Override
    public void save(RegistrPatient registrPatient) {
        registrPatientMapper.save(registrPatient);
    }
}
