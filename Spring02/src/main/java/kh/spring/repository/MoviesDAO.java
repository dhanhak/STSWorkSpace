package kh.spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.spring.dto.MoviesDTO;

@Repository
public class MoviesDAO {

	private final static String INSERT_SQL = "INSERT INTO movies VALUES(?,?,?)";
	private final static String SELECT_ALL_SQL = "SELECT * FROM movies";

	@Autowired
	private DataSource ds;

	public int insert(MoviesDTO dto) throws SQLException {
		try (Connection connection = ds.getConnection()) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL)) {
				preparedStatement.setInt(1, dto.getId());
				preparedStatement.setString(2, dto.getTitle());
				preparedStatement.setString(3, dto.getGenre());

				return preparedStatement.executeUpdate();
			}
		}
	}

	public List<MoviesDTO> selectAll() throws SQLException {
		List<MoviesDTO> list = new ArrayList<MoviesDTO>();
		try (Connection connection = ds.getConnection()) {
			try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL)) {
				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						int id = Integer.parseInt(resultSet.getString("id"));
						String title = resultSet.getString("title");
						String genre = resultSet.getString("genre");
						MoviesDTO dto = new MoviesDTO(id, title, genre);
						list.add(dto);
					}
					return list;
				}
			}
		}
	}

}
