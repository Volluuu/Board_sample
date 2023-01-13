package data.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("rbdto")
public class ReboardDto {
	private int reboard_num;
	private String reboard_title;
	private String reboard_content;
	private int user_num;
	private int board_num;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "Asia/Seoul")
    private Timestamp day;
}
