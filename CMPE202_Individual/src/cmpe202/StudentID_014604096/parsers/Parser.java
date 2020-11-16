package cmpe202.StudentID_014604096.parsers;

import java.util.List;

import cmpe202.StudentID_014604096.CardDetails;

public class Parser {

	private FileParser parser;
	public void changeParser(FileParser parser) {
		this.parser = parser;
	}
	
	public List<CardDetails> parseFile(String fileName) {
		return parser.parseFile(fileName);
	}
	
	public String getParserName() {
		return parser.getClass().getSimpleName();
	}
	public void writeToFile(List<CardDetails> c, String outputFileName) {
		 parser.writeToFile(c, outputFileName);
	}
	

}
