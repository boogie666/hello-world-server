package ro.itschool.helloWorldServer.json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JSONObject implements JSONValue{

	private final Map<JSONString, JSONValue> values;

	public JSONObject() {
		values = new HashMap<JSONString, JSONValue>();
	}

	public JSONObject put(JSONString key, JSONValue value) {
		if (value == null) {
			this.values.put(key, JSONNull.Value);
		} else {
			this.values.put(key, value);
		}
		return this;
	}

	public JSONObject put(String key, JSONValue value) {
		return this.put(new JSONString(key), value);
	}

	public JSONObject put(String key, String value) {
		return this.put(key, new JSONString(value));
	}

	public JSONObject put(String key, boolean value) {
		return this.put(key, new JSONBoolean(value));
	}

	public JSONObject put(JSONString key, double value) {
		return this.put(key, new JSONNumber(value));
	}
	
	public JSONObject put(String key, int value) {
		return this.put(key, new JSONNumber(value));
	}

	public JSONObject remove(String key) {
		this.values.remove(new JSONString(key));
		return this;
	}

	public JSONObject remove(JSONString key) {
		this.values.remove(key);
		return this;
	}
	
	@Override
	public String toString() {
		String stuff = "";
		Set<Map.Entry<JSONString, JSONValue>> pairs = this.values.entrySet();
		for (Map.Entry<JSONString, JSONValue> pair : pairs) {
			JSONString key = pair.getKey();
			JSONValue value = pair.getValue();
			stuff += key + ":" + value + ", ";
		}
		if (!this.values.isEmpty()) {
			stuff = stuff.substring(0, stuff.length() - 2);
		}
		return "{" + stuff + "}";
	}

	

}
