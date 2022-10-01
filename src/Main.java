//Telephone Directory System - Phone Book
//Sara Qayyum 20I-0556 BSSE-R

public class Main {
	
	public static void main (String [] args) {
		
		GeneralMenu menu = new GeneralMenu(); //Invoking General Menu that holds all functions of the telephone directory
		
		//Below added is predefined data in random order for test-cases
		GeneralMenu.contact.add(new ContactInformation(3, "Sara", "Qayyum", "0425753763", "Lahore", "Pakistan", "Al-Hafeez Centre,Main Boulevard", "www.industry.com", "Industrial Studio", 1980, 10,30));
		GeneralMenu.contact.add(new ContactInformation(2, "Maryam", "Ebrahim", "0454710295", "Islamabad", "Pakistan", "Ghalla Mandi Bazar", "tdofficial.com", "TD Bank", 1993, 9,8));
		GeneralMenu.contact.add(new ContactInformation(0, "Amna", "Qayyum", "03238523439", "Islamabad", "Pakistan", "House #26A, Street # 8,F-11", "-", "Amnarch", 1997, 12,31));
		GeneralMenu.contact.add(new ContactInformation(1, "Shehzad", "Shabnam", "01238559439", "Karachi", "Pakistan", "Building Rahat Milk Corner, 3rd Floor South Park Avenue, DHA Phase 2", "-", "Unemployed", 2001, 8,11));
		
		System.out.println(""); //Making output neater
		System.out.println("Welcome to our Phone Book!");
		
		for(;;) { //Infinite loop for using telephone directory, till user exits 
			menu.Menu();
		}
	}
}
