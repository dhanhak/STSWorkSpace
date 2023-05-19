package kh.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MessageDTO;
import oracle.jdbc.driver.Message;

@Repository
public class MessageDAO {
	
	private final static String INSERT_SQL = "INSERT INTO message VALUES(message_seq.nextval,?,?)";
	private final static String SELECT_ALL_SQL = "SELECT * FROM message";
	private final static String UPDATE_SQL = "UPDATE message SET writer = ?, message = ? WHERE seq = ?";
	private final static String DELETE_SQL = "DELETE FROM message WHERE seq = ?";
	
	@Autowired
	private JdbcTemplate jdbc;

	public int insert(MessageDTO dto) {
		return jdbc.update(INSERT_SQL, dto.getWriter(), dto.getMessage());
	}
	
	public int update(MessageDTO dto) {
		return jdbc.update(UPDATE_SQL, dto.getWriter(), dto.getMessage(), dto.getSeq());
	}
	
	public int delete(int id) {
		return jdbc.update(DELETE_SQL, id);
	}
	
	public List<MessageDTO> read(){
		return jdbc.query(SELECT_ALL_SQL, this::selectAll);
	}
	
	public List<MessageDTO> read(int id){
		return jdbc.query(SELECT_ALL_SQL, new BeanPropertyRowMapper<MessageDTO>(MessageDTO.class), id);
	}
	
	private MessageDTO selectAll(ResultSet resultSet, int rowNum) throws SQLException {
		return new MessageDTO(resultSet.getInt("seq"),resultSet.getString("writer"),resultSet.getString("message"));
	}
	
	
	
	
	
	
	
	
	
//	public int insert(MessageDTO dto) throws SQLException {
//		try (Connection connection = ds.getConnection()) {
//			try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
//				preparedStatement.setString(1, dto.getWriter());
//				preparedStatement.setString(2, dto.getMessage());
//				
//				return preparedStatement.executeUpdate();
//			}
//		}
//	}
//
//	public List<MessageDTO> read() throws SQLException {
//		List<MessageDTO> list = new ArrayList<MessageDTO>();
//		try (Connection connection = ds.getConnection()) {
//			try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL)) {
//				try (ResultSet resultSet = preparedStatement.executeQuery()){
//					while(resultSet.next()) {
//						int id = resultSet.getInt("seq");
//						String writer = resultSet.getString("writer");
//						String message = resultSet.getString("message");
//						MessageDTO msg = new MessageDTO(id,writer,message);
//						list.add(msg);
//					}
//					return list;
//				}
//			}
//		}
//	}
//	
//	public int delete(int id) throws SQLException {
//		try (Connection connection = ds.getConnection()) {
//			try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL)) {
//				preparedStatement.setInt(1, id);
//				
//				return preparedStatement.executeUpdate();
//			}
//		}
//	}
//	
//	public int update(MessageDTO dto) throws SQLException {
//		try (Connection connection = ds.getConnection()) {
//			try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL)) {
//				preparedStatement.setString(1, dto.getWriter());
//				preparedStatement.setString(2, dto.getMessage());
//				preparedStatement.setInt(3, dto.getSeq());
//				
//				return preparedStatement.executeUpdate();
//			}
//		}
//	}



}
