package com.orgthirteen.Controller;

import com.orgthirteen.Service.DrugReimburseService;
import com.orgthirteen.pojo.DrugReimburse;
import com.orgthirteen.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/drugReimburse")
public class DrugReimburseController {
    @Autowired
    private DrugReimburseService drugReimburseService;

    @GetMapping
    public Result findAll() {
        List<DrugReimburse> drugReimburseList = drugReimburseService.findAll();
        return Result.success(drugReimburseList);
    }
    @PostMapping
    public Result save(@RequestBody DrugReimburse drugReimburse) {
        drugReimburseService.save(drugReimburse);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody DrugReimburse drugReimburse) {
        drugReimburseService.update(drugReimburse);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        drugReimburseService.delete(id);
        return Result.success();
    }
}
