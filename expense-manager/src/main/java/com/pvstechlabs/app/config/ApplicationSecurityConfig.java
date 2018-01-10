package com.pvstechlabs.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.pvstechlabs.app.security.ExpenseUserDetailsService;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private ExpenseUserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/expense", "/expense/**").hasRole("USER").and().formLogin()
				.loginPage("/login").loginProcessingUrl("/login").usernameParameter("custom_username")
				.passwordParameter("custom_password").defaultSuccessUrl("/expense").failureUrl("/login?error=true")
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout=true");

		/*
		 * http.authorizeRequests().antMatchers("/admin",
		 * "/admin/**").hasRole("ADMIN").and().formLogin()
		 * .loginPage("/adminlogin").loginProcessingUrl("/adminlogin").
		 * usernameParameter("custom_username")
		 * .passwordParameter("custom_password").defaultSuccessUrl("/admin").
		 * failureUrl("/adminlogin?error=true")
		 * .and().logout().logoutUrl("/logout").logoutSuccessUrl(
		 * "/adminlogin?logout=true");
		 */
	}

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

}
