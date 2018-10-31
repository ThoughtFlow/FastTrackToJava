package lab07.fin.customer;

/**
 * This class represents the account holder.
 * 
 * @author Nick Maiorano
 * @version 1.0
 */
public class Customer {

	private final String firstName;
	private final String lastName;
	private final String ssn;

	/**
	 * Constructor to set immutable fields.
	 * 
	 * @param firstName The name to set.
	 * @param lastName The name to set.
	 * @param ssn The social security number to set.
	 */
	public Customer(String firstName, String lastName, String ssn) throws NullPointerException {
		if (firstName != null & lastName != null & ssn != null) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.ssn = ssn;
		}
		else
		{
			throw new NullPointerException("Values must be non-null");
		}
	}

	/**
	 * Returns the first name.
	 * 
	 * @return The first name.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Returns the last name.
	 * 
	 * @return The last name.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Returns the ssn.
	 * 
	 * @return The ssn.
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", ssn=" + ssn + "]";
	}

	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc} 
	 * 
	 * Additional comments go here.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}
}
