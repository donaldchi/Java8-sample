/*
	Person info class for test
	Author : chi
	Time   : 2017/2/4
*/

import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;

public class Person {
	private String givenName; //required
	private String surName; //required
	private int age; //optional
	private Gender gender; //optional
	private String eMail; //optional
	private String phone; //optional
	private String address; //optional
	private Person(Builder builder) {
		this.givenName = builder.givenName;
		this.surName = builder.surName;
		this.age = builder.age;
		this.eMail = builder.eMail;
		this.phone = builder.phone;
		this.gender = builder.gender;
		this.address = builder.address;
	}
	public String getSurName() {
		return surName;
	}
	public String getGivenName() {
		return givenName;
	}
	public String getEmail() {
		return eMail;
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
	public Gender getGender() {
		return gender;
	}

	public String printCustom(Function <Person, String> f){
		return f.apply(this);
	}

	public static class Builder {
		private String givenName; //required
		private String surName; //required
		int age; //optional
		Gender gender = Gender.Female; //optional
		String eMail; //optional
		String phone; //optional
		String address; //optional

		public Builder (String givenName, String surName) {
			this.givenName = givenName;
			this.surName = surName;
		}
		public Builder age(int age) {
        	this.age = age;
        	return this;
    	}
		public Builder gender(Gender gender) {
        	this.gender = gender;
        	return this;
    	}
		public Builder eMail(String eMail) {
        	this.eMail = eMail;
        	return this;
    	}
		public Builder phone(String phone) {
        	this.phone = phone;
        	return this;
    	}
		public Builder address(String address) {
        	this.address = address;
        	return this;
    	}      
    	public Person build() {
    		Person p = new Person(this);
    		if(p.getAge()>120) {
    			throw new IllegalStateException("Age out of range!");
    		}
    		return p;
    	}  	
	}
	
	public static List<Person> createShortList() {
		List<Person> people = new ArrayList<>();

		people.add(
			new Person.Builder("Bob", "Baker")
			.age(18)
			.gender(Gender.Female)
			.eMail("bob@abc.com")
			.phone("080-4478-8887")
			.address("Tokyo Japan")
			.build()
		);

		people.add(
			new Person.Builder("Baker", "Dhi")
			.age(21)
			.gender(Gender.Female)
			.eMail("chi@abc.com")
			.phone("080-4478-8887")
			.address("Yokohama Japan")
			.build()
		);

		people.add(
			new Person.Builder("Donald", "Chi")
			.age(20)
			.gender(Gender.Male)
			.eMail("donald@abc.com")
			.phone("080-4478-8887")
			.address("Chiba Japan")
			.build()
		);

		people.add(
      		new Person.Builder("Bob","Baker")
	            .age(21)
	            .gender(Gender.Male)
	            .eMail("bob.baker@example.com")
	            .phone("201-121-4678")
	            .address("44 4th St, Smallville, KS 12333")
	            .build() 
      	);

	    people.add(
	      	new Person.Builder("Jane", "Doe")
	            .age(25)
	            .gender(Gender.Male)
	            .eMail("jane.doe@example.com")
	            .phone("202-123-4678")
	            .address("33 3rd St, Smallville, KS 12333")
	            .build() 
	      );
	    
	    people.add(
	      	new Person.Builder("John", "Doe")
	            .age(25)
	            .gender(Gender.Male)
	            .eMail("john.doe@example.com")
	            .phone("202-123-4678")
	            .address("33 3rd St, Smallville, KS 12333")
	            .build()
	    );
	    
	    people.add(
	      	new Person.Builder("James", "Johnson")
	            .age(45)
	            .gender(Gender.Female)
	            .eMail("james.johnson@example.com")
	            .phone("333-456-1233")
	            .address("201 2nd St, New York, NY 12111")
	            .build()
	    );
	    
	    people.add(
	      	new Person.Builder("Joe", "Bailey")
	            .age(67)
	            .gender(Gender.Male)
	            .eMail("joebob.bailey@example.com")
	            .phone("112-111-1111")
	            .address("111 1st St, Town, CA 11111")
	            .build()
	    );
	    
	    people.add(
	      	new Person.Builder("Phil", "Smith")
	            .age(55)
	            .gender(Gender.Female)
	            .eMail("phil.smith@examp;e.com")
	            .phone("222-33-1234")
	            .address("22 2nd St, New Park, CO 222333")
	            .build()
	    );
	    
	    people.add(
      		new Person.Builder("Betty", "Jones")
	            .age(85)
	            .gender(Gender.Male)
	            .eMail("betty.jones@example.com")
	            .phone("211-33-1234")
	            .address("22 4th St, New Park, CO 222333")
	            .build()
	    );
		return people;
	}		
}