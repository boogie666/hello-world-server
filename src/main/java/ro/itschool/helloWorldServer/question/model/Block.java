package ro.itschool.helloWorldServer.question.model;

import java.util.Arrays;
import java.util.List;

public class Block {

	private final String name;
	private final String type;
	private final List<String> options;
	private final String correctAnswer;

	private Block(String name, String type, List<String> options, String correctAnswer) {
		this.name = name;
		this.type = type;
		this.options = options;
		this.correctAnswer = correctAnswer;
	}
	
	public static Block text(String text) {
		return new Block(null, "text", Arrays.asList(text), text);
	}

	public static Block combo(String name, List<String> options, String correctAnswer) {
		return new Block(name, "combo", options, correctAnswer);
	}
	
	
	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public List<String> getOptions() {
		return options;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

}
