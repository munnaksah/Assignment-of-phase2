package addressBook;

public class Address {
	private String label;
	private String address;

	public String getLabel() {
		return label;
	}

	public String getAddress() {
		return address;
	}

	public void setLabel(String label) throws LengthException {
		if (label.length() != 0 && label.length() <= 255) {
			this.label = label;

		} else {
			throw new LengthException("Invalid Label,lenght shouble be in range of()1 to 255");

		}
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {
		return "Address [label=" + label + ",address=" + address + "]";
	}

}
