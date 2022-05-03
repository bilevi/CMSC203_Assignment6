/**
 * 
 * @author B_Leigh_Vining
 *
 */
public class Customer {

	private String name;
	private int age;

	/**
	 * 
	 * @param n  Name of the customer
	 * @param a  Age of the customer
	 */
	Customer(String n, int a) {
		name = n;
		age = a;
	}
	
	/**
	 * 
	 * @param cust  A customer object
	 */
	Customer(Customer cust) {
		this.name = cust.name;
		this.age = cust.age;
	}
	
	@Override
	public String toString() {
		return "\nName: " + name
				+ "\nAge: " + age;
	}
	
	/**
	 * 
	 * @param n  The name of the customer
	 */
	public void setName(String n) {
		name = n;
	}
	
	/**
	 * 
	 * @return  The name of the customer
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param a  The age of the customer
	 */
	public void setAge(int a) {
		age = a;
	}
	
	/**
	 * 
	 * @return  The age of the customer
	 */
	public int getAge() {
		return age;
	}
}