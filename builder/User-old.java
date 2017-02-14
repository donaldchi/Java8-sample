/*
	Class structure without Builder
	Author : chi
	Time   : 2017/2/4
*/
public class User {
	private final String firstName; //required
	private final String lastName; //required
	private final int age; //optional
	private final String phone; //optional
	private final String address; //optional

	public User(String firstName, String lastName) {
		this(firstName, lastName, 0);
	}

	public User(String firstName, String lastName, int age) {
		this(firstName, lastName, age, "");
	}

	public User(String firstName, String lastName, int age, String phone) {
		this(firstName, lastName, age, phone, "");
	}

	public User(String firstName, String lastName, int age, String phone, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.address = address;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public static void main(String[] args) {

	}
}