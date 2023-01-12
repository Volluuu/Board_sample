package data.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("udto")
public class UserDto {
	private int user_num;
	private String user_name;
	private String user_pass;
	private String user_email;
	private String user_id;

}
