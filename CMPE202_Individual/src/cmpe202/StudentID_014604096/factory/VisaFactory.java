package cmpe202.StudentID_014604096.factory;

import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.VisaCC;

public class VisaFactory implements CreditCardFactory{
	
	@Override
	public CreditCard getCard() {
		return new VisaCC();
	}
}
