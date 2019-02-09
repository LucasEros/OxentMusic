package br.com.oxentmusic.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.com.oxentmusic.seguranca.JWTAuthenticationFilter;
import br.com.oxentmusic.seguranca.JWTAuthorizationFilter;
import br.com.oxentmusic.seguranca.JWTutil;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private JWTutil jwtUtil;
	
	@Autowired
	private UserDetailsService userService;
	
	public static final String[] PUBLIC_MATCHERS = {
		"/usuarios/**",
		"/musicas",
		"/swagger-ui.html#/"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(configurationSource())
			.and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers(HttpMethod.POST, "/login").permitAll()
			.antMatchers(HttpMethod.POST, "/musicas").permitAll()
			.antMatchers(HttpMethod.POST, "/register").permitAll()
			.antMatchers(HttpMethod.POST, "/usuarios").permitAll()
			.and()
			.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil))
			.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userService))
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncorder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncorder());
	}
	
	@Bean
    CorsConfigurationSource configurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedHeader("*");
        configuration.addAllowedOrigin("*");
        configuration.addAllowedMethod("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
