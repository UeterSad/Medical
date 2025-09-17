package com.orgthirteen.Controller;

import com.orgthirteen.pojo.Result;
import com.orgthirteen.utils.AliyunOSSOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliyunOSSOperator aliyunOSSOperator;
    @PostMapping("/upload")
    public Result upload(MultipartFile file) throws Exception {
        log.info("上传的文件名:{}",file.getOriginalFilename());
        String url= aliyunOSSOperator.upload(file.getBytes(),file.getOriginalFilename());
        log.info("上传的文件地址:{}",url);
        return Result.success(url);
    }
}
