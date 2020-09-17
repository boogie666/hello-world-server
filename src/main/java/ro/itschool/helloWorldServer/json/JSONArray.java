package ro.itschool.helloWorldServer.json;

import java.util.ArrayList;
import java.util.List;

public class JSONArray implements JSONValue {
	private final List<JSONValue> values;

	public JSONArray() {
		this.values = new ArrayList<JSONValue>();
	}

	public JSONArray add(JSONValue v) {
		this.values.add(v);
		return this;
	}

	public JSONArray remove(JSONValue v) {
		this.values.remove(v);
		return this;
	}

	@Override
	public String toString() {
		String stuff = "";
		for (JSONValue v : this.values) {
			stuff += v.toString() + ", ";
		}
		if (!values.isEmpty()) {
			stuff = stuff.substring(0, stuff.length() - 2);
		}
		return "[" + stuff + "]";
	}
}
