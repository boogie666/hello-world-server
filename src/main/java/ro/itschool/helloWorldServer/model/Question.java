package ro.itschool.helloWorldServer.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private int id;
	private String title;
	private String author;
	private String explanation;
	private List<Block> blocks;

	public Question() {
		this.blocks = new ArrayList<Block>();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public void addBlock(Block b) {
		this.blocks.add(b);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
