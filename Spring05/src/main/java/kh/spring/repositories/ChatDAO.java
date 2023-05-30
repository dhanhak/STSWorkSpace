package kh.spring.repositories;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.ChatDTO;

@Repository
public class ChatDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insert(ChatDTO dto) {
		return mybatis.insert("Chat.insert",dto);
	}
}
