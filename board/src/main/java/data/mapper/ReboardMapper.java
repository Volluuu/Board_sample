package data.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import data.dto.ReboardDto;

@Mapper
public interface ReboardMapper {
	public int getReboardCount(int board_num);
	public List<ReboardDto> boardByUser(Map<String, Object> map);
	//글 작성
	public void insertBoard(ReboardDto dto);
	//수정
	public void updateBoard(ReboardDto dto);
	//삭제
	public void deleteBoard(ReboardDto dto);
}
