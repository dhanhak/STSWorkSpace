package kh.spring.repositories;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.commons.EncryptionUtils;
import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insertMember(MemberDTO dto) {
		return mybatis.insert("Member.insertMember", dto);
	}
	
	public boolean isMember(String id) {
		return mybatis.selectOne("Member.isMember", id);
	}
	
//	public boolean loginMember(String userID, String userPW) {
//		Map<String, Object> param = new HashMap<>();
//		param.put("userID", userID);
//		param.put("userPW", userPW);
//		return mybatis.selectOne("Member.loginMember", param);
//	}
	
	public boolean loginMember(MemberDTO dto) throws Exception {
		dto.setPw(EncryptionUtils.sha512(dto.getPw()));
		return mybatis.selectOne("Member.loginMember", dto);
	}
	
	public int deleteMember(String loginId) {
		return mybatis.delete("Member.deleteMember", loginId);
	}
	
	public MemberDTO myInfo(String loginId) {
		return mybatis.selectOne("Member.myInfo", loginId);
	}
	
	public int updateMyInfo(MemberDTO dto) {
		return mybatis.update("Member.updateMyInfo", dto);
	}
	
}
