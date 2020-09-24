package ro.itschool.helloWorldServer.questions;

import ro.itschool.helloWorldServer.model.Question;
import ro.itschool.server.Request;
import ro.itschool.server.RequestHandler;
import ro.itschool.server.Response;

public class QuestionHandler implements RequestHandler {

	private QuestionDataSource dataSource;
	private QuestionSerializer serializer;

	public QuestionHandler(QuestionDataSource ds, QuestionSerializer s) {
		this.dataSource = ds;
		this.serializer = s;
	}

	public Response handle(Request req) {
		Question q = getQuestion(req);
		Response r = new Response();
		if (q != null) {
			sendQuestion(r, q);
		} else {
			r.sendStatus(404);
		}
		return r;
	}

	private void sendQuestion(Response r, Question q) {
		String serializedQuestion = this.serializer.serialize(q);
		r.sendHeader("Content-Type", this.serializer.getContentType());
		r.send(serializedQuestion);
		r.sendStatus(200);
	}

	private Question getQuestion(Request r) {
		String path = r.getPath();
		String[] pathParts = path.split("/");
		String idString = pathParts[pathParts.length - 1];
		try {
			Integer id = Integer.parseInt(idString);
			return dataSource.getById(id);
		} catch (Exception ex) {
			return null;
		}
	}

}
