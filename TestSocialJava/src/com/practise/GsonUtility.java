package com.practise;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GsonUtility {
	//static String className = "com.practise.GsonUtility";
	//static Gson gson = new Gson();

	/*public static String tojson(Object object) {
		System.out.println("\n\n"+gson.toJson(object));
		return gson.toJson(object);
	}*/

	/*public static String getFbAccessTokenFromJson(String j) {
		JsonObject json = (JsonObject) new JsonParser().parse(j);
		JsonObject authr = (JsonObject) json.get("authResponse");
		String act = authr.get("access_token").getAsString();
		return act;
	}
	*/

	public static String getJsonElementString(String name, String gs) {
		try {
			JsonObject json = (JsonObject) new JsonParser().parse(gs);
			System.out.println(json.get(name).getAsString());
			return json.get(name).getAsString();
		} catch (Exception localException) {
		}
		return null;
	}
	/*public static String getElementString(String string, String line1) {
		if (line1.indexOf(string) != -1) {
			int k = string.length();
			return line1.substring(k + 1, line1.indexOf("&"));
		}
		return line1;
	}*/
}
