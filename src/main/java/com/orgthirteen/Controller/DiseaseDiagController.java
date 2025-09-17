package com.orgthirteen.Controller;

import com.orgthirteen.Service.DiseaseDiagService;
import com.orgthirteen.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/hospital/diseaseDiag")
public class DiseaseDiagController {
    @Autowired
    private DiseaseDiagService diseaseDiagService;
    @GetMapping("/select")
    public Result find(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer pageSize, String realName) {
        PageResult<RegistrPatient> pageResult = diseaseDiagService.find(page,pageSize,realName);
        return Result.success(pageResult);
    }
    @GetMapping("/admission")
    public Result admission(String diseaseName) {
        List<Disease> pageResult = diseaseDiagService.findDisease(diseaseName);
        return Result.success(pageResult);
    }
    @GetMapping("/main")
    public Result mainDiag(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer pageSize, String diseaseName) {
        List<Disease> pageResult = diseaseDiagService.findDisease(diseaseName);
        return Result.success(pageResult);
    }
    @GetMapping("/other")
    public Result otherDiag(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "5") Integer pageSize, String diseaseName) {
        List<Disease> pageResult = diseaseDiagService.findDisease(diseaseName);
        return Result.success(pageResult);
    }
    @PostMapping("/{diagType}")
    public Result addDiag(@PathVariable String diagType, @RequestBody InpatientDisease inpatientDisease){
        switch (diagType){
            case "admission":
                inpatientDisease.setDiseaseType((byte) 1);
                break;
            case "main":
                inpatientDisease.setDiseaseType((byte) 2);
                break;
            case "other":
                inpatientDisease.setDiseaseType((byte) 3);
                break;
                default:
                return Result.error("路径错误");
        }
        if(inpatientDisease.getPatientId() == null || inpatientDisease.getDiseaseId() == null){
            return Result.error("参数错误");
        }
        if (inpatientDisease.getOrderTime() == null){
            inpatientDisease.setOrderTime(new Date());
        }
        diseaseDiagService.addInpatientDisease(inpatientDisease);
        return Result.success();
    }

}
