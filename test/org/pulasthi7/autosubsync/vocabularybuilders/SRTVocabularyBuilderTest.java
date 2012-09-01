package org.pulasthi7.autosubsync.vocabularybuilders;

import static org.junit.Assert.*;

import org.junit.Test;

public class SRTVocabularyBuilderTest {

	@Test
	public void testGetValidWords() {
		SRTVocabularyBuilder vocabularyBuilder = new SRTVocabularyBuilder();
		String input = "qkjdwefb hsf abndf asvd a  lews?ajf @daj saslwe.mv. ksdn's iesm";
		String[] expected = new String[] { "qkjdwefb", "hsf", "abndf", "asvd",
				"a", "lews", "ajf", "daj", "saslwe", "mv", "ksdn", "iesm" };
		assertArrayEquals(expected, vocabularyBuilder.getValidWords(input));
	}

}
