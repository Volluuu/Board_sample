package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("bdto")
public class BoardDto {
	private int board_num;
	private String board_title;
	private String board_content;
	private int user_num;
	private int reboard_num;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp board_writeday;
}
