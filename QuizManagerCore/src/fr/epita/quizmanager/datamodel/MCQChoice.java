package fr.epita.quizmanager.datamodel;

public class MCQChoice {
	private String choice;
	private boolean isCorrect;

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public MCQChoice() {

	}
}
