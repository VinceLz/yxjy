package util;

import java.util.List;

public class StringUtil {
	public static String listToString(List<String> list, String separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) {
				sb.append(list.get(i).substring(5, list.get(i).length()));
			} else {
				sb.append(list.get(i).substring(5, list.get(i).length())).append(separator);
			}

		}
		return sb.toString();
	}
}