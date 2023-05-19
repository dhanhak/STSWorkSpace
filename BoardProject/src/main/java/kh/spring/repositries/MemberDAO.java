package kh.spring.repositries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	private JdbcTemplate jdbc;
	
	private final static String INSERT_SQL = "INSERT INTO members VALUES(members_seq.nextval,?,?,?,?,?)";
	private final static String UPDATE_SQL = "UPDATE members SET name = ?, phone = ? WHERE id = ?";
	private final static String DELETE_SQL = "";
	private final static String SELECT_ALL_SQL = "SELECT * FROM members";
	private final static String SELECRT_BY_ID_SQL = "SELECT COUNT(*) FROM members WHERE id = ?";
	
	public int save(MemberDTO dto) {
		return jdbc.update(INSERT_SQL,dto.getId(),dto.getPassword(),dto.getName(),dto.getPhone(),dto.getEmail());
	}
	
	public int update(MemberDTO dto) {
		return jdbc.update(UPDATE_SQL, dto.getName(), dto.getPhone(), dto.getId());
	}
	
	public int delete(int id) {
		return jdbc.update(DELETE_SQL, id);
	}
	
	public List<MemberDTO> read(){
		return jdbc.query(SELECT_ALL_SQL, new BeanPropertyRowMapper<MemberDTO>(MemberDTO.class));
	}

	public boolean isMember(String id) {
		return jdbc.queryForObject(SELECRT_BY_ID_SQL, Boolean.class, id);
	}
}
