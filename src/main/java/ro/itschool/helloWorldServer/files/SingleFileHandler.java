package ro.itschool.helloWorldServer.files;

import java.io.File;

import ro.itschool.server.Request;
import ro.itschool.server.RequestHandler;
import ro.itschool.server.Response;

public class SingleFileHandler implements RequestHandler {

	private final File file;
	
	
	public SingleFileHandler(File file) {
		this.file = file;
	}
	
	public Response handle(Request req) {
		Response r = new Response();
		r.send(file);
		return r;
	}

}
