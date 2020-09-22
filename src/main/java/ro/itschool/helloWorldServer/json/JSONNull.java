package ro.itschool.helloWorldServer.json;

public class JSONNull implements JSONValue{
	
	public static final JSONValue Value = new JSONNull();
	
	private JSONNull() {}
	
	@Override
	public String toString() {
		return "null";
	}
	
}
