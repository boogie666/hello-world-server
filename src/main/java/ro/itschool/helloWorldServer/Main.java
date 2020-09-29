package ro.itschool.helloWorldServer;

import ro.itschool.helloWorldServer.questions.ConstantQuestionDataSource;
import ro.itschool.helloWorldServer.questions.JSONQuestionSerializer;
import ro.itschool.helloWorldServer.questions.QuestionDataSource;
import ro.itschool.helloWorldServer.questions.QuestionHandler;
import ro.itschool.helloWorldServer.questions.QuestionListHandler;
import ro.itschool.helloWorldServer.questions.QuestionSerializer;
import ro.itschool.helloWorldServer.router.Router;
import ro.itschool.server.Server;

public class Main {

	public static void main(String[] args) {
		final Router r = new Router();

		final QuestionDataSource ds = new ConstantQuestionDataSource();
		final QuestionSerializer serializer = new JSONQuestionSerializer();
		r.addRoute("/questions/\\d+", new QuestionHandler(ds, serializer));
		r.addRoute("/questions", new QuestionListHandler(ds, serializer));

		final Server s = new Server(8080, r);
		s.start();
	}
}
