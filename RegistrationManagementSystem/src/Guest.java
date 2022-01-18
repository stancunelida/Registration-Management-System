public class Guest {
	
	private  String firstName;
	private  String lastName;
	private  String email;
	private  String phoneNumber;
	
	
	// constructor of Object Guest
	public Guest(String firstName, String lastName, String email, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	//getters and setters for fields of the Object
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//methods
	
	// - compare this.firstName && this.lastName with anoter Guest same fields.
	public boolean equalsToFirstNameAndLastName (Object obj) {
		Guest theObject = (Guest) obj;
		
		if (theObject.getFirstName() != null && theObject.getLastName() != null) {
			if ((this.firstName.compareTo(theObject.getFirstName()) == 0) && (this.lastName.compareTo(theObject.getLastName()) == 0))  {
				return true;
			}
		}
		return false;
	}
	
	// - compare this.email with another Guest same field
	public boolean equalsToEmail(Object obj) {
		Guest theObject = (Guest) obj;
		
		if (theObject.getEmail() != null) {
			if (this.email.compareTo(theObject.getEmail()) == 0) {
				return true;
			}
		}
		return false;
	}
	
	// - compare this.phoneNumber with another Guest same field
	public boolean equalsToPhoneNumber(Object obj) {
		Guest theObject = (Guest) obj;
		
		if (theObject.getPhoneNumber() != null) {
			if (this.phoneNumber.compareTo(theObject.getPhoneNumber()) == 0) {
				return true;
			}
		}
		return false;
	}
}