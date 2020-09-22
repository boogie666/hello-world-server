package ro.itschool.helloWorldServer.question;

import ro.itschool.helloWorldServer.json.JSONArray;
import ro.itschool.helloWorldServer.json.JSONObject;
import ro.itschool.helloWorldServer.json.JSONString;
import ro.itschool.helloWorldServer.json.JSONValue;
import ro.itschool.helloWorldServer.question.model.Block;
import ro.itschool.helloWorldServer.question.model.Question;

public class JSONQuestionSerializer implements QuestionSerializer {

	@Override
	public String getContentType() {
		return "application/json";
	}
	
	@Override
	public String serialize(Question q) {
		return serializeQuestion(q).toString();
	}

	private JSONObject serializeQuestion(Question q) {
		JSONObject obj = new JSONObject();
		obj.put("id", q.getId());
		obj.put("author", q.getAuthor());
		obj.put("title", q.getTitle());
		obj.put("blocks", serializeBlocks(q));
		return obj;
	}

	private JSONArray serializeBlocks(Question q) {
		JSONArray blocks = new JSONArray();
		for (Block b : q.getBlocks()) {
			if (b.getType().equals("text")) {
				blocks.add(serializeTextBlock(b));
			} else {
				blocks.add(serializeChoiceBlock(b));
			}
		}
		return blocks;
	}

	private JSONValue serializeTextBlock(Block b) {
		return new JSONString(b.getCorrectAnswer());
	}

	private JSONValue serializeChoiceBlock(Block b) {
		JSONObject block = new JSONObject();
		block.put("name", b.getName());
		block.put("type", b.getType());
		JSONArray options = new JSONArray();
		for (String option : b.getOptions()) {
			options.add(option);
		}
		block.put("options", options);
		block.put("correctAnswer", serializeTextBlock(b));
		return block;
	}

}
