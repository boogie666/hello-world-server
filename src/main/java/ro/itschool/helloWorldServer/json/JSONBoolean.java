package ro.itschool.helloWorldServer.json;

public class JSONBoolean implements JSONValue{
	private final boolean val;
	public JSONBoolean(boolean val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		return this.val ? "true" : "false";
	}
	
}
