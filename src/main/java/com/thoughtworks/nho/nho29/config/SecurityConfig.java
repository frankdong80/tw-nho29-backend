package com.thoughtworks.nho.nho29.config;
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
