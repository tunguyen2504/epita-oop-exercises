package fr.epita.quizmanager.tests;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import fr.epita.quizmanager.datamodel.MCQQuestion;
import fr.epita.quizmanager.datamodel.MCQQuestionCSVDAO;

public class TestMCQQuestionCSVDAO {

	public static void main(String[] args) throws FileNotFoundException {
		MCQQuestionCSVDAO dao = new MCQQuestionCSVDAO();

		MCQQuestion mcqQuestion = new MCQQuestion();
		mcqQuestion.setDifficulty(3);
		mcqQuestion.setContent("What can we do with JDK?");
		mcqQuestion.setTopics(new String[] { "java", "compilation", "environments" });
		mcqQuestion.setId(1l);

		dao.createQuestionFile(mcqQuestion);
		
		mcqQuestion.setDifficulty(5);
		mcqQuestion.setContent("What can we do with SDK?");
		mcqQuestion.setTopics(new String[] {"compilation", "environments" });
		mcqQuestion.setId(2l);
		
		dao.createQuestionFile(mcqQuestion);

		List<MCQQuestion> allQuestions = dao.readAllQuestions();
		
		for (MCQQuestion question : allQuestions) {
			System.out.println(question.getId() + ". " + question.getContent());
			System.out.println("Topics: ");
			System.out.println(Arrays.asList(question.getTopics()));
			for (String topic : question.getTopics()) {
				System.out.print(topic + " ");
			}
			System.out.println("\n");
		}
	}
}
