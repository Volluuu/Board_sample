package data.security;




import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

//웹 보안 어노테이션
//추가적인 설정을 위해  extends WebSecurityConfigurerAdapter 추가
@EnableWebSecurity
@RequiredArgsConstructor
@Configuration(proxyBeanMethods = false)
@ConditionalOnDefaultWebSecurity
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class SecurityConfig  {
	
		 
	
//	    @Bean
//	    public PasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }

//	    @Bean
//	    public void configure(WebSecurity web) {
//	        web.ignoring()
//	               .antMatchers("/h2-console/**", "/favicon.ico");
//	    }

//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        // CSRF 설정 Disable
//	        http
//             .csrf().disable();
//	        http
//	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//세션을 사용하지 않을것으로 stateless처리한다
//	        .and()
////	        .addFilter()
//	        .formLogin().disable()//폼로그인 방식의 로그인을 사용하지 않는다
//	        .httpBasic().disable() //JWT는 httpBearer 방식으로 httpBasic방식은 disable처리
//	        .authorizeRequests()
//	        //이부분은 페이지에 맞게 작성
//	        .antMatchers("/user/**")
//	        .anyRequest()//그 이외에 모든 요청은 허용한다
//	        .permitAll();
//	    }

//	    @Bean
//	    public CorsConfigurationSource corsConfigurationSource() {
//
//	        CorsConfiguration corsConfiguration = new CorsConfiguration();
//	        corsConfiguration.addAllowedOrigin("http//localhost:3000");
//	        corsConfiguration.addAllowedHeader("*");
//	        corsConfiguration.addAllowedOriginPattern("*");
//	        corsConfiguration.addAllowedMethod("*");
//	        corsConfiguration.setAllowCredentials(true);
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", corsConfiguration);
//	        return source;
//	    }

}
