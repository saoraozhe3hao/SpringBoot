package com.xianqingzao.yequxiaoquan.admin.security;

import com.xianqingzao.yequxiaoquan.admin.common.CaptchaFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private LogOutHandler logOutHandler;
    @Autowired
    private CaptchaFilter captchaFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore( captchaFilter, UsernamePasswordAuthenticationFilter.class )
                .formLogin()      // 使用表单登录
                .loginPage("/admin/logout")  // 未登录时重定向到登录页面， 不指定则使用Spring security 默认提供的登录页面
                .loginProcessingUrl("/admin/login")  // 指定 登录接口 url,默认参数名为 username password
                .successHandler(loginSuccessHandler)  // 指定登录成功处理类，不指定则重定向
                .failureHandler(loginFailureHandler) // 指定登录失败处理类，不指定则重定向


                .and()
                .authorizeRequests()   // 开始授权配置
                .antMatchers("/admin/captcha").permitAll()  // 对图片验证码 的请求，无需权限
                .antMatchers("/admin/logout").permitAll()  // 对登出 的请求，无需权限
                .antMatchers(HttpMethod.POST, "/manage/*").hasRole("manager") // 对 /manage/* 的请求，需要拥有manager角色
                .antMatchers("/client/*").hasAuthority("client") // 对 /client/* 的请求，需要拥有client权限
                .anyRequest().authenticated()           // 针对所有请求，进行身份认证

                .and()
                .logout()   // 开始 登出配置
                .logoutUrl("/signOut")  // 登出接口，默认为 /logout
                .logoutSuccessUrl("/admin/logout")  // 登出重定向到的路径，默认为loginPage
                .logoutSuccessHandler(logOutHandler) // 与logoutSuccessUrl互斥
                .deleteCookies("JSESSION") // 登出时 清理 cookie

                .and()
                .cors()
                .and()
                .csrf()   // 开始csrf配置
                .disable();  // 放开csrf防御
        super.configure(http);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 这是Spring提供的一个密码加密器，加盐散列，并将盐拼入散列值，可用防止散列撞库
        return new BCryptPasswordEncoder(); // 也可以自己实现一个 PasswordEncoder
    }

    @Bean
    // 跨域配置
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new      UrlBasedCorsConfigurationSource();
        final CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
