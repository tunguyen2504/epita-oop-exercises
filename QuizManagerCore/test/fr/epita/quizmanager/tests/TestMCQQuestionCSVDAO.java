package fr.epita.quizmanager.tests;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import fr.epita.quizmanager.datamodel.MCQQuestion;
import fr.epita.quizmanager.services.MCQQuestionCSVDAO;

public class TestMCQQuestionCSVDAO {

	public static void main(String[] args) throws FileNotFoundException {
		MCQQuestionCSVDAO dao = new MCQQuestionCSVDAO();

		MCQQuestion mcqQuestion = new MCQQuestion();
		mcqQuestion.setDifficulty(3);
		mcqQuestion.setContent("What can we do with JDK?");
		mcqQuestion.setTopics(new String[] { "java", "compilation", "environments" });
		mcqQuestion.setId(1l);

		//when
		dao.createQuestionFile(mcqQuestion);

		//then
		List<MCQQuestion> allQuestions = dao.readAllQuestions();
		MCQQuestion readQuestion = allQuestions.get(0);
		boolean success = readQuestion.getId().equals(mcqQuestion.getId());
		System.out.println("Success? " + success);
	}
}
