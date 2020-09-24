package ro.itschool.helloWorldServer.model;

import java.util.ArrayList;
import java.util.List;

public class Block {
	private String type;
	private List<String> options;
	private String correctAnswer;

	public Block() {
		this.options = new ArrayList<String>();
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getOptions() {
		return options;
	}

	public void addOptions(String option) {
		this.options.add(option);
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

}
