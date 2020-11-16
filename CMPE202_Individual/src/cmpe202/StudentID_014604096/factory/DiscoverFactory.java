package cmpe202.StudentID_014604096.factory;

import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.DiscoverCC;

public class DiscoverFactory implements CreditCardFactory{
	
	@Override
	
	public CreditCard getCard() {
		return new DiscoverCC();
	}

}
