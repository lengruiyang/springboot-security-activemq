package cn.huiounet.springbootsecurityactivemq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * 作者 ：冷瑞阳
 * 首次编辑时间 ：2021/2/3 21:36
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AuthenticationProvider provider;  //注入我们自己的AuthenticationProvider
    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler myAuthenticationFailHander;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // 关闭csrf防护
                .csrf().disable()
                .headers().frameOptions().disable()
                .and();
        http
                //登录处理
                .formLogin() //表单方式，或httpBasic
                .loginPage("/login_Page.html")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailHander)
                .loginProcessingUrl("/form")
                .defaultSuccessUrl("/index.html") //成功登陆后跳转页面
                //.failureUrl("/loginError.html")
                .permitAll()
                .and();
        http
                .authorizeRequests() // 授权配置
                .antMatchers(HttpMethod.GET, "/security/saveUser").permitAll()
//                .antMatchers( "/css/**", "/error404").permitAll()
                .antMatchers("/security/admin/**").hasRole("admin")
                .antMatchers("/security/user/**").hasRole("USER")
                .antMatchers("/producer/**").permitAll()
                //其他接口需要登录后才能访问
                .anyRequest().authenticated()
                .and();
    }

}

