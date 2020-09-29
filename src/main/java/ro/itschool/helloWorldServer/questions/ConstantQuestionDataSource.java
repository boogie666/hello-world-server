package ro.itschool.helloWorldServer.questions;

import java.util.ArrayList;
import java.util.List;

import ro.itschool.helloWorldServer.model.Block;
import ro.itschool.helloWorldServer.model.Question;

public class ConstantQuestionDataSource implements QuestionDataSource{

	@Override
	public Question getById(int id) {
		Question q = new Question();
		q.setId(id);
		q.setTitle("Hello world");
		q.setAuthor("John Snow");
		q.setExplanation("No explanations needed");
		Block b = new Block();
		b.setType("text");
		b.setCorrectAnswer("Some text here");
		
		Block b2 = new Block();
		b2.setType("combo");
		b2.addOptions("A");
		b2.addOptions("B");
		b2.addOptions("C");
		b2.setCorrectAnswer("B");
		
		q.addBlock(b);
		q.addBlock(b2);
		
		return q;
	}

	@Override
	public List<Question> getAll() {
		List<Question> result = new ArrayList<Question>();
		for(int i = 0;i < 3; i++) {
			result.add(getById(i));
		}
		return result;
	}
	
	

}
