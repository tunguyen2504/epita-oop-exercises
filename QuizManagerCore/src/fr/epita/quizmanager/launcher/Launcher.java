package fr.epita.quizmanager.launcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.quizmanager.datamodel.MCQChoice;
import fr.epita.quizmanager.datamodel.MCQQuestion;
import fr.epita.quizmanager.services.MCQQuestionCSVDAO;

public class Launcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String option = "";
		Scanner scanner = new Scanner(System.in);

		while (!option.equals("3")) {
			createMenu(scanner);
			option = scanner.nextLine();
			switch (option) {
			case "1":
				createQuestions(scanner);
				break;
			case "2":
				quizView();
				break;
			case "3":
				System.out.println("Exit program...");
				break;
			default:
				System.out.println("Invalid option! Please choose again.");
				break;
			}
		}
		System.out.println("Goodbye!");
		scanner.close();
	}

	// To create main menu
	private static void createMenu(Scanner scanner) {
		System.out.println("\n----------QUIZ MANAGER----------");
		System.out.println("1. Create questions.");
		System.out.println("2. Quiz view.");
		System.out.println("3. Exit.");
		System.out.println("Please choose an option: ");
	}

	private static void createQuestions(Scanner scanner) {
		MCQQuestionCSVDAO dao = new MCQQuestionCSVDAO();

		String isContinue = "";
		Integer count = 1;
		File file = dao.getFile();
		do {
			System.out.println("\n-----Create questions-----");
			System.out.println("Enter question " + count);
			String content = scanner.nextLine();
			List<MCQChoice> mcqChoices = new ArrayList<MCQChoice>();
			String[] topics;
			System.out.println("Enter topics (Separated by comma): ");
			String topicsEnter = scanner.nextLine();
			topics = topicsEnter.split(",");

			for (char c = 'A'; c <= 'D'; c++) {
				System.out.println("Enter choice " + c);
				String choice = scanner.nextLine();
				System.out.println("Is it correct answer? (Y/N) ");
				Boolean isCorrect = scanner.nextLine().equalsIgnoreCase("y");
				MCQChoice mcqChoice = new MCQChoice();
				mcqChoice.setChoice(choice);
				mcqChoice.setCorrect(isCorrect);
				mcqChoices.add(mcqChoice);
			}

			System.out.println("Enter difficulty (1-5): ");
			String difficulty = scanner.nextLine();

			MCQQuestion mcqQuestion = new MCQQuestion();

			// Auto increment ID for question
			if (!file.exists()) {
				mcqQuestion.setId(1L);
			} else {
				try {
					long lineCount = Files.lines(Paths.get(file.getPath())).count(); // count the line number of file
					mcqQuestion.setId(lineCount + 1);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			mcqQuestion.setContent(content);
			mcqQuestion.setTopics(topics);
			mcqQuestion.setChoices(mcqChoices);
			mcqQuestion.setDifficulty(Integer.valueOf(difficulty));

			dao.createQuestionFile(mcqQuestion);

			System.out.println("Continue? (Y/N)");
			isContinue = scanner.nextLine();
			count++;
		} while (isContinue.equalsIgnoreCase("y"));
	}

	private static void quizView() {
		MCQQuestionCSVDAO dao = new MCQQuestionCSVDAO();

		System.out.println("\n-----Quiz View-----");
		List<MCQQuestion> mcqQuestionList = new ArrayList<MCQQuestion>();

		mcqQuestionList = dao.readAllQuestions();

		if (mcqQuestionList.size() != 0) {
			for (int i = 0; i < mcqQuestionList.size(); i++) {
				MCQQuestion question = mcqQuestionList.get(i);
				System.out.println("\nQuestion " + (i + 1));
				System.out.println(question.getContent());
				List<MCQChoice> choices = question.getChoices();
				char c = 'A';
				for (int j = 0; j < choices.size(); j++) {
					System.out.println(c + ". " + choices.get(j).getChoice());
					c++;
				}
			}
		} else {
			System.out.println("There is no question for the quiz. Please create.");
		}
	}
}
