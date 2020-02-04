package fr.epita.quizmanager.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quizmanager.datamodel.MCQQuestion;

public class MCQQuestionJDBCDAO {

	public int create(MCQQuestion mcqQuestion) {

		PreparedStatement preparedStatement;
		try (Connection connection = getConnection()) {
			preparedStatement = connection
					.prepareStatement("INSERT INTO MCQQUESTIONS (CONTENT, DIFFICULTY) VALUES (?, ?)");
			preparedStatement.setString(1, mcqQuestion.getContent());
			preparedStatement.setInt(2, mcqQuestion.getDifficulty());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<MCQQuestion> search(String contentInQuestion, int searchedDifficulty) {

		try (Connection connection = getConnection()) {
			PreparedStatement prepareStatement = connection
					.prepareStatement("SELECT ID, CONTENT, DIFFICULTY FROM MCQQUESTIONS\r\n" + "WHERE "
							+ "	CONTENT LIKE ?" + "	AND DIFFICULTY < ?");
			prepareStatement.setString(1, "%" + contentInQuestion + "%");
			prepareStatement.setInt(2, searchedDifficulty);
			ResultSet result = prepareStatement.executeQuery();
			List<MCQQuestion> resultList = new ArrayList<>();
			while (result.next()) {
				int difficulty = result.getInt("DIFFICULTY");
				int id = result.getInt("ID");
				String content = result.getString("CONTENT");
				MCQQuestion currentQuestion = new MCQQuestion();
				currentQuestion.setDifficulty(difficulty);
				currentQuestion.setId(Long.valueOf(id));
				currentQuestion.setContent(content);
				resultList.add(currentQuestion);

			}
			return resultList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();

	}

	private static Connection getConnection() throws SQLException {
		// To connect to the database
		String url = "jdbc:h2:D:/eclipse-workspace/quizmanager";
		String user = "sa";
		String password = "";

		return DriverManager.getConnection(url, user, password);
	}
}
