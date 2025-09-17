package com.orgthirteen.Controller;

import com.orgthirteen.Service.RegistrPatientService;
import com.orgthirteen.pojo.RegistrPatient;
import com.orgthirteen.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/patientRegister")
public class RegistrPatientController {
    @Autowired
    private RegistrPatientService registrPatientService;
    @PostMapping()
    public Result addPatient(@RequestBody RegistrPatient registrPatient) {
        registrPatientService.save(registrPatient);
        return Result.success();
    }
}
