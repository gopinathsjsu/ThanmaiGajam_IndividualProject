package cmpe202.StudentID_014604096;

import java.util.List;

//import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InputDetails {

	@Override
	public String toString() {
		return "InputDetails [cclist=" + cclist + "]";
	}

	@JsonProperty("cclist")
	private List<CreditCard> cclist;

	public List<CreditCard> getCclist() {
		return cclist;
	}

	public void setCclist(List<CreditCard> cclist) {
		this.cclist = cclist;
	}
}
