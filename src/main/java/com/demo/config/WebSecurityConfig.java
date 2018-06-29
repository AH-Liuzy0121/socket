package com.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @className: WebSecurityConfig
 * @package: com.demo.config
 * @describe: 配置驗證信息
 * @auther: liuzhiyong
 * @date: 2018/6/28
 * @time: 上午 11:43
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()//不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //登陆页面路径为/login
                .defaultSuccessUrl("/chat") //登陆成功转向chat页面
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    /**
     * @methodName: configure
     * @param: [auth]
     * @describe: 配置用戶信息至內存中用於驗證
     * @auther: liuzhiyong
     * @date: 2018/6/28
     * @time: 上午 11:45
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

            auth
                    .inMemoryAuthentication()
                    .passwordEncoder(new BCryptPasswordEncoder())
                    .withUser("admin")
                    .password(new BCryptPasswordEncoder().encode("admin")).roles("USER")
                    .and()
                    .passwordEncoder(new BCryptPasswordEncoder())
                    .withUser("abel")
                    .password(new BCryptPasswordEncoder().encode("abel")).roles("USER");

           /* auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER")
                .and()
                .withUser("abel").password("abel").roles("USER");*/
    }

    //忽略静态资源的拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }

}