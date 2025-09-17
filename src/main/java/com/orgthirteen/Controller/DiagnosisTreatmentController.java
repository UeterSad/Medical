package com.orgthirteen.Controller;

import com.orgthirteen.Service.DiagnosisTreatmentService;
import com.orgthirteen.pojo.DiagnosisTreatment;
import com.orgthirteen.pojo.PageResult;
import com.orgthirteen.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/treatment")
public class DiagnosisTreatmentController {
    @Autowired
    private DiagnosisTreatmentService diagnosisTreatmentService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize, String medicalName){
        PageResult<DiagnosisTreatment> pageResult = diagnosisTreatmentService.page(page,pageSize,medicalName);
        return Result.success(pageResult);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        DiagnosisTreatment diagnosisTreatment = diagnosisTreatmentService.getById(id);
        return Result.success(diagnosisTreatment);
    }
    @PostMapping
    public Result save(@RequestBody DiagnosisTreatment diagnosisTreatment){
        diagnosisTreatmentService.save(diagnosisTreatment);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody DiagnosisTreatment diagnosisTreatment){
        diagnosisTreatmentService.update(diagnosisTreatment);
        return Result.success();
    }
    @DeleteMapping()
    public Result delete(@RequestParam List<Integer> ids){
        diagnosisTreatmentService.delete(ids);
        return Result.success();
    }
}
