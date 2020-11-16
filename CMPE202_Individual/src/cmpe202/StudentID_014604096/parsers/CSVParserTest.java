package cmpe202.StudentID_014604096.parsers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CSVParserTest {

	@Test
	void testParseFile() {
		CSVParser parser = new CSVParser();
		assertNotNull(parser.parseFile("Sample.csv"));
	}

}
