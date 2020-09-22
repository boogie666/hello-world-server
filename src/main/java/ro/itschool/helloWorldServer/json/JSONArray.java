package ro.itschool.helloWorldServer.json;

import java.util.ArrayList;
import java.util.List;

public class JSONArray implements JSONValue {
	private final List<JSONValue> values;

	public JSONArray() {
		this.values = new ArrayList<JSONValue>();
	}

	public JSONArray add(JSONValue v) {
		if (v == null) {
			this.values.add(JSONNull.Value);
		} else {
			this.values.add(v);
		}
		return this;
	}

	public JSONArray add(String v) {
		return this.add(new JSONString(v));
	}

	public JSONArray add(double v) {
		return this.add(new JSONNumber(v));
	}

	public JSONArray add(int v) {
		return this.add(new JSONNumber(v));
	}

	public JSONArray add(boolean v) {
		return this.add(new JSONBoolean(v));
	}

	public JSONArray remove(JSONValue v) {
		this.values.remove(v);
		return this;
	}

	public static JSONArray from(List<JSONValue> values) {
		JSONArray arr = new JSONArray();
		for (JSONValue v : values) {
			arr.add(v);
		}
		return arr;
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
