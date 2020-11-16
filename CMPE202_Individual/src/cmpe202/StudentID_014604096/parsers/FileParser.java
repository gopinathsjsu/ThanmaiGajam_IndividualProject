package cmpe202.StudentID_014604096.parsers;

import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import cmpe202.StudentID_014604096.CardDetails;
import cmpe202.StudentID_014604096.InputDetails;
import cmpe202.StudentID_014604096.OutputDetails;

public abstract class FileParser {
	abstract List<CardDetails> parseFile(String fileName);
	public void writeToFile(List<CardDetails> c, String outputFileName) {
		// TODO Auto-generated method stub
		try {
			File fout = new File(outputFileName);
			FileOutputStream fos = new FileOutputStream(fout);
		 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		   
			if(outputFileName.endsWith(".xml")) {
				//p.changeParser(new XMLParser());
				 ByteArrayOutputStream baos = new ByteArrayOutputStream();
				    XMLEncoder xmlEncoder = new XMLEncoder(baos);
				    xmlEncoder.writeObject(c);
				    xmlEncoder.close();

				    String xml = baos.toString();
				    System.out.println(xml);

				    bw.write(xml);
			}
			else if(outputFileName.endsWith(".json")) {
				ObjectMapper mapper = new ObjectMapper();
				OutputDetails od; 
		        try {
		        	od = new OutputDetails();
		        	od.setCdList(c);
		        	//id.setCclist(inCreditList);
		            mapper.writeValue(new File("person.json"), od);
		            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(od.getCdList());
		            
		            //System.out.println(jsonString);
		            bw.write(jsonString);
		            //id = mapper.readValue(jsonString, InputDetails.class);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			}
			else if(outputFileName.endsWith(".csv")) {
				for (CardDetails cd: c) {
					bw.write(cd.getCardNumber() + ',' + cd.getCardType() + ',' + cd.getIsError());
					bw.newLine();
				}
			}
			
		    
			bw.close();
	    }
	    catch(Exception e)
	    {
	    	
	    }
	}

}
