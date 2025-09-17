package com.orgthirteen.Service.Impl;

import com.orgthirteen.Mapper.UserMapper;
import com.orgthirteen.Service.UserService;
import com.orgthirteen.pojo.LoginInfo;
import com.orgthirteen.pojo.User;
import com.orgthirteen.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public LoginInfo login(User user) {
            // 加密用户输入的密码
            String encryptedPassword = encodePassword(user.getPassword());
            // 使用加密后的密码查询
            User userLogin = userMapper.findByUsername(user.getLoginName());
            if (userLogin != null && userLogin.getPassword().equals(encryptedPassword)){
                //生成Jwt令牌
                Map<String,Object> dataMap = new HashMap<>();
                dataMap.put("id",userLogin.getId());
                dataMap.put("loginName",userLogin.getLoginName());
                String token = JwtUtils.generateToken(dataMap);
                //封装返回数据
                LoginInfo loginInfo = new LoginInfo(userLogin.getId(),userLogin.getLoginName(),userLogin.getUserName(),token);
                return loginInfo;
            }
            return null;
    }
    public void register(User user) {
        // 检查用户名是否已存在
        if (userMapper.findByUsername(user.getLoginName()) != null) {
            throw new RuntimeException("用户名已存在");
        }
        if (user.getGmtCreate() == null) {
            user.setGmtCreate(new Date());
        }
        // 密码加密处理
        user.setPassword(encodePassword(user.getPassword()));
        userMapper.insert(user);
    }

    @Override
    public void updateUser(User user) {
        if (user.getGmtModified() == null) {
            user.setGmtModified(new Date());
        }
        userMapper.update(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }

    private String encodePassword(String password) {
        // 这里使用简单的MD5加密
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            throw new RuntimeException("密码加密失败", e);
        }
    }
}
