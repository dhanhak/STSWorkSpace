package kh.spring.repositories;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.BoardDTO;
import kh.spring.dto.MembersDTO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

//	public List<BoardDTO> boardList() {
//		String sql = "select * from board";
//		return jdbc.query(sql, new BeanPropertyRowMapper<BoardDTO>(BoardDTO.class));
//		
//	}
//
//	public int write(BoardDTO dto) {
//		String sql = "insert into board values (board_seq.nextval,?,?,?,'default',sysdate)";
//		return jdbc.update(sql,dto.getWriter(),dto.getTitle(),dto.getContent());
//		
//	}
//	
//	
	
	
}
