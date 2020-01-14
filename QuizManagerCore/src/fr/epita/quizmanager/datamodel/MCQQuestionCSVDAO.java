package fr.epita.quizmanager.datamodel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MCQQuestionCSVDAO {

//	private static final String TOPIC_DELIMITER = "||||";
	private static final String TOPIC_DELIMITER = "@@@@";
	private static final String COLUMN_DELIMITER = "####";
	private static final String CHOICE_DELIMITER = "%%%";

	private File file = new File("/temp/questions.csv");
	private PrintWriter writer;

	public File getFile() {
		return file;
	}

	public MCQQuestionCSVDAO() {
		try {
			this.writer = new PrintWriter(new FileOutputStream(this.file, true));
		} catch (FileNotFoundException e) {

		}
	}

	public void createQuestionFile(MCQQuestion mcqQuestion) {
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

		List<MCQChoice> choices = mcqQuestion.getChoices();
		for (int i = 0; i < choices.size(); i++) {
			if (i == choices.size() - 1) {
				formatted += choices.get(i).getChoice() + COLUMN_DELIMITER;
			} else {
				formatted += choices.get(i).getChoice() + CHOICE_DELIMITER;
			}
		}

		// TODO write the formatted into a file
		this.writer.println(formatted);
		this.writer.flush();
		
		this.writer.close();
	}

	public List<MCQQuestion> readAllQuestions() throws FileNotFoundException {

		List<MCQQuestion> results = new ArrayList<MCQQuestion>();

		// TODO read all the line from the file
		Scanner scanner = new Scanner(this.file);
		String line = "";
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			String[] parts = line.split(COLUMN_DELIMITER);

			Long id = Long.valueOf(parts[0]);
			Integer difficulty = Integer.valueOf(parts[1]);
			String content = parts[2];
			String[] readTopics = parts[3].split(TOPIC_DELIMITER);
			String[] readChoices = parts[4].split(CHOICE_DELIMITER);
			List<MCQChoice> choices = new ArrayList<MCQChoice>();

			for (int i = 0; i < readChoices.length; i++) {
				MCQChoice choice = new MCQChoice();
				choice.setChoice(readChoices[i]);
				choices.add(choice);
			}

			//Reconstruct data read from the file
			MCQQuestion reconstruction = new MCQQuestion();
			reconstruction.setDifficulty(difficulty);
			reconstruction.setContent(content);
			reconstruction.setTopics(readTopics);
			reconstruction.setChoices(choices);
			reconstruction.setId(id);

			results.add(reconstruction);
		}

		scanner.close();
		return results;
	}

}
