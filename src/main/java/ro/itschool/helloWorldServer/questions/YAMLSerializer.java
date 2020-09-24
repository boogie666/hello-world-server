package ro.itschool.helloWorldServer.questions;

import java.util.List;

import ro.itschool.helloWorldServer.model.Block;
import ro.itschool.helloWorldServer.model.Question;

public class YAMLSerializer implements QuestionSerializer {

	@Override
	public String serialize(Question q) {
		String result = "---\n";
		result += "id: " + q.getId() + "\n";
		result += "title: " + q.getTitle() + "\n";
		result += "author: " + q.getAuthor() + "\n";
		result += "blocks:\n";
		for(Block b : q.getBlocks()) {
			if(b.getType().equals("text")) {
				result += "- " + b.getCorrectAnswer();
			}else {
				result += "- " + "type: " + b.getType() + "\n";
				result += "- " + "correctAnswer: " + b.getCorrectAnswer() + "\n";
				result += "  " + "options: " + "\n";
				for(String o : b.getOptions()) {
					result += "  - " + o + "\n";
				}
				
			}
			result += "\n";
		}
		
		
		return result;
	}

	@Override
	public String getContentType() {
		return "text/plain";
	}

	@Override
	public String serializeAll(List<Question> qs) {
		// TODO Auto-generated method stub
		return null;
	}

}
