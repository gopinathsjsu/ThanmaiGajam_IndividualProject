package cmpe202.StudentID_014604096.factory;

import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.MasterCC;

public class MasterCardFactory implements CreditCardFactory{
	
	@Override
	public CreditCard getCard() {
		return new MasterCC();
	}
}
