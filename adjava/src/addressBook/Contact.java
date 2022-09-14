package addressBook;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	private String name;
	private String organisation;

	private List<PhoneNumber> phoneNumberList = new ArrayList<PhoneNumber>();
	private List<Address> addressList = new ArrayList<Address>();

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumberList;
	}

	public List<Address> getAddresses() {
		return addressList;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;

	}

	public void setName(String name) throws LengthException {
		if (name.length() != 0 && name.length() <= 255) {
			this.name = name;

		} else {
			throw new LengthException("Invalid name, length be in the range of(1to 255)");
		}
	}
//added setters

	public String getName() {
		return name;
	}

	public List<PhoneNumber> getPhoneNumber() {
		return phoneNumberList;
	}

	public void addPhoneNumber(PhoneNumber number) {
		phoneNumberList.add(number);

	}

	public void addAddress(Address address) {
		addressList.add(address);
	}

	public String getOrganisation() {
		// TODO Auto-generated method stub
		return organisation;
	}

	// public void setOrganisation(String organisation) {
	///// this.organisation = organisation;
	// }

//public void setName(String name) {
//this.name = name;
//}

//public void setPhoneNumList(List<PhoneNumber> phoneNumList) {
//this.phoneNumList = phoneNumList;
//}
//	public void setAddressList(List<Address> addressList) {
//		this.addressList = addressList;
//	}

}
