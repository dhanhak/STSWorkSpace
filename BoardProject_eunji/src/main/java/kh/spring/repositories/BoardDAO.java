package kh.spring.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;

@Repository
public class BoardDAO {
	
//	@Autowired
//	private JdbcTemplate jdbc;
//	
//	public int insertContent(BoardDTO dto) {
//		String sql = "insert into board values(board_seq.nextval,?,?,?,0,sysdate)";
//		return jdbc.update(sql, dto.getWriter(), dto.getTitle(), dto.getContents());
//	}
//	
//	public List<BoardDTO> selectAll() {
//		String sql = "select * from board order by 1 desc";
//		return jdbc.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
//	}
	
}
