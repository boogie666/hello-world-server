package ro.itschool.helloWorldServer.question;

import ro.itschool.helloWorldServer.question.model.Question;
import ro.itschool.server.Request;
import ro.itschool.server.RequestHandler;
import ro.itschool.server.Response;

public class QuestionHandler implements RequestHandler {

	private final QuestionSerializer serializer;
	private final QuestionRepository repo;

	public QuestionHandler(QuestionRepository repo, QuestionSerializer serializer) {
		this.serializer = serializer;
		this.repo = repo;
	}

	@Override
	public Response handle(Request req) {
		Integer questionId = extractId(req.getPath());
		Response r = new Response();

		if (questionId == null) {
			r.sendStatus(500);
			r.send("Can't extract id from " + req.getPath());
		} else {
			Question q = this.repo.getById(questionId);

			if (q == null) { 
				r.sendStatus(404);
			} else {
				r.sendHeader("Content-Type", serializer.getContentType());
				r.send(serializer.serialize(q));
			}
		}
		return r;
	}

	private Integer extractId(String path) {
		String[] parts = path.split("/");
		try {
			return Integer.parseInt(parts[parts.length - 1]);
		}catch (Exception e) {
			return null;
		}
	}

}
