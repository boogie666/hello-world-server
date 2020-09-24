package ro.itschool.helloWorldServer.questions;

import java.util.List;

import ro.itschool.helloWorldServer.model.Question;

public interface QuestionSerializer {
	String serialize(Question q);
	String serializeAll(List<Question> qs);
	String getContentType();
}
