package ro.itschool.helloWorldServer.question;

import ro.itschool.helloWorldServer.question.model.Question;

public interface QuestionRepository {
	
	Question getById(int id);

}
