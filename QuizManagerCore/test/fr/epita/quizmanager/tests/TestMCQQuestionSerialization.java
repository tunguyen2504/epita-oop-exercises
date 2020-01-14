package fr.epita.quizmanager.tests;

import java.util.Arrays;

import fr.epita.quizmanager.datamodel.MCQQuestion;

public class TestMCQQuestionSerialization {
	
	private static final String TOPIC_DELIMITER = "||||";
	private static final String COLUMN_DELIMITER = "####";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MCQQuestion mcqQuestion = new MCQQuestion();
		mcqQuestion.setDifficulty(3);
		mcqQuestion.setContent("What can we do with JDK?");
		mcqQuestion.setTopics(new String[] { "java", "compilation", "environments" });
		mcqQuestion.setId(1l);

		// Formating to CSV
		// id; difficulty; content; topics
		String formatted = String.valueOf(mcqQuestion.getId()) + COLUMN_DELIMITER;
		formatted += String.valueOf(mcqQuestion.getDifficulty()) + COLUMN_DELIMITER + mcqQuestion.getContent()
				+ COLUMN_DELIMITER;

		String[] topics = mcqQuestion.getTopics();

		for (int i = 0; i < topics.length; i++) {
			if (i == topics.length - 1) {
				formatted += topics[i] + COLUMN_DELIMITER;
			} else {
				formatted += topics[i] + TOPIC_DELIMITER;
			}
		}

		System.out.println("formatted");
		System.out.println(formatted);
		String[] parts = formatted.split(COLUMN_DELIMITER);
		System.out.println(Arrays.asList(parts));
		Long id = Long.valueOf(parts[0]);
		Integer difficulty = Integer.valueOf(parts[1]);
		String content = parts[2];
		String[] readTopics = parts[3].split(TOPIC_DELIMITER);

		MCQQuestion reconstruction = new MCQQuestion();
		reconstruction.setDifficulty(difficulty);
		reconstruction.setContent(content);
		reconstruction.setTopics(readTopics);
		reconstruction.setId(id);

	}
}
