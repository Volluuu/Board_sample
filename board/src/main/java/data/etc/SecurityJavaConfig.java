//package data.etc;

//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//public class SecurityJavaConfig {
//
//	//application.yml로 부터 JWT 비밀키를 가져온다.(보안을 위해)
//	@Value("${jwt.secret}")
//	private String secret;
//	
//	@Bean
//	protected void configure(HttpSecurity http) throws Exception{
//		http
//        .cors().disable() //cors방지
//        .csrf().disable() //csrf방지
//        .formLogin().disable() //기본 로그인 페이지 없애기
//        .headers().frameOptions().disable();
//	}
//	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//    public JwtUtill jwtUtil(){
//        return new JwtUtill(secret);
//    }
//}
