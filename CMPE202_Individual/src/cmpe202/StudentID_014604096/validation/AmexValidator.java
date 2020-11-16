package cmpe202.StudentID_014604096.validation;

import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.factory.AmexFactory;

public class AmexValidator implements Validator {

	private Validator next = null;

	@Override
	public CreditCard validate(String cardNumber) {
		if (    cardNumber.length() >=0 && cardNumber.length() <=19
				&& cardNumber.charAt(0) == '3' 
				&& (cardNumber.charAt(1) =='4'|| cardNumber.charAt(1) == '7')
				&& cardNumber.length() == 15
				) {// logic for valid card
			CreditCard cc = new AmexFactory().getCard();
			cc.setCardType("American Express");
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
