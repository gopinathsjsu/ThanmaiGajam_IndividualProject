package cmpe202.StudentID_014604096.validation;

import cmpe202.StudentID_014604096.CreditCard;

public interface Validator {
	public CreditCard validate(String cardNumber);
	public void nextHandler(Validator next);
}
