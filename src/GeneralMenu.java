
import java.time.LocalDate;
import java.util.Scanner;
public class GeneralMenu { //The General Menu Class aims to hold all functions for the telephone directory 

	static ArrayList < ContactInformation > contact = new ArrayList < ContactInformation >(); //Generic Array-list of type Contact-Information
	static int ID = 4; //ID incremented beyond predefined data
	
	public void Menu() {
		System.out.println(""); //Making the output neater
		System.out.println("What action would you like to perform today?");
		
		System.out.println("1. Add a contact");
		System.out.println("2. Modify a contact");
		System.out.println("3. Delete a contact");
		System.out.println("4. View Contact");
		System.out.println("5. Sort Contacts");
		System.out.println("6. Search for a contact through name");
		System.out.println("7. See recent birthdays");
		System.out.println("8. View all contacts [Inclusive of IDs]"); //Use this extra function for ease of test-case checking 
		System.out.println("9. Exit Phone Book");
		
		Scanner userDec = new Scanner(System.in);
		int decision = userDec.nextInt();
		
		switch(decision) {
		case 1:
			AddContact();
			break;
		case 2:
			ModifyContact();
			break;
		case 3:
			DeleteContact();
			break;
		case 4:
			ViewContact();
			break;
		case 5:
			System.out.println("Would you like to sort by 1) ID or 2) Alphabetical Order of Names? Enter 1 or 2: ");
			Scanner myObj = new Scanner(System.in);
			int sortChoice = myObj.nextInt();
			if(sortChoice == 1) {
				sort();
		        System.out.println("Directory sorted by ID successfully!");
			}
			else if(sortChoice == 2) {
				sortByName();
		        System.out.println("Directory sorted by name successfully!");
			}
			else
				System.out.println("Invalid Option. Try again.");
			break;
		case 6:
			sortByName();
			System.out.println("Search for contact details by entering the first name:");
			 Scanner nameObj = new Scanner(System.in);
			 String x = nameObj.nextLine();
			int result = search(x);
			if (result == -1) {
				  System.out.println("No matching names in the telephone directory.");
			}
			else
				display(result);
			continuedBinary(x, result);
			break;
		case 7:
			RecentBirthday();
			break;
		case 8:
			boolean exists = false;
			for(int i = 0; i < contact.length(); i ++) { //Size of array passed through to display
				display(i);
				exists = true;
			}
			
			if(exists == false) {
				System.out.println("No contacts in directory");
			}
			break;
		case 9:
			System.out.println("Thank you for using the Phone Book - Come again!");
			System.exit(0);
			break;
		default:
			System.out.println("Please enter a valid choice!");
			
		}
	}

	private void display(int i) { //Linked with function in ContactInformation to display all attributes of contact
		ContactInformation displaying = (ContactInformation) contact.get(i);
		if(displaying == null) {
		}
			
		displaying.display();
	}

	public void AddContact() { //Adds necessary contact information in array-list
		
		ContactInformation cInfo = new ContactInformation();
		Scanner userDetails = new Scanner(System.in);
		System.out.println("Enter your first name:");
		String fName = userDetails.nextLine();
		System.out.println("Enter your last name:");
		String lName = userDetails.nextLine();
		System.out.println("Enter your year of birth: [yyyy format]");
		int year = userDetails.nextInt();
		System.out.println("Enter your month of birth: [mm format]");
		int month = userDetails.nextInt();
		System.out.println("Enter your day of birth: [dd format]");
		int day = userDetails.nextInt();
		
		if(day > 31 || day < 1 || month > 12 || month < 1 || year < 1800 ) { //Check for dOB
			System.out.println("Enter a valid date of birth. Try again.");
		}
		else {
			Scanner userDets = new Scanner(System.in);
			System.out.println("Enter your phone number:");
			String phoneNumber = userDets.nextLine();
			System.out.println("Enter your residential address:");
			String address = userDets.nextLine();
			System.out.println("Enter your city:");
			String city = userDets.nextLine();
			System.out.println("Enter your country:");
			String country = userDets.nextLine();
			System.out.println("Enter your company's name:");
			String companyName = userDets.nextLine();
			System.out.println("Enter your website:");
			String website = userDets.nextLine();
			
			contact.add(new ContactInformation(ID, fName, lName, phoneNumber, city, country, address, website, companyName, year, month, day));
			ID++;
			
			System.out.println("Contact added successfully!");
		}
		
	}

	public void ModifyContact() { //This module is responsible for updating the name of the user 
		
		System.out.println("Enter the ID of the individual whose details you would like to modify");
		Scanner myObj = new Scanner(System.in);
		int ID = myObj.nextInt();
		boolean flag = true;
		
		for(int i = 0; i < contact.length(); i++) {
			if ( contact.get(i).getID() == ID ) {
				Scanner someObj = new Scanner(System.in);
				flag = true;
				System.out.println("Enter the new first name:");
				String fName = someObj.nextLine();
				System.out.println("Enter the new last name:");
				String lname = someObj.nextLine();
				
				contact.get(i).setFirstName(fName);
				contact.get(i).setLastName(lname);
				
				System.out.println("Contact modified successfully!");
				return;
			}
			else
				flag = false;
		}
		
		if ( flag == false) {
			System.out.println("No matching ID found. Modification Unsuccessful");
		}
	}
	
