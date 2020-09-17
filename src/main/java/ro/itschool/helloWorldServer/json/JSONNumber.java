package ro.itschool.helloWorldServer.json;

public class JSONNumber implements JSONValue{
	private final double value;

	public JSONNumber(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

}
