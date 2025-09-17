package com.orgthirteen.Service;

import com.orgthirteen.pojo.LoginInfo;
import com.orgthirteen.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    LoginInfo login(User user);
    void register(User user);

    void updateUser(User user);

    User getUserById(Integer id);
}
