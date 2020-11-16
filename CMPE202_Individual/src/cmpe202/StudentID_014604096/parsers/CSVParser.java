package cmpe202.StudentID_014604096.parsers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import cmpe202.StudentID_014604096.CardDetails;
import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.InputDetails;
import cmpe202.StudentID_014604096.validation.AmexValidator;
import cmpe202.StudentID_014604096.validation.DiscoverValidator;
import cmpe202.StudentID_014604096.validation.MasterValidator;
import cmpe202.StudentID_014604096.validation.Validator;
import cmpe202.StudentID_014604096.validation.VisaValidator;

public class CSVParser extends FileParser{

	@Override
	public List<CardDetails> parseFile(String fileName) {
		
		String line = "";  
		String splitBy = ",";  
		List<CardDetails> listCC = new ArrayList<CardDetails>();
		List<CreditCard> inCreditList = new ArrayList<CreditCard>();
		try   
		{  
		//parsing a CSV file into BufferedReader class constructor  
		BufferedReader br = new BufferedReader(new FileReader(fileName));  
		while ((line = br.readLine()) != null)   //returns a Boolean value  
		{  
		String[] card = line.split(splitBy);    // use comma as separator  
		System.out.println(card[0] +  "   " + card[1] + "   " + card[2]);  
		
		String cardNumber = card[0];//reading logic
		Validator visaHandler = new VisaValidator();
		Validator masterHandler = new MasterValidator();
		Validator amexHandler = new AmexValidator();
		Validator discoverHandler = new DiscoverValidator();
		
		visaHandler.nextHandler(masterHandler);
		masterHandler.nextHandler(amexHandler);
		amexHandler.nextHandler(discoverHandler);
		
		CreditCard cc = new CreditCard();
		cc.setCardNumber(card[0]);
		cc.setExpirationDate(card[1]);
		cc.setNameOfCardHolder(card[2]);
		inCreditList.add(cc);
		cc = visaHandler.validate(cardNumber);
		CardDetails cd = new CardDetails();
		cd.setCardNumber(cardNumber);
		if(cc==null) {
			cd.setCardType("");
			cd.setIsError("Error");
		}else {
			cd.setCardType(cc.getCardType());
			cd.setIsError("No Error");
		}
		if(!cd.getCardNumber().equals("CardNumber"))
			listCC.add(cd);			
		}
		
		}   
		catch (IOException e)   
		{  
		e.printStackTrace();  
		}  
		//System.out.println(inCreditList);
		ObjectMapper mapper = new ObjectMapper();
		InputDetails id; 
        try {
        	id = new InputDetails();
        	id.setCclist(inCreditList);
            mapper.writeValue(new File("person.json"), id);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(id);
            
            System.out.println(jsonString);
            
            id = mapper.readValue(jsonString, InputDetails.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
		return listCC;
	}

//	@Override
//	public void writeToFile(List<CardDetails> c, String outputFileName) {
//		// TODO Auto-generated method stub
//		try {
//			File fout = new File(outputFileName);
//			FileOutputStream fos = new FileOutputStream(fout);
//		 
//			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
//		   
//			for (CardDetails cd: c) {
//				bw.write(cd.getCardNumber() + ',' + cd.getCardType() + ',' + cd.getIsError());
//				bw.newLine();
//			}
//		    
//			bw.close();
//	    }
//	    catch(Exception e)
//	    {
//	    	
//	    }
//	}



}
