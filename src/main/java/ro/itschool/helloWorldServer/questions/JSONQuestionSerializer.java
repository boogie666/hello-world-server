package ro.itschool.helloWorldServer.questions;

import java.util.List;

import ro.itschool.helloWorldServer.json.JSONArray;
import ro.itschool.helloWorldServer.json.JSONNumber;
import ro.itschool.helloWorldServer.json.JSONObject;
import ro.itschool.helloWorldServer.json.JSONString;
import ro.itschool.helloWorldServer.model.Block;
import ro.itschool.helloWorldServer.model.Question;

public class JSONQuestionSerializer implements QuestionSerializer {

	@Override
	public String serialize(Question q) {
		JSONObject json = toJSONValue(q);
		return json.toString();
	}

	private JSONObject toJSONValue(Question q) {
		JSONObject json = new JSONObject();
		json.put("id", new JSONNumber(q.getId()));
		json.put("title", new JSONString(q.getTitle()));
		json.put("author", new JSONString(q.getAuthor()));
		json.put("explanation", new JSONString(q.getExplanation()));

		JSONArray blocks = new JSONArray();

		for (Block b : q.getBlocks()) {
			if (b.getType().equals("text")) {
				blocks.add(new JSONString(b.getCorrectAnswer()));
			} else {
				JSONObject blockJson = new JSONObject();
				blockJson.put("type", new JSONString(b.getType()));
				blockJson.put("correctAnswer", new JSONString(b.getCorrectAnswer()));
				JSONArray optionsJson = new JSONArray();
				for (String option : b.getOptions()) {
					optionsJson.add(new JSONString(option));
				}
				blockJson.put("options", optionsJson);
				blocks.add(blockJson);
			}
		}

		json.put("blocks", blocks);
		return json;
	}

	@Override
	public String getContentType() {
		return "application/json";
	}

	@Override
	public String serializeAll(List<Question> qs) {
		JSONArray arr = new JSONArray();
		for(Question q : qs) {
			arr.add(toJSONValue(q));
		}
		return arr.toString();
	}

}
