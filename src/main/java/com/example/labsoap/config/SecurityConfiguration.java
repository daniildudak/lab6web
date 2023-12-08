//package com.example.labsoap.config;
//
//import com.example.labsoap.service.UserService;
//import com.example.labsoap.service.impl.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    private final UserService userService;
//
//    public SecurityConfiguration(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
////    @Bean
////    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
////        // @formatter:off
////        httpSecurity
////                .csrf().disable()
////                .cors()
////                .and()
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
////                .and()
////                .authorizeRequests()
////                .antMatchers("/photos/getAll").permitAll() // Разрешить доступ без авторизации
////                .anyRequest().authenticated()
////                .and()
////                .oauth2ResourceServer().jwt();
////        // @formatter:on
////        return httpSecurity.build();
////    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/login", "/oauth/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .oauth2Login()
//                .loginPage("/login")
//                .userInfoEndpoint()
//                .userService(oauthUserService)
//                .and()
//                        .successHandler((request, response, authentication) -> {
//
//                            CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();
//
//                            userService.processOAuthPostLogin(oauthUser.getEmail());
//
//                            response.sendRedirect("/list");
//                        });
//    }
//
//    @Autowired
//    private CustomOAuth2UserService oauthUserService;
//}