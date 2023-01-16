package data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.dto.UserDto;
import data.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserMapper userMapper;
	
	 @PostMapping("/signup")
	    public void signup(@RequestBody UserDto dto) {
//	        if (userMapper.getUserInfo(userDto.getUser_email()) != null) {
//	            throw new RuntimeException("이미 가입되어 있는 유저입니다.");
//	        } else {
//	            userDto.setPass(passwordEncoder.encode(userDto.getPass()));
	            userMapper.insertUser(dto);
//	        }
	    }
	 
	 @GetMapping("/emailcheck")
	    public int emailCheck(@RequestParam String user_email) {
	        return userMapper.emailCheck(user_email);
	    }
	 
	 @RequestMapping("/logIn")
	 public String signIn(@RequestBody UserDto dto, HttpServletRequest request) {
	 	UserDto signIn = userMapper.logIn(dto);
	 	HttpSession session = request.getSession();				
	 	if (signIn != null) {
	 		session.setAttribute("signIn", signIn);
	 		return "redirect:/";
	 	} else {
	 		session.setAttribute("signIn", null);
	 		return "redirect:/login";
	 	}
	 }
	 // 로그아웃
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
	 	session.invalidate();
	 	return "redirect:/login";
	 }
}
