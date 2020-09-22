package ro.itschool.helloWorldServer;

import ro.itschool.helloWorldServer.question.ConstantQuestionRepo;
import ro.itschool.helloWorldServer.question.JSONQuestionSerializer;
import ro.itschool.helloWorldServer.question.QuestionHandler;
import ro.itschool.helloWorldServer.router.Router;
import ro.itschool.server.Server;

public class Main {

	private static final String ROOT = "/\\S*";
	private static final String IMAGES = "/images/\\S*";
	private static final String JAVASCRIPT = "/js/\\S*";
	private static final String CSS = "/css/\\S*";

	public static void main(String[] args) {
		Router r = new Router();
		r.addRoute("/questions/\\S+", new QuestionHandler(new ConstantQuestionRepo(), new JSONQuestionSerializer()));
		
		Server s = new Server(8080, r);
		s.start();
	}
}
