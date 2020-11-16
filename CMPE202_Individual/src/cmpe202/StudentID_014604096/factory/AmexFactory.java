package cmpe202.StudentID_014604096.factory;

import cmpe202.StudentID_014604096.AmexCC;
import cmpe202.StudentID_014604096.CreditCard;

public class AmexFactory implements CreditCardFactory{
	
	@Override
	public CreditCard getCard() {
		return new AmexCC();
	}
}
