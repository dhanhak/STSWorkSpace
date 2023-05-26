package kh.spring.repositories;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertMember(MemberDTO dto) {
		return mybatis.insert("Member.insert",dto);
	}
	
	public List<MemberDTO> selectAll(){
		return mybatis.selectList("Member.selectAll");
	}
}
