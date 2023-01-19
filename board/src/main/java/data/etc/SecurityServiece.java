//package data.etc;
//
//import java.security.Key;
//import java.util.Date;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//
//import org.springframework.stereotype.Service;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Service
//public class SecurityServiece {
//	//SECRET_KEY는 이렇게 넣어두면 안된다. 예시를 위해 잠시 넣어굼
//	private static final String SECTRT_KEY="dskfjdksljfkldsjflkdjsfkld;sjslkjfdklsjfdklsjf";
//	
//	//로그인 서비스 던질때 같이
//	public String createToken(String user_id,String user_pass, String user_num,long expTime) {
//		//만료시간이 작으면 안되므로
//		if(expTime<=0) {
//			throw new RuntimeException("만료시간이 0보다 커야함~");
//		}
//		//사용할 알고리즘 추가
//		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//		
//		//로직안에서 바이트 단위로 만들어야함
//		byte[] secretKeyBytes=DatatypeConverter.parseBase64Binary(SECTRT_KEY);
//		
//		//키 만들기
//		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
//		
//		//인증에 필요한 정보, 인증키, 만료시간을 반환한다.
//		return Jwts.builder()
//				.claim("user_id",user_id)
//				.claim("user_pass", user_pass)
//				.claim("user_num", user_num)
//				.signWith(signingKey, signatureAlgorithm)
//				.setExpiration(new Date(System.currentTimeMillis()+expTime))
//				.compact();
//	}
//	
//	//토큰에서 정보 꺼내기
//	//Claims = payload정보
//	//토큰 검증하는 메서드를 boolean으로
//	public String getSubject(String token) {
//		Claims claims = Jwts.parserBuilder()
//				.setSigningKey(DatatypeConverter.parseBase64Binary(SECTRT_KEY))//키 셋팅
//				.build()
//				.parseClaimsJws(token)//토큰 정보를 풀어줌
//				.getBody();
//		return claims.getSubject();//suject에 해당 하는 내용 가져오기
//	}
//	
//	
//
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
