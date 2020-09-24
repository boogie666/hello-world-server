package ro.itschool.helloWorldServer.questions;

import java.util.List;

import ro.itschool.helloWorldServer.model.Question;
import ro.itschool.server.Request;
import ro.itschool.server.RequestHandler;
import ro.itschool.server.Response;

public class QuestionListHandler implements RequestHandler {
	private QuestionDataSource dataSource;
	private QuestionSerializer serializer;

	public QuestionListHandler(QuestionDataSource dataSource, QuestionSerializer serializer) {
		this.dataSource = dataSource;
		this.serializer = serializer;
	}

	@Override
	public Response handle(Request req) {
		List<Question> qs = dataSource.getAll();
		String result = serializer.serializeAll(qs);

		Response r = new Response();
		r.send(result);
		r.sendHeader("Content-Type", serializer.getContentType());
		r.sendStatus(200);
		return r;
	}

}
