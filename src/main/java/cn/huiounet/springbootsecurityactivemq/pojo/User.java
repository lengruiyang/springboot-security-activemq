package cn.huiounet.springbootsecurityactivemq.pojo;

import lombok.Data;

import javax.persistence.Table;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/2/3 19:34
 */
@Data
@Table(name = "user")
public class User {
    private int id;
    private String username;
    private String password;
    private String role;
}
