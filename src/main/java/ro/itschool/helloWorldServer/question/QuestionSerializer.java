package ro.itschool.helloWorldServer.question;

import ro.itschool.helloWorldServer.question.model.Question;

public interface QuestionSerializer {
	String serialize(Question q);

	String getContentType();
}
