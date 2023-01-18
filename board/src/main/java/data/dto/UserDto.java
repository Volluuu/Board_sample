package data.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDto {
	
	private int user_num;
	private String user_name;
	
	//@JsonProperty(access = JsonProperty.Access.WRITE_ONLY) 
	// Write할때만 접근 허용. 응답 결과를 생성할 때는 해당 필드는 제외된다
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String user_pass;
	private String user_email;
	private String user_id;
	private String auth;
	private int state;
	
	@Override
	public String toString() {
		return "UserDto [user_id=" + user_id + ", user_pass=" + user_pass + 
				", user_name=" + user_name + ", auth=" + auth + ", state="
				+ state + "]";
	}

}
