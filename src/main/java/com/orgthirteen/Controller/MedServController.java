package com.orgthirteen.Controller;

import com.orgthirteen.Service.MedServService;
import com.orgthirteen.pojo.MedServ;
import com.orgthirteen.pojo.PageResult;
import com.orgthirteen.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/medserv")
public class MedServController {
    @Autowired
    private MedServService medServService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "5") Integer pageSize,String medicalName){
        PageResult<MedServ> pageResult = medServService.page(page,pageSize,medicalName);
        return Result.success(pageResult);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        MedServ medServ = medServService.getById(id);
        return Result.success(medServ);
    }
    @PostMapping
    public Result save(@RequestBody MedServ medServ){
        medServService.save(medServ);
        return Result.success();
    }
    @PutMapping
    public Result update(@RequestBody MedServ medServ){
        medServService.update(medServ);
        return Result.success();
    }
    @DeleteMapping()
    public Result delete(@RequestBody List<Integer> id){
        medServService.delete(id);
        return Result.success();
    }
}
