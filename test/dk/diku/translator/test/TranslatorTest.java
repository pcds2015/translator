package dk.diku.translator.test;

import static org.junit.Assert.*;

import org.junit.Test;

import dk.diku.translator.Translator;
import dk.diku.translator.impl.SimpleTranslator;

public class TranslatorTest {

	@Test
	public void testHorseGivesHest() {
		Translator translator = new SimpleTranslator();
		assertEquals("hest", translator.translate("horse"));
	}

}
