package Travel_Foly.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import Travel_Foly.DAO.AccountDAO;
import Travel_Foly.Service.UserDetailServiceImpl;

@Configuration
@EnableWebSecurity
@EnableAutoConfiguration
public class SecurityConfig {
	@Autowired
	AccountDAO accountDao;
		
	@Bean
	public DaoAuthenticationProvider getDaoAuthenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider =  new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(new UserDetailServiceImpl(accountDao));
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
		
		return daoAuthenticationProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(auth ->{
			auth.requestMatchers("/travelfpoly/account/login","/travelfpoly/account/logout","/travelfpoly/home","/travelfpoly/tour-detail","/travelfpoly/tour-detail/**").permitAll()
			.requestMatchers("/travelfpoly/admin","/travelfpoly/admin/**").hasAnyRole("ADMIN")
			.requestMatchers("/travelfpoly/cart","/travelfpoly/cart/**","/travelfpoly/order","/travelfpoly/order/**").hasAnyRole("USER")
			.anyRequest().permitAll();
		})
		.formLogin(login ->{
			login.loginPage("/travelfpoly/account/login")
			.loginProcessingUrl("/travelfpoly/account/login")
			.defaultSuccessUrl("/travelfpoly/home",true);
			
		})
		.logout(logout ->{
			logout.logoutUrl("/travelfpoly/account/logout")
			.logoutSuccessUrl("/travelfpoly/account/login");
		})
		.oauth2Login(auth ->{
			auth.defaultSuccessUrl("/travelfpoly/home",true);
		})
		.exceptionHandling(ex ->{
			ex.accessDeniedHandler((request,respone,asscessDeni) -> respone.sendRedirect("/travelfpoly/account/login"));
		})
		
		.csrf(csrf -> csrf.disable());
		return http.build();
	}
}
