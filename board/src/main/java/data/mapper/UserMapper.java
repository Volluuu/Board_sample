package data.mapper;

import org.apache.ibatis.annotations.Mapper;

import data.dto.UserDto;

@Mapper
public interface UserMapper {
	
	//이메일을 통한 유저 정보
	public UserDto getUserInfo(String user_email);

    public UserDto getUserByNum(int user_num);

    public void insertUser(UserDto dto);

//    // 이메일 중복 체크
    public int emailCheck(String user_email);
//
//    // 핸드폰 중복 체크
//    public int idCheck(String user_id);
//    // 이전 비밀번호 일치 체크
//    public int passCheck(UserDto dto);
    
    
    
//    //이메일 수정
//    public void emailChange(UserDto dto);
//    // 비밀번호 수정
//    public void passChange(UserDto dto);
//    // 이름 수정
//    public void nameChange(UserDto dto);

  
    //회원 탈퇴
    public void deleteUser(int u_num);

//    // 휴대폰 번호로 이메일 찾기
//    public String findEmailByHp(String hp);
//
//    // 휴대폰 번호, 이메일에 맞는 아이디 있는지 체크
//    public int findPassCheck(UserDto dto);
//    // 임시 비밀번호로 변경
//    public void findPassUpdate(UserDto dto);
//
//    // refresh_token 삭제
//    public void deleteRefreshToken(int u_num);
}
