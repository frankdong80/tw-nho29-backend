package com.blackbirdsport.ershou.config;

import com.blackbirdsport.ershou.domain.AccountSecurityRepository;
import com.blackbirdsport.ershou.domain.ClientRepository;
import com.blackbirdsport.ershou.domain.ManagerRepository;
import com.blackbirdsport.ershou.exception.EncryptionException;
import com.blackbirdsport.ershou.utils.EncryptionTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author Fuqiang
 * Created on 20/06/2017.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        this.httpSecurityHolder.setHttpSecurity(http);
        // @formatter:off
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .rememberMe()
                .key("twnho29").tokenValiditySeconds(60 * 60 * 24 * 30);//30天
        // @formatter:on
    }
}
