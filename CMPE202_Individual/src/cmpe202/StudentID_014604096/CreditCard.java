package cmpe202.StudentID_014604096;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditCard {
	
	@Override
	public String toString() {
		return "CreditCard [CardNumber=" + cardNumber + ", expirationDate=" + expirationDate + ", nameOfCardHolder="
				+ nameOfCardHolder + "]";
	}
	
	
	@JsonProperty("CardNumber")
	private String cardNumber;
	
	
	@JsonProperty("ExpirationDate")
	private String expirationDate;
	
	
	@JsonProperty("NameOfCardholder")
	private String nameOfCardHolder;

	@JsonIgnore
	private String cardType;
	
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public CreditCard()
	{
		
	}
	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String CardNumber) {
		this.cardNumber = CardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String ExpirationDate) {
		this.expirationDate = ExpirationDate;
	}

	public String getNameOfCardHolder() {
		return nameOfCardHolder;
	}

	public void setNameOfCardHolder(String NameOfCardHolder) {
		this.nameOfCardHolder = NameOfCardHolder;
	}
}
