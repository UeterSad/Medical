package com.orgthirteen.Controller;

import com.orgthirteen.Service.UserService;
import com.orgthirteen.pojo.LoginInfo;
import com.orgthirteen.pojo.Result;
import com.orgthirteen.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        LoginInfo loginInfo = userService.login(user);
        if(loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");
    }

}
