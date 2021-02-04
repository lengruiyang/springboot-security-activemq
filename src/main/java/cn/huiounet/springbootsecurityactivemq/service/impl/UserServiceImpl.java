package cn.huiounet.springbootsecurityactivemq.service.impl;


import cn.huiounet.springbootsecurityactivemq.dao.UserDao;
import cn.huiounet.springbootsecurityactivemq.pojo.User;
import cn.huiounet.springbootsecurityactivemq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/2/3 19:37
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public User findByUserName(String username) {
        return userDao.findByUserName(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.insert(user);
    }
}
