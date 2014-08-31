package utils;

public class StringUtils {

	public static String lowerCaseFirstOne(String s) {
		if (Character.isLowerCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	public static String upperCaseFirstOne(String s) {
		if (Character.isUpperCase(s.charAt(0)))
			return s;
		else
			return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
	}

	// /**
	// * 时间
	// */
	// public static Date parseDate(String dateStr){
	// Date date = null;
	// //Annum
	// Map<String,String> patternMap = new HashMap<String,String>();
	// patternMap.put("yyyy-MM-dd", "\\d{4}-\\d{2}-\\d{2}");
	// patternMap.put("yyyy-MM-dd HH:mm:ss",
	// "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
	// patternMap.put("yyyy-MM-dd HH:mm:ss.SSS",
	// "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d{3}");
	// for (Map.Entry<String, String> entry : patternMap.entrySet()){
	// if(dateStr.matches(entry.getValue())){
	// SimpleDateFormat sdf = new SimpleDateFormat(entry.getKey());
	// try {
	// date = sdf.parse(dateStr);
	// } catch (ParseException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	//
	// return date;
	// }
}
