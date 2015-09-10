package mk.txt.util;

import static org.junit.Assert.*;

import java.util.*; 
import java.util.regex.*;

import org.junit.Test;

public class TextSearchTest {

	private static final int WRD_CNT = 20;
	
	private TextSearch util = new TextSearch();

	@Test
	public void testFoundForAllOf2words() {

		StringBuilder buff = new StringBuilder(); 
		
		List<String> strList = new ArrayList<String>();
		for (int words=0; words < WRD_CNT; words++) {
			String nextWord = getWord();
			strList.add(nextWord);
			buff.append(nextWord + " ");
		}
		String phrase = buff.toString();
		
		List<Pattern> matchers = util.createPatterns(strList.get(2), strList.get(3));
		assertTrue(util.foundAll(matchers, phrase));
	}
	

	@Test
	public void testFoundForAllOf2wordsWhere2ndElse() {

		StringBuilder buff = new StringBuilder(); 
		
		List<String> strList = new ArrayList<String>();
		for (int words=0; words < WRD_CNT; words++) {
			String nextWord = getWord();
			strList.add(nextWord);
			buff.append(nextWord + " ");
		}
		String phrase = buff.toString();
		
		List<Pattern> matchers = util.createPatterns("a" + strList.get(2), strList.get(3));
		assertFalse(util.foundAll(matchers, phrase));
	}


	private String getWord() {
		int count = (new java.util.Random()).nextInt(8) + 3;
		return org.apache.commons.lang.RandomStringUtils.randomAlphabetic(count);
	}

}
