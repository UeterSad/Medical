package com.orgthirteen.Controller;

import com.orgthirteen.Service.HospReimburseService;
import com.orgthirteen.pojo.HospReimburse;
import com.orgthirteen.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manage/hospReimburse")
public class HospReimburseController {
    @Autowired
    private HospReimburseService hospReimburseService;

    @GetMapping("/level1")
    public Result findLevel1(){
        String level = "1";
        List<HospReimburse> hospReimburseList = hospReimburseService.findByLevel(level);
        return Result.success(hospReimburseList);
    }
    @GetMapping("/level2")
    public Result findLevel2(){
        String level = "2";
        List<HospReimburse> hospReimburseList = hospReimburseService.findByLevel(level);
        return Result.success(hospReimburseList);
    }
    @GetMapping("/level3")
    public Result findLevel3(){
        String level = "3";
        List<HospReimburse> hospReimburseList = hospReimburseService.findByLevel(level);
        return Result.success(hospReimburseList);
    }
    @PostMapping("/level1")
    public Result saveLevel1(@RequestBody HospReimburse hospReimburse){
        hospReimburse.setHospitalLevel("1");
        hospReimburseService.savelevel(hospReimburse);
        return Result.success();
    }
    @PostMapping("/level2")
    public Result saveLevel2(@RequestBody HospReimburse hospReimburse){
        hospReimburse.setHospitalLevel("2");
        hospReimburseService.savelevel(hospReimburse);
        return Result.success();
    }
    @PostMapping("/level3")
    public Result saveLevel3(@RequestBody HospReimburse hospReimburse){
        hospReimburse.setHospitalLevel("3");
        hospReimburseService.savelevel(hospReimburse);
        return Result.success();
    }
    @PutMapping("/level1")
    public Result updateLevel1(@RequestBody HospReimburse hospReimburse){
        hospReimburseService.updatelevel(hospReimburse);
        return Result.success();
    }
    @PutMapping("/level2")
    public Result updateLevel2(@RequestBody HospReimburse hospReimburse){
        hospReimburseService.updatelevel(hospReimburse);
        return Result.success();
    }
    @PutMapping("/level3")
    public Result updateLevel3(@RequestBody HospReimburse hospReimburse){
        hospReimburseService.updatelevel(hospReimburse);
        return Result.success();
    }
    @DeleteMapping("/level1")
    public Result deleteLevel1(@RequestParam("id") Integer id){
        hospReimburseService.delete(id);
        return Result.success();
    }
    @DeleteMapping("/level2")
    public Result deleteLevel2(@RequestParam("id") Integer id){
        hospReimburseService.delete(id);
        return Result.success();
    }
    @DeleteMapping("/level3")
    public Result deleteLevel3(@RequestParam("id") Integer id){
        hospReimburseService.delete(id);
        return Result.success();
    }

}
