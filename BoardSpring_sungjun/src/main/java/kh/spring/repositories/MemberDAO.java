package kh.spring.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MembersDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	public int join(MembersDTO dto) {
		String sql = "insert into members values (?,?,?,?,?,?,?,?,sysdate)";
		return jdbc.update(sql, dto.getId(),dto.getPw(),dto.getName(),dto.getPhone(),dto.getEmail(),dto.getZipcode(),
				dto.getAddress1(),dto.getAddress2());
		
	}

	public int IdCheck(String id) {
		String sql = "select id from members where id = ?";
		return jdbc.update(sql, id);
	}

	public boolean login(String id, String pw) {
		String sql = "select id,pw from members where id=? and pw=? ";
		int result = jdbc.update(sql, id, pw);
		if(result == 1) {
			return true;
		}else {
			return false;
		}
		
	}

	public int memberOut(String loginId) {
		String sql = "delete from members where id = ?";
		return jdbc.update(sql, loginId);
		
			
		}

	public MembersDTO memberInfo(String loginId) {
		String sql = "select * from members where id = ?";
		return jdbc.queryForObject(sql, new BeanPropertyRowMapper<MembersDTO>(MembersDTO.class), loginId);
	}

	public int updateMyInfo(MembersDTO dto) {
		String sql = "update members set name=?, phone=?, email=?, zipcode=?, address1=?, address2=? where id=?";
		
		return jdbc.update(sql, dto.getName(),dto.getPhone(),dto.getEmail(),dto.getZipcode(),dto.getAddress1(),dto.getAddress2(),dto.getId());
	}

		
	
	
	
	
}
