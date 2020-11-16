package cmpe202.StudentID_014604096;

import java.util.List;

import cmpe202.StudentID_014604096.parsers.CSVParser;
import cmpe202.StudentID_014604096.parsers.FileParser;
import cmpe202.StudentID_014604096.parsers.JSONParser;
import cmpe202.StudentID_014604096.parsers.Parser;
import cmpe202.StudentID_014604096.parsers.XMLParser;

public class MainClass {

	public static void main(String[] args) {
		
		Parser p = new Parser();
		String inputFileName = args[0];
		String outputFileName = args[1];
		System.out.println("Input File : " + inputFileName);
		System.out.println("Output File : " + outputFileName);
		
		if(inputFileName.endsWith(".xml")) {
			p.changeParser(new XMLParser());
		}
		else if(inputFileName.endsWith(".json")) {
			p.changeParser(new JSONParser());
		}
		else if(inputFileName.endsWith(".csv")) {
			p.changeParser(new CSVParser());
		}
		List<CardDetails> c = p.parseFile(inputFileName);
		p.writeToFile(c, outputFileName);
		
	}
}
