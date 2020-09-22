package ro.itschool.helloWorldServer.question.model;

import java.util.ArrayList;
import java.util.List;

import ro.itschool.helloWorldServer.json.JSONArray;
import ro.itschool.helloWorldServer.json.JSONObject;
import ro.itschool.helloWorldServer.json.JSONValue;

public class Question{
	private final int id;
	private final String title;
	private final String author;
	private final List<Block> blocks;
	
	public Question(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.blocks = new ArrayList<Block>();
	}

	public Question(int id, String title) {
		this(id, title, null);
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public List<Block> getBlocks() {
		return blocks;
	}
	
	
	public Question addBlock(Block b) {
		this.blocks.add(b);
		return this;
	}
	
}
