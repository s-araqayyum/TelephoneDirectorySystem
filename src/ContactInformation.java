
public class ContactInformation { //Class that aims to hold attributes of a contact within the telephone directory 

	private int ID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String city;
	private String country;
	private String residentialAddress;
	private String website;
	private String company;
	private int year;
	private int month;
	private int day;
	
	public ContactInformation(int iD, String firstName, String lastName, String phoneNumber, String city, String country,
			String residentialAddress, String website, String company, int year, int month, int day) {
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.country = country;
		this.residentialAddress = residentialAddress;
		this.website = website;
		this.company = company;
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public void display() {
		System.out.println("ID:: "+getID()+". Name:: "+getFirstName()+" "+getLastName() +". Date of Birth:: "+getDay()+"/"+getMonth()+"/"+getYear()+". Phone Number:: "+getPhoneNumber() +". Address:: "+getResidentialAddress()+", "+getCity()
		+", "+getCountry()+". Company:: "+getCompany()+". Website:: "+getWebsite());
}
	
	public ContactInformation() {
		// TODO Auto-generated constructor stub
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
