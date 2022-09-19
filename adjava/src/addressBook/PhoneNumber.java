package addressBook;

public class PhoneNumber {
	private String label;
	private String phoneNumber;

	public String getLabel() {
		return label;
	}

	public String getphoneNumber() {
		return phoneNumber;
	}

	public void setLabel(String label) throws LengthException {

		if (label.length() != 0 && label.length() <= 255) {
			this.label = label;
		} else {
			throw new LengthException(" not valid Label,length should be in the range of (1to255)");
		}

	}

	public void setphoneNumber(String phoneNumber) throws InvalidphoneNumberException {

		if (phoneNumber.matches("\\d{10}")) {
			this.phoneNumber = phoneNumber;
		} else {
			throw new InvalidphoneNumberException("phoneNumber only contain 10 digits");
		}

	}

	@Override
	public String toString() {
		return "PhoneNumber [label=" + label + ", phoneNumber=" + phoneNumber + "]";

	}

}
