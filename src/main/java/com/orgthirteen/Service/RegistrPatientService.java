package com.orgthirteen.Service;

import com.orgthirteen.pojo.RegistrPatient;
import org.springframework.stereotype.Service;

@Service
public interface RegistrPatientService {
    void save(RegistrPatient registrPatient);
}
