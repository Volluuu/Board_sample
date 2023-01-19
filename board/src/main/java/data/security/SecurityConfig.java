package data.security;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//웹 보안 어노테이션
//추가적인 설정을 위해  extends WebSecurityConfigurerAdapter 추가
@Configuration
@EnableWebSecurity //시큐리티 필터가 필터 체인에 등록하는 어노테이션
public class SecurityConfig {

	
		private final Logger log = LoggerFactory.getLogger(getClass());
		private final TokenProvider tokenProvider;
	  
	    private final AuthenticationEntryPoint authenticationEntryPoint;
	    private final AccessDeniedHandler accessDeniedHandler;
		// private final JwtFilter jwtFilter;
		// private final JwtExceptionFilter jwtExceptionFilter;
		
		public SecurityConfig(
			TokenProvider tokenProvider,
			
			AuthenticationEntryPoint authenticationEntryPoint,
			AccessDeniedHandler accessDeniedHandler
			// JwtFilter jwtFilter
			// JwtExceptionFilter jwtExceptionFilter
		
		){
	        this.tokenProvider = tokenProvider;
	       
	        this.authenticationEntryPoint = authenticationEntryPoint;
	        this.accessDeniedHandler = accessDeniedHandler;
			// this.jwtFilter = jwtFilter;
			// this.jwtExceptionFilter = jwtExceptionFilter;
		}

		
		

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
		public AccessDeniedHandler accessDeniedHandler() {
			log.warn("accessDeniedHandler");
			return (request, response, e) -> {
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				response.setContentType("text/plain;charset=UTF-8");
				response.getWriter().write("ACCESS DENIED");
				response.getWriter().flush();
				response.getWriter().close(); 
			};
		}

		@Bean
		public AuthenticationEntryPoint authenticationEntryPoint() {
			return (request, response, e) -> {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.setContentType("text/plain;charset=UTF-8");
				response.getWriter().write("UNAUTHORIZED");
				response.getWriter().flush();
				response.getWriter().close();
			};
		}

		 private static final String[] AUTH_WHITELIST = {
		            "/**", "/user/**"
		    };
		 
		 
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			 http
			 		.csrf().disable()
			 		.cors().disable()
	                .authorizeHttpRequests((authorize) -> authorize
	                        .requestMatchers(AUTH_WHITELIST)
	                        .permitAll()
	                        .anyRequest()
	                        .authenticated()
	                        )
	                .httpBasic();
	                		
			 return http.build();
	    }
    
		@Bean
	    public CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration configuration = new CorsConfiguration();

	        configuration.addAllowedOrigin("*");
	        configuration.addAllowedHeader("*");
	        configuration.addAllowedMethod("*");
	        configuration.setAllowCredentials(true);

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", configuration);
	        return source;
		}
		

}
