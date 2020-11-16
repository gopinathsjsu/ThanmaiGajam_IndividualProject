package cmpe202.StudentID_014604096.parsers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import cmpe202.StudentID_014604096.CardDetails;
import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.validation.AmexValidator;
import cmpe202.StudentID_014604096.validation.DiscoverValidator;
import cmpe202.StudentID_014604096.validation.MasterValidator;
import cmpe202.StudentID_014604096.validation.Validator;
import cmpe202.StudentID_014604096.validation.VisaValidator;

public class XMLParser extends FileParser{

	@Override
	public List<CardDetails> parseFile(String fileName) {
		List<CardDetails> listCC = new ArrayList<CardDetails>();
		try {
		File xmlFile = new File(fileName);

	    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
	    org.w3c.dom.Document document = documentBuilder.parse(xmlFile);

	    Node rootNode = document.getDocumentElement();
	    //System.out.println(rootNode.getBaseURI());
	    NodeList list = document.getElementsByTagName("row");
	   // NodeList list = rootNode.getChildNodes();
	    List<CreditCard> creditCards = new ArrayList<>();
	   // System.out.println(list.getLength());
	    for (int i = 0; i < list.getLength(); i++) {

	        Node node = list.item(i);

	        if (node.getNodeType() == Node.ELEMENT_NODE) {

	            Element element = (Element) node;
	            
	            CreditCard cc = new CreditCard();
	           // System.out.println(element.toString());
	            cc.setCardNumber(element.getElementsByTagName("CardNumber").item(0).getTextContent());
	            cc.setExpirationDate(element.getElementsByTagName("ExpirationDate").item(0).getTextContent());
	            cc.setNameOfCardHolder(element.getElementsByTagName("NameOfCardholder").item(0).getTextContent());
	            
	            creditCards.add(cc);
	        }
	    }

	    // at this point we have a list of developers

	    // print out all the developers
	    for (CreditCard cc : creditCards) {
	    	Validator visaHandler = new VisaValidator();
			Validator masterHandler = new MasterValidator();
			Validator amexHandler = new AmexValidator();
			Validator discoverHandler = new DiscoverValidator();
			
			visaHandler.nextHandler(masterHandler);
			masterHandler.nextHandler(amexHandler);
			amexHandler.nextHandler(discoverHandler);
			CreditCard cc1;
			cc1 = visaHandler.validate(cc.getCardNumber());
			CardDetails cd = new CardDetails();
			cd.setCardNumber(cc.getCardNumber());
			if(cc1==null) {
				cd.setCardType("");
				cd.setIsError("Error");
			}else {
				cd.setCardType(cc1.getCardType());
				cd.setIsError("No Error");
			}
			
			listCC.add(cd);		
	    }
	    System.out.println(listCC);
	    return listCC;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}



}
