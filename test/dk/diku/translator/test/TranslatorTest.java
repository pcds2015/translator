package dk.diku.translator.test;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import dk.diku.translator.Translator;
import dk.diku.translator.impl.SimpleTranslator;

public class TranslatorTest extends TestCase {

	@Test
	public void testHorseGivesHest() {
		Translator translator = new SimpleTranslator();
		assertEquals("hest", translator.translate("horse"));
	}
	
	
}
