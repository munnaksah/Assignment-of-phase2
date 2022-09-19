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

	public static void main(String[] args) {

		try {
			PhoneNumber p = new PhoneNumber();
			p.setLabel("Work");
			p.setphoneNumber("8936867545");
			PhoneNumber p1 = new PhoneNumber();
			p1.setLabel("Home");
			p1.setphoneNumber("9234564561");

			Address a = new Address();
			a.setLabel("Home Address");
			a.setAddress("Bangalore");

			Address a1 = new Address();
			a1.setLabel("Office Address");
			a1.setAddress("RICHMOND");

			Contact c = new Contact();
			c.setName("munna kumar");
			c.setOrganisation("Maveric");
			c.addAddress(a1);
			c.addAddress(a1);
			c.addPhoneNumber(p1);
			c.addPhoneNumber(p1);

			PhoneNumber p2 = new PhoneNumber();
			p2.setLabel("Work");
			p2.setphoneNumber("9876543223");
			PhoneNumber p3 = new PhoneNumber();
			p3.setLabel("Home");
			p3.setphoneNumber("9938772211");

			Address a2 = new Address();
			a2.setLabel("HOME");
			a2.setAddress("Delhi");

			Address a3 = new Address();
			a3.setLabel("OFC");
			a3.setAddress("RCB-BLR");

			Contact c1 = new Contact();
			c1.setName("ms dhoni");
			c1.setOrganisation("chenaai superking");
			c1.addAddress(a3);
			c1.addAddress(a3);
			c1.addPhoneNumber(p3);
			c1.addPhoneNumber(p3);

			// adding to addressbook
			AddressBook addressBook = new AddressBook();
			addressBook.addContact(c);
			addressBook.addContact(c1);

			// Printing if Contacts are present in contactList
			List<Contact> contactList = addressBook.contactList;

			printList(contactList);
			System.out.println("================");
			/*
			 * Testing Methods searchByName() searchByOrganisation() updateContact()
			 * deleteContact()
			 *
			 * //
			 */
			List<Contact> filteredList = addressBook.searchByName("munn");
			System.out.println("===searchByName=======");
			printList(filteredList);

			List<Contact> filteredList1 = addressBook.searchByOrganisation("RC");
			System.out.println("===searchByOrganisation======");
			printList(filteredList1);
			addressBook.updateContact("Virat Kohli", c1);
			addressBook.updateContact("KING", c1); // works
			System.out.println("========After Updating========");
			printList(addressBook.contactList);

			addressBook.deleteContact("munna kumar");
			System.out.print("==========After Deleti=======");
			printList(addressBook.contactList);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
