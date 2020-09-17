package ro.itschool.helloWorldServer;

import java.io.File;

import ro.itschool.server.Request;
import ro.itschool.server.RequestHandler;
import ro.itschool.server.Response;

public class HelloWorldHandler implements RequestHandler {

	public Response handle(Request req) {
		if (req.getPath().endsWith(".png")) {
			Response r = new Response();

			r.send(new File("public" + req.getPath()));

			return r;
		} else {
			Response r = new Response();
			
			r.send(new File("public/index.html"));
			
			return r;
		}
	}

}
