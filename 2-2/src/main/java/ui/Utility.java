package ui;

import org.apache.commons.lang3.StringUtils;

public class Utility {

	public static boolean isSmallLength(String name, String fieldName, int length) {

		if (name == null)
			return true;
		if (length < name.length()) {
			System.out.printf("%s는 %s문자 이하로 입력하세요. \n", fieldName, length);
			return false;
		}
		return true;
	}

	public static boolean isNumeric(String str, String fieldName) {

		if (!StringUtils.isNumeric(str)) {
			System.out.printf("%s는 숫자로 입력하세요.\n", fieldName);
			return false;
		}
		return true;
	}
}
