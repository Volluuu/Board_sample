//package data.etc;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/security")
//public class SecurityController {
//	@Autowired
//	private SecurityServiece securityServiece;
//	
//	@GetMapping("/create/token")
//	public Map<String, Object> createToken(@RequestParam(value="user_id") String user_id,
//											@RequestParam(value="user_pass") String user_pass,
//											@RequestParam(value="user_num") String user_num){
//		String token = securityServiece.createToken(user_id,user_pass,user_num,(2*1000*60));
//		Map<String, Object> map = new LinkedHashMap<>();
//		map.put("result", token);
//		return map;
//	}
//	
//	@GetMapping("/get/subject")
//	public Map<String,Object> getSubject(@RequestParam(value = "token") String token){
//		String subject = securityServiece.getSubject(token);
//		Map<String, Object> map = new LinkedHashMap<>();
//		map.put("result", token);
//		return map;
//	}
//}
