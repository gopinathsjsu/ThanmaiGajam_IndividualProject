package cmpe202.StudentID_014604096.parsers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class XMLParserTest {

	@Test
	void testXmltoJava() {
		XMLParser parser = new XMLParser();
		assertNotNull(parser.parseFile("Sample.xml"));
		
	}

}
