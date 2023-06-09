package kh.spring.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MoviesDTO;

@Repository
public class MoviesDAO {


	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int insert(MoviesDTO dto) {
		return mybatis.insert("Movies.insert", dto);	
	}
	
	public int insertTwoDTO(MoviesDTO dto1, MoviesDTO dto2) {
		Map<String, MoviesDTO> param = new HashMap<String, MoviesDTO>();
		param.put("dto1", dto1);
		param.put("dto2", dto2);
		return mybatis.insert("Movies.insertTwoDTO", param);
	}
	
	public List<MoviesDTO> selectAll(){
		return mybatis.selectList("Movies.selectAll");
	}
	
	public int delete(int id) {
		return mybatis.delete("Movies.delete", id);
	}
	
	public int update(MoviesDTO dto) {
		return mybatis.update("Movies.update", dto);
	}
	
	public MoviesDTO selectById(int id) {
		return mybatis.selectOne("Movies.selectById", id);
	}

	public List<MoviesDTO> selectByCon(String column, String value) {
		Map<String, String> param = new HashMap<>();
		param.put("column", column);
		param.put("value", value);
		
		return mybatis.selectList("Movies.selectByCon", param);
	}

	public List<MoviesDTO> selectByMultiCon(MoviesDTO dto) {
		return mybatis.selectList("Movies.selectMultiByCon", dto);
	}

	public int insertHistory(MoviesDTO dto) {
		return mybatis.insert("Movies.insertHistory", dto);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private final static String INSERT_SQL = "INSERT INTO movies VALUES(?,?,?)";
//	private final static String SELECT_ALL_SQL = "SELECT * FROM movies";
//	private final static String DELETE_SQL = "DELETE FROM movies WHERE id = ?";
//	private final static String UPDATE_SQL = "UPDATE movies SET title = ?, genre = ? WHERE id = ?";
//	private final static String SELECT_BY_ID_SQL = "SELECT * FROM movies WHERE id = ?";
//	private final static String SELECT_COUNT_SQL = "SELECT COUNT(*) FROM movies";
	
//	@Autowired
//	private JdbcTemplate jdbc;
//
//	public int insert(MoviesDTO dto) throws SQLException {
//		return jdbc.update(INSERT_SQL, dto.getId(), dto.getTitle(), dto.getGenre());
//	}
//
//	public int delete(int id) throws SQLException {
//		return jdbc.update(DELETE_SQL, id);
//	}
//
//	public int update(MoviesDTO dto) throws SQLException {
//		return jdbc.update(UPDATE_SQL, dto.getTitle(), dto.getGenre(), dto.getId());
//	}
//	
//	public List<MoviesDTO> selectAll(){
//		return jdbc.query(SELECT_ALL_SQL, new BeanPropertyRowMapper<MoviesDTO>(MoviesDTO.class));
//	}
//	
//	public MoviesDTO selectById(int id) {
//		return jdbc.queryForObject(SELECT_BY_ID_SQL, new BeanPropertyRowMapper<MoviesDTO>(MoviesDTO.class), id);
//	}
//	
//	public int selectCount() {
//		return jdbc.queryForObject(SELECT_COUNT_SQL, Integer.class);
//	}

//	public List<MoviesDTO> selectAll() {
//	return jdbc.query(SELECT_ALL_SQL, new RowMapper<MoviesDTO>() {
//		public MoviesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//			int id = rs.getInt("id");
//			String title = rs.getString("title");
//			String genre = rs.getString("genre");
//
//			return new MoviesDTO(id, title, genre);
//		}
//	});
//}

//	@Autowired
//	private DataSource ds;
//
//	public int insert(MoviesDTO dto) throws SQLException {
//		try (Connection connection = ds.getConnection()) {
//			try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
//				preparedStatement.setInt(1, dto.getId());
//				preparedStatement.setString(2, dto.getTitle());
//				preparedStatement.setString(3, dto.getGenre());
//
//				return preparedStatement.executeUpdate();
//			}
//		}
//	}
//
//	public List<MoviesDTO> selectAll() throws SQLException {
//		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
//		try (Connection connection = ds.getConnection()) {
//			try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL)) {
//				try (ResultSet resultSet = preparedStatement.executeQuery()) {
//					while (resultSet.next()) {
//						int id = Integer.parseInt(resultSet.getString("id"));
//						String title = resultSet.getString("title");
//						String genre = resultSet.getString("genre");
//						MoviesDTO dto = new MoviesDTO(id, title, genre);
//						list.add(dto);
//					}
//					return list;
//				}
//			}
//		}
//	}
//
//	public int delete(int deleteID) throws SQLException {
//		try (Connection connection = ds.getConnection()) {
//			try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
//				preparedStatement.setInt(1, deleteID);
//
//				return preparedStatement.executeUpdate();
//			}
//		}
//	}
//
//	public int update(MoviesDTO dto) throws SQLException {
//		try (Connection connection = ds.getConnection()) {
//			try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
//				preparedStatement.setString(1, dto.getTitle());
//				preparedStatement.setString(2, dto.getGenre());
//				preparedStatement.setInt(3, dto.getId());
//
//				return preparedStatement.executeUpdate();
//			}
//		}
//	}

}
