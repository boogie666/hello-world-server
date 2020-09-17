package ro.itschool.helloWorldServer.files;

import java.io.File;

import ro.itschool.server.Request;
import ro.itschool.server.RequestHandler;
import ro.itschool.server.Response;

public class FileHandler implements RequestHandler {

	private final String prefix;

	public FileHandler(String prefix) {
		this.prefix = prefix;
	}

	public Response handle(Request req) {
		Response r = new Response();
		String path = req.getPath();
		if (path.equals("/")) {
			path = "/index.html";
		}
		File f = new File(this.prefix + path);
		if (f.exists()) {
			r.sendStatus(200);
			r.send(f);
		} else {
			r.sendStatus(404);
		}
		return r;
	}

}
