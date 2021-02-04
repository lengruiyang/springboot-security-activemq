package cn.huiounet.springbootsecurityactivemq.service;


import cn.huiounet.springbootsecurityactivemq.pojo.User;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/2/3 19:37
 */
public interface UserService {

    User findByUserName(String username);

    void saveUser(User user);
}
