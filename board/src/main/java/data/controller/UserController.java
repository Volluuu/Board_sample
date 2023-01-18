package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.dto.UserDto;
import data.mapper.UserMapper;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	 @PostMapping("/signup")
	    public void signup(@RequestBody UserDto dto) {
	        if (userMapper.getUserInfo(dto.getUser_id()) != null) {
	            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
	        } else {
	        	System.out.println("Before:"+dto.getUser_pass());
	        	String endcodedPassword = bcryptPasswordEncoder.encode(dto.getUser_pass());
	        	System.out.println("After"+endcodedPassword);
	        	System.out.println("regist"+dto);
	        	
	        	dto.setUser_pass(endcodedPassword);
	        	
	            userMapper.insertUser(dto);
	        }
	    }
	 
	 @GetMapping("/idcheck")
	    public int idCheck(@RequestParam String user_id) {
	        return userMapper.idCheck(user_id);
	    }
	 
//	 @PostMapping("/login")
//	 public String login(@RequestBody UserDto dto, HttpServletRequest request) {
//		return userMapper.login(dto);
//	 }
	 // 로그아웃
	 @PostMapping("/logout")
	 public String logout(HttpSession session) {
	 	session.invalidate();
	 	return "redirect:/login";
	 }
}
