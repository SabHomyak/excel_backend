package excel.online.config;

import excel.online.services.UserService;
import lombok.var;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;

//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors()
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/api/excel/**").authenticated()
//                .and()
//                .httpBasic();
////                .authorizeRequests()
////                .antMatchers("/authenticated/**").authenticated()
////                .antMatchers("/only_for_admins/**").hasAnyRole("admin")
////                .antMatchers("/read_profile/**").hasAnyAuthority("READ_PROFILE")
////                .and()
////                .formLogin()
////                .loginProcessingUrl("/myLoginnnnn")
////                .and()
////                .logout()
////                .logoutSuccessUrl("/");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        authenticationProvider.setUserDetailsService(userService);
//        return authenticationProvider;
//    }
//}
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//                .addFilterBefore(corsFilter(), SessionManagementFilter.class)
//                .cors().configurationSource(request -> {
//            CorsConfiguration cors = new CorsConfiguration();
//            cors.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
//            cors.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE", "OPTIONS"));
//            cors.setAllowedHeaders(Arrays.asList("*"));
//            return cors;
//        }).and()
//                .cors()
//                .and()
                .csrf().disable()
                .httpBasic();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setUserDetailsService(userService);
        return authenticationProvider;
    }
}
