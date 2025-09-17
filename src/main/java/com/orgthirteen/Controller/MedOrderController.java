package com.orgthirteen.Controller;

import com.orgthirteen.Service.DiagnosisTreatmentService;
import com.orgthirteen.Service.DrugService;
import com.orgthirteen.Service.MedOrderService;
import com.orgthirteen.Service.MedServService;
import com.orgthirteen.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/medOrder")
public class MedOrderController {
    @Autowired
    private MedOrderService medOrderService;

    @GetMapping("/select")
    public Result findPatients(String realName) {
        List<RegistrPatient> registrPatientList = medOrderService.find(realName);
        return Result.success(registrPatientList);
    }

    @GetMapping("/drug")
    public Result findDrugs(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize, String chinaName) {
        PageResult<Drugs> drugsList = medOrderService.findDrugs(page, pageSize, chinaName);
        return Result.success(drugsList);
    }

    @GetMapping("/treatment")
    public Result findDiagnosisTreatment(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize, String medicalName) {
        PageResult<DiagnosisTreatment> diagnosisTreatmentList = medOrderService.findDiagnosisTreatment(page, pageSize, medicalName);
        return Result.success(diagnosisTreatmentList);
    }
    @GetMapping("/service")
    public Result findMedService(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer pageSize,String medicalName) {
        PageResult<MedServ> medServiceList = medOrderService.findMedService(page,pageSize,medicalName);
        return Result.success(medServiceList);
    }
    @PostMapping("drug")
    public Result addDrugOrder(@RequestBody OrderBase orderBase){
        if (orderBase.getPatientId()==null){
            return Result.error("病人id不能为空");
        }
        medOrderService.addOrder(orderBase);
        return Result.success();
    }
    @PostMapping("treatment")
    public Result addTreatmentOrder(@RequestBody OrderBase orderBase){
        if (orderBase.getPatientId()==null){
            return Result.error("病人id不能为空");
        }
        medOrderService.addOrder(orderBase);
        return Result.success();
    }
    @PostMapping("service")
    public Result addMedServiceOrder(@RequestBody OrderBase orderBase){
        if (orderBase.getPatientId()==null){
            return Result.error("病人id不能为空");
        }
        medOrderService.addOrder(orderBase);
        return Result.success();
    }
}
