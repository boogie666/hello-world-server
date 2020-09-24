package ro.itschool.helloWorldServer.questions;

import java.util.List;

import ro.itschool.helloWorldServer.model.Question;

public interface QuestionDataSource {
	Question getById(int id);
	List<Question> getAll();
}
