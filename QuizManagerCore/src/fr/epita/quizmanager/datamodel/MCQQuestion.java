package fr.epita.quizmanager.datamodel;

import java.util.ArrayList;
import java.util.List;

public class MCQQuestion {
	private Long id;
	private String content;
	private Integer difficulty;
	private String[] topics;
	private List<MCQChoice> choices = new ArrayList<MCQChoice>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public String[] getTopics() {
		return topics;
	}

	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	public List<MCQChoice> getChoices() {
		return choices;
	}

	public void setChoices(List<MCQChoice> choices) {
		this.choices = choices;
	}
	
	public MCQQuestion() {

	}
}
