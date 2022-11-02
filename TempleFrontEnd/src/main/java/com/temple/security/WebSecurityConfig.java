package com.temple.security;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
// 
//    @Autowired
//    private DataSource dataSource;
//     
//    @Autowired
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//            .passwordEncoder(new BCryptPasswordEncoder())
//            .dataSource(dataSource)
//            .usersByUsernameQuery("select user_Name, user_Password, enabled from temple_user where user_Name=?")
//            .authoritiesByUsernameQuery("select user_Name, user_Role from temple_user where user_Name=?")
//        ;
//    }
//    
////    @Bean
////	public PasswordEncoder getPasswordEncoder()
////	{
////		return NoOpPasswordEncoder.getInstance();
////	}
//    
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        
//        http.csrf().disable().httpBasic().and().authorizeRequests()  
//        .antMatchers("/api/admin/**").hasAuthority("admin")
//        .antMatchers("/api/user/**").hasAuthority("user")
//        .anyRequest().authenticated()
//            .and()
//            .formLogin().permitAll()
//            .and()
//            .logout().permitAll();     
//    }
//}
//













//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class LoginSecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder authenticationMgr) throws Exception {
//		authenticationMgr.inMemoryAuthentication()
//			.withUser("jduser").password("jdu@123").authorities("ROLE_USER")
//			.and()
//			.withUser("Teja").password("Teja1199#").authorities("ROLE_ADMIN");
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		
//		http.authorizeRequests()
//		    
//			.antMatchers("/homePage").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//			.antMatchers("/userPage").access("hasRole('ROLE_USER')")
//			.antMatchers("/").access("hasRole('ROLE_ADMIN')")
//			.and()
//				.formLogin().loginPage("/loginPage")
//				.defaultSuccessUrl("/homePage")
//				.failureUrl("/loginPage?error")
//				.usernameParameter("userName").passwordParameter("password")				
//			.and()
//				.logout().logoutSuccessUrl("/loginPage?logout"); 
//		
//		http
//	    .authorizeRequests()
//	    .antMatchers("/api/addUser").permitAll()
//	    .anyRequest().authenticated();
//
//		
//	}
//}
//
