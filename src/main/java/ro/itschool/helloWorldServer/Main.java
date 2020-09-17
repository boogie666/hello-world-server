package ro.itschool.helloWorldServer;

import ro.itschool.helloWorldServer.json.JSONNumber;
import ro.itschool.helloWorldServer.json.JSONObject;
import ro.itschool.helloWorldServer.json.JSONString;

public class Main {

	private static final String ROOT = "/\\S*";
	private static final String IMAGES = "/images/\\S*";
	private static final String JAVASCRIPT = "/js/\\S*";
	private static final String CSS = "/css/\\S*";

	public static void main(String[] args) {
		JSONObject obj = new JSONObject();
		obj.put("nume", new JSONString("Boogie"));
		obj.put("varsta", new JSONNumber(30));
		
		System.out.println(obj);
	}
}
