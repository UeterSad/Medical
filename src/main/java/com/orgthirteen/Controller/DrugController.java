package com.orgthirteen.Controller;

import com.orgthirteen.Service.DrugService;
import com.orgthirteen.pojo.Drugs;
import com.orgthirteen.pojo.PageResult;
import com.orgthirteen.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/drugs")
public class DrugController {
    @Autowired
    private DrugService drugService;
    //分页查询
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer pageSize, String drugName) {
        PageResult<Drugs> pageResult = drugService.page(page, pageSize, drugName);
        return Result.success(pageResult);
    }
    //查询回显
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        Drugs drugs = drugService.findById(id);
        return Result.success(drugs);
    }
    //修改
    @PutMapping
    public Result update(@RequestBody Drugs drugs) {
        drugService.update(drugs);
        return Result.success();
    }
    //新增
    @PostMapping
    public Result save(@RequestBody Drugs drugs) {
        drugService.save(drugs);
        return Result.success();
    }
    //删除
    //前端Json格式：[1,2,3]
    @DeleteMapping()
    public Result delete(@RequestBody List<Integer> id) {
        drugService.delete(id);
        return Result.success();
    }

}
