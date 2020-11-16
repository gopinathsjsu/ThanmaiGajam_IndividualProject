package cmpe202.StudentID_014604096.validation;

import cmpe202.StudentID_014604096.CreditCard;
import cmpe202.StudentID_014604096.factory.MasterCardFactory;

public class MasterValidator implements Validator {

	private Validator next = null;

	@Override
	public CreditCard validate(String cardNumber) {
		if (cardNumber.length() >=0 && cardNumber.length() <=19
			&& cardNumber.charAt(0) == '5' 
			&& (cardNumber.charAt(1)-'0') >=1 && (cardNumber.charAt(1)-'0') <=5
			&& cardNumber.length() == 16
			) {// logic for valid card

			CreditCard cc = new MasterCardFactory().getCard();
			cc.setCardType("MasterCard");
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
