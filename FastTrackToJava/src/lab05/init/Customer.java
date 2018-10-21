package lab05.init;

public class Customer {

	private final String firstName;
	private final String lastName;
	private final String ssn;
	
	
	public Customer(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSsn() {
		return ssn;
	}
	
	public void printAccount() {
		System.out.println("First name: " + firstName);
		System.out.println("Last name: " + lastName);
		System.out.println("Ssn: " + ssn);
	}
}
