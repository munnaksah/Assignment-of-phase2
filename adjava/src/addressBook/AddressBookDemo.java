package addressBook;

import java.util.List;

public class AddressBookDemo {
	static void printList(List<Contact> list) {
		System.out.println("here");
		for (Contact i : list) {

			System.out.println("Name: " + i.getName() + " Organisation: " + i.getOrganisation());
			System.out.println(i.getAddresses().toString());
			System.out.println(i.getPhoneNumbers().toString());

		}
	}

	public static void main(String[] args) throws LengthException {

		try {
			PhoneNumber p1 = new PhoneNumber();
			p1.setLabel("Work");
			p1.setphoneNumber("8936867545");
			PhoneNumber p2 = new PhoneNumber();
			p2.setLabel("Home");
			p2.setphoneNumber("9234564561");

			Address a1 = new Address();
			a1.setLabel("Home Address");
			a1.setAddress("Bangalore");

			Address a2 = new Address();
			a2.setLabel("Office Address");
			a2.setAddress("RICHMOND");

			Contact c1 = new Contact();
			c1.setName("munna kumar");
			c1.setOrganisation("Maveric");
			c1.addAddress(a1);
			c1.addAddress(a2);
			c1.addPhoneNumber(p2);
			c1.addPhoneNumber(p1);

			PhoneNumber p3 = new PhoneNumber();
			p3.setLabel("Work");
			p3.setphoneNumber("9876543223");
			PhoneNumber p4 = new PhoneNumber();
			p4.setLabel("Home");
			p4.setphoneNumber("9938772211");

			Address a3 = new Address();
			a3.setLabel("HOME");
			a3.setAddress("Delhi");

			Address a4 = new Address();
			a4.setLabel("OFC");
			a4.setAddress("RCB-BLR");

			Contact c2 = new Contact();
			c2.setName("ms dhoni");
			c2.setOrganisation("chenaai superking");
			c2.addAddress(a3);
			c2.addAddress(a4);
			c2.addPhoneNumber(p3);
			c2.addPhoneNumber(p4);

			// adding to addressbook
			AddressBook addressBook = new AddressBook();
			addressBook.addContact(c1);
			addressBook.addContact(c2);

			// Printing if Contacts are present in contactList
			List<Contact> contactList = addressBook.contactList;

			printList(contactList);
			System.out.println(
					"====================================================================================================================");
			/*
			 * Testing Methods searchByName() searchByOrganisation() updateContact()
			 * deleteContact()
			 *
			 * //
			 */
			List<Contact> filteredList = addressBook.searchByName("munn");
			System.out.println(
					"=====================================searchByName==================================================");
			printList(filteredList);

//			List<Contact> filteredList = addressBook.searchByOrganisation("RC");
//			System.out.println(
//					"=====================================searchByOrganisation==================================================");
//			printList(filteredList);

//			addressBook.updateContact("Virat Kohli", c2); //should throw exception
//			addressBook.updateContact("KING", c2); // works
//			System.out.println(
//					"======================================After Updating======================================");
//			printList(addressBook.contactList);

//			addressBook.deleteContact("Chandra sekhar");
//			System.out.println(
//					"======================================After Deleting======================================");
//			printList(addressBook.contactList);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
