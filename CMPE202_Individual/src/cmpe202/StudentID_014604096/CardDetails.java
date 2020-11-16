package cmpe202.StudentID_014604096;

public class CardDetails {

	@Override
	public String toString() {
		return "CardDetails [cardNumber=" + cardNumber + ", cardType=" + cardType + ", isError=" + isError + "]";
	}
	private String cardNumber;
	private String cardType;
	private String isError;
	
	public CardDetails(){
		
		
	}
	public CardDetails(String cardNumber){
		this.cardNumber = cardNumber;
		this.cardType = "";
		this.isError = "";
		
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getIsError() {
		return isError;
	}
	public void setIsError(String isError) {
		this.isError = isError;
	}
	
}
