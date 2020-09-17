package ro.itschool.helloWorldServer.router;

import ro.itschool.server.Request;
import ro.itschool.server.RequestHandler;
import ro.itschool.server.Response;

class Route {
	private final String path;
	private final RequestHandler handler;
	
	public Route(String path, RequestHandler handler) {
		this.path = path;
		this.handler = handler;
	}
	
	public boolean match(Request r) {
		return r.getPath().matches(this.path);
	}
	
	public Response handle(Request r) {
		return this.handler.handle(r);
	}
}
