package cmpe202.StudentID_014604096.validation;

import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.factory.AmexFactory;
import cmpe202.StudentID_014604096.factory.DiscoverFactory;

public class DiscoverValidator implements Validator {

	private Validator next = null;

	@Override
	public CreditCard validate(String cardNumber) {
		if (cardNumber.length() >=0 && cardNumber.length() <=19
			&&	cardNumber.substring(0, 4).equals("6011")
		    && cardNumber.length() == 16
			) {// logic for valid card
			//System.out.println("ttttt" + cardNumber.substring(0, 3));
			CreditCard cc = new DiscoverFactory().getCard();
			cc.setCardType("Discover");
			return cc;
		} else {
			if (next != null) {
				return next.validate(cardNumber);
			}
		}
		return null;
	}

	@Override
	public void nextHandler(Validator next) {
		this.next = next;
	}
}
