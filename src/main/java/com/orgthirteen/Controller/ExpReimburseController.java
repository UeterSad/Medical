package com.orgthirteen.Controller;

import com.orgthirteen.Service.ExpReimburseService;
import com.orgthirteen.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expReimburse")
public class ExpReimburseController {
    @Autowired
    private ExpReimburseService expReimburseService;

    @GetMapping("/manageInfo")
    public Result find(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer pageSize, String realName) {
        PageResult<RegistrPatient> pageResult = expReimburseService.find(page,pageSize,realName);
        return Result.success(pageResult);
    }
    @GetMapping("/findExp")
    public Result findPatInfo(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer pageSize, String realName) {
        PageResult<RegistrPatient> pageResult = expReimburseService.find(page,pageSize,realName);
        return Result.success(pageResult);
    }
    @GetMapping("/findExp/drug/{drugType}")
    public Result findDrugInfo(@PathVariable String drugType,String patientId){
        switch (drugType){
            case "1":
                drugType="甲类";
                break;
            case "2":
                drugType="乙类";
                break;
            case "3":
                drugType="丙类";
                break;
                default:
                    return Result.error("参数错误");
        }
        List<Drugs> list = expReimburseService.findDrugInfo(drugType,patientId);
        return Result.success(list);
    }
    @GetMapping("/findExp/diagnosis/{patientId}")
    public Result findDiagnosisInfo(@PathVariable String patientId){
        List<DiagnosisTreatment> list = expReimburseService.findDiagnosisInfo(patientId);
        return Result.success(list);
    }
    @GetMapping("/findExp/service/{patientId}")
    public Result findMedServiceInfo(@PathVariable String patientId){
        List<MedServ> list = expReimburseService.findMedServiceInfo(patientId);
        return Result.success(list);
    }
    @GetMapping("/fee")
    public Result findFeePat(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer pageSize, String realName) {
        PageResult<RegistrPatient> pageResult = expReimburseService.find(page,pageSize,realName);
        return Result.success(pageResult);
    }
    @GetMapping("/fee/rebursement/{drugType}")
    public Result findFeeDrug(@PathVariable String drugType,String patientId){
        switch (drugType){
            case "1":
                drugType="甲类";
                break;
            case "2":
                drugType="乙类";
                 break;
           case "3":
                drugType="丙类";
                break;
                default:
                    return Result.error("参数错误");
        }
        List<Drugs> list = expReimburseService.findDrugInfo(drugType,patientId);
        return Result.success(list);
    }
    @GetMapping("/fee/rebursement/other")
    public Result findFeeOther(String patientId){
        List<MedServ> servList = expReimburseService.findMedServiceInfo(patientId);
        List<DiagnosisTreatment> treatmentList = expReimburseService.findDiagnosisInfo(patientId);
        PairList<MedServ,DiagnosisTreatment> list = new PairList(servList,treatmentList);
        return Result.success(list);
    }
    @GetMapping("/fee/rebursement")
    public Result findById(String patientId){
        List<String> strList = expReimburseService.findPat(patientId);
//        List<String> strList = new ArrayList<>();
//        strList.add(registrPatient.getRealName());
//        strList.add(registrPatient.getRegistMethod());
//        strList.add(registrPatient.getPeopleType());
        List<BigDecimal> list = expReimburseService.getFee(patientId);
        PairList<String,BigDecimal> pairList = new PairList(strList,list);
        return Result.success(pairList);
    }
    @GetMapping("/fee/detail/{pie}")
    public Result findDetail(@PathVariable String pie,String patientId){
        switch (pie){
            case "1":
                PairList list = expReimburseService.getDrugData(patientId);
                return Result.success(list);
                case "2":
                    PairList<String,BigDecimal> pairList = expReimburseService.getOtherData(patientId);
                    return Result.success(pairList);
            default:
                return Result.error("参数错误");
        }
    }
}
