package com.pvstechlabs.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.pvstechlabs.app.security.CustomAuthenticationProvider;
import com.pvstechlabs.app.security.ExpenseUserDetailsService;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${ad.domain}")
	private String adDomain;

	@Value("${root.domain}")
	private String rootDomain;

	@Value("${ad.url}")
	private String adUrl;

	@Value("$ad.userFilter")
	private String searchFilter;

	@Value("$ad.userDn")
	private String userDn;

	@Value("ad.userDn.password")
	private String userDnPwd;

	@Value("ad.userDnPattern")
	private String userDnPattern;

	@Autowired
	private ExpenseUserDetailsService userDetailsService;

	@Autowired
	private CustomAuthenticationProvider authProvider;

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
	public void configure(AuthenticationManagerBuilder auth) throws Exception { // auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authProvider);// custom
	}

	public void configureLdap(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().userSearchFilter("(cn={0})").userSearchBase("cn=users,dc=bangalore,dc=com")
				.contextSource(contextSource()).groupRoleAttribute("cn").groupSearchBase("cn=users,dc=bangalore,dc=com")
				.groupSearchFilter("(cn={0})");
	}

	private BaseLdapPathContextSource contextSource() {
		LdapContextSource context = new LdapContextSource();
		context.setUrl("ldap://bangalore.com:389");
		context.setUserDn("cn=administrator,cn=users,dc=bangalore,dc=com");
		context.setPassword("P@ssword123");
		context.afterPropertiesSet();
		return context;
	}

}
