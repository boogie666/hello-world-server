package ro.itschool.helloWorldServer.question;

import java.util.Arrays;

import ro.itschool.helloWorldServer.question.model.Block;
import ro.itschool.helloWorldServer.question.model.Question;

public class ConstantQuestionRepo implements QuestionRepository{

	@Override
	public Question getById(int id) {
		Question q = new Question(id, "Hello world", "Boogie");
		q.addBlock(Block.text("This is a hello world question\n"));
		q.addBlock(Block.combo("hello_option", Arrays.asList("Hello", "World", "Some other option..."), "Hello"));
		q.addBlock(Block.text("This is the end of the hello world question..."));
		return q;
	}

}
