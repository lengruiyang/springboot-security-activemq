package cn.huiounet.springbootsecurityactivemq.web;


import cn.huiounet.springbootsecurityactivemq.pojo.User;
import cn.huiounet.springbootsecurityactivemq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/2/3 19:53
 */
@RestController
@RequestMapping("/security")
public class SecurityUserController {
    @Autowired
    private UserService userService;
    @GetMapping("/saveUser")
    public void saveUser(String username,String pwd){
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        if(username.equals("lry")){
            user.setRole("admin");
        }else {
            user.setRole("USER");
        }
        userService.saveUser(user);
    }
    @GetMapping("/admin")
    public String GetAdmin(){
        return "admin";
    }
    @GetMapping("/user")
    public String GetUser(){
        return "user";
    }
    @GetMapping("loginUser")
    public Object whoIm()
    {
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
