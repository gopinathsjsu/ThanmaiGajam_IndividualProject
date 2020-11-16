package cmpe202.StudentID_014604096.validation;

import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.factory.VisaFactory;

public class VisaValidator implements Validator {

	private Validator next = null;

	@Override
	public CreditCard validate(String cardNumber) {
		if (cardNumber.length() >=0 && cardNumber.length() <=19
		    && cardNumber.charAt(0) == '4'
		    && (cardNumber.length() == 13 || cardNumber.length() == 16)
			)// logic for valid card
		{
			CreditCard cc = new VisaFactory().getCard();
			cc.setCardType("Visa");
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
