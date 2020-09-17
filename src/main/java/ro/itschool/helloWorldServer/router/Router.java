package ro.itschool.helloWorldServer.router;

import java.util.ArrayList;
import java.util.List;

import ro.itschool.server.Request;
import ro.itschool.server.RequestHandler;
import ro.itschool.server.Response;

public class Router implements RequestHandler {

	private final List<Route> routes;

	public Router() {
		routes = new ArrayList<Route>();
	}

	public void addRoute(String path, RequestHandler handler) {
		this.routes.add(new Route(path, handler));
	}

	public Response handle(Request req) {
		for (Route r : this.routes) {
			if (r.match(req)) {
				return r.handle(req);
			}
		}
		// Nothing Here....
		// This is not the request you're looking for....
		Response r = new Response();
		r.sendStatus(404);
		return r;
	}

}
