package com.orgthirteen.pojo;

import lombok.Data;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表实体类
 * 对应表 sys_user
 */
@Data
public class User {


    /**
     * 主键
     */
    private Integer id;

    /**
     * 登录用户名
     */
    private String loginName;

    /**
     * 真实姓名
     */
    private String userName;

    /**
     * 性别: 1-男 2-女
     */
    private Byte gender;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 联系方式
     */
    private String mobile;

    /**
     * 用户状态: 1-正常 0-禁用
     */
    private Byte status;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 逻辑删除标识: 0-未删除; 1-已删除
     */
    private Byte deleted;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 更新时间
     */
    private Date gmtModified;
}