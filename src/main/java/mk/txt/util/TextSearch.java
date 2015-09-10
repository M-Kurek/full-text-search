package mk.txt.util;

import java.util.*;
import java.util.regex.*;

public class TextSearch {
	
	public boolean foundAll(List<Pattern> patterns, String searchHere) {
		boolean found = true;
		for (Pattern pattern : patterns) {
			found &= pattern.matcher(searchHere).find();
		}
		return found;
	}

	public List<Pattern> createPatterns(String... words) {
		List<Pattern> patterns = new ArrayList<Pattern>();
		for (String word  : words) {
			patterns.add(Pattern.compile(word));
		}
		return patterns;
	}

}