	public void DeleteContact() { //In this module, the records with a specific id are deleted.
		
		System.out.println("Enter the ID of the individual who you would like to remove from the phone registry:");
		Scanner myObj = new Scanner(System.in);
		int ID = myObj.nextInt();
		boolean flag = true;
		
		for(int i = 0; i < contact.length(); i++) {
			if ( contact.get(i).getID() == ID ) {
				contact.remove(i);
				flag = true;
				break;
			}
			else
				flag = false;
		}
		
		if ( flag == false) {
			System.out.println("No matching ID found. Deletion Unsuccessful");
		}
		else
			System.out.println("Contact deleted successfully!");
	}
	
	public void sort() { //Sort the records in the ascending order of the ID
		
        int n = contact.length();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++) {
            	if(contact.get(j).getID() > contact.get(j+1).getID()) {
            		contact.bubbleSort(j);
            	}
            }
	}
	
	public void sortByName() { //Sort the records alphabetically
		
        int n = contact.length();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++) {
            	if(contact.get(j).getFirstName().compareToIgnoreCase(contact.get(j+1).getFirstName()) > 0) {
            		contact.bubbleSort(j);
            	}
            }
	}
	
	public void set(int index, ContactInformation element) { //Unused set function
		

        ArrayList.setLength(ArrayList.getLength()+1);
		if (index < 0 || index >= contact.length()) {
			throw new IndexOutOfBoundsException();
		}
		
		contact.get(index).setFirstName(element.getFirstName());
        contact.get(index).setLastName(element.getLastName());
        contact.get(index).setDay(element.getDay());
        contact.get(index).setMonth(element.getMonth());
        contact.get(index).setYear(element.getYear());
        contact.get(index).setResidentialAddress(element.getResidentialAddress());
        contact.get(index).setCity(element.getCity());
        contact.get(index).setCountry(element.getCountry());
        contact.get(index).setPhoneNumber(element.getPhoneNumber());
        contact.get(index).setCompany(element.getCompany());
        contact.get(index).setWebsite(element.getWebsite());
        
		
	}
	
	public void ViewContact() { //This module allows the user to view a specific contact's details through their phone number
		
		System.out.println("Enter the phone number of the contact you would like to view");
		Scanner myObj = new Scanner(System.in);
		String phone = myObj.nextLine();
		boolean flag = false;
		
		for(int i = 0; i < contact.length(); i++) {
			if ( contact.get(i).getPhoneNumber().equalsIgnoreCase(phone)) {
				display(i);
				flag = true;
			}
		}
		
		if (flag == false) {
			System.out.println("This phone number does not exist in directory.");
		}
	}
	
	 public int search(String x){ //This module allows to search for the contact details by just entering their first name
		 
	     int l = 0;
	     int r = contact.length() - 1;
	        
	     while (l <= r) {
	    	 int m = l + (r - l) / 2;
	    	 int res = x.compareToIgnoreCase(contact.get(m).getFirstName());

	    	 if (res == 0) //Checking if string belongs in the middle
	    		 return m;
	 
	         if (res > 0) // If x is greater, ignoring left half
	              l = m + 1;
	         else  // If x is smaller, ignore right half
	              r = m - 1;
	        }
	        return -1;
	 }
	 
	public void continuedBinary(String x, int result) { //This module gets the rest of the contacts with similar names as they are next to each other
			for(int i = result + 1; i < contact.length(); i++) {
				if(contact.get(i).getFirstName().equalsIgnoreCase(x)) {
					display(i);
				}
				else
					break;
			}
			
			for(int i = result - 1; i < contact.length() && i >=0 ; i--) {
				if(contact.get(i).getFirstName().equalsIgnoreCase(x)) {
					display(i);
				}
				else
					break;
			}
		}
	 
	 public int LocalMonth() { //This component allows system to obtain local month
		LocalDate date = LocalDate.now();   
		int month = date.getMonthValue();
		return month;
	 }
	 
	 public void RecentBirthday() { //Shows the recent birthdays of the contacts
		 
		 int thisMonth = LocalMonth();
		 boolean prevMonth = false;
		 boolean currMonth = false;
		 boolean nextMonth = false;
		 
		 System.out.println("Birthdays in previous month:");
		 
		 for (int i = 0; i < contact.length(); i++) {
			 if(contact.get(i).getMonth() == (thisMonth-1)) {
				 prevMonth = true;
				 System.out.println(contact.get(i).getFirstName()+" "+contact.get(i).getLastName()+" had their birthday on "+contact.get(i).getDay()+"/"+contact.get(i).getMonth()+".");
			 }
		 }
		 
		 if ( prevMonth == false ) {
			 System.out.println("No birthdays in previous month!");
		 }
		 
		 System.out.println("");
		 
		 System.out.println("Birthdays upcoming in current month:");
		 
		 for (int i = 0; i < contact.length(); i++) {
			 if((contact.get(i).getMonth()) == thisMonth) {
				 currMonth = true;
				 System.out.println(contact.get(i).getFirstName()+" "+contact.get(i).getLastName()+" is having their birthday on "+contact.get(i).getDay()+"/"+contact.get(i).getMonth()+".");
			 }
		 }
		 
		 if ( currMonth == false ) {
			 System.out.println("No birthdays in this month!");
		 }
		 

		 System.out.println("");
		 
		 System.out.println("Birthdays in upcoming month:");
		 
		 for (int i = 0; i < contact.length(); i++) {
			 if(contact.get(i).getMonth() == (thisMonth+1)) {
				 nextMonth = true;
				 System.out.println(contact.get(i).getFirstName()+" "+contact.get(i).getLastName()+" is going to have their birthday on "+contact.get(i).getDay()+"/"+contact.get(i).getMonth()+".");
			 }
		 }
		 
		 if ( nextMonth == false ) {
			 System.out.println("No birthdays in upcoming month!");
		 }
		 
	 }
 
}
