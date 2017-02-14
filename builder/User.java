/*
	Builder pattern sample
	Author : chi
	Time   : 2017/2/4
*/
public class User {
	private final String firstName; //required
	private final String lastName; //required
	private final int age; //optional
	private final String phone; //optional
	private final String address; //optional

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getPhone() {
		return phone;
	}

	public String getAddress() {
		return address;
	}

	public static class UserBuilder {
		private final String firstName; //required
		private final String lastName; //required
		int age; //optional
		String phone; //optional
		String address; //optional

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}
		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		public User build() {
      		User user = new User(this);
      		if(user.getAge() > 120) {
      			throw new IllegalStateException("Age out of range"); //thread-safe
      		}

      		return user;
    	}
	}

	public static void main(String[] args) {
		User u = new User.UserBuilder("donald", "chi").age(30).phone("080-4479-8887").address("Fake address 1234").build();
		System.out.println("age: " + u.getAge());

	}
}