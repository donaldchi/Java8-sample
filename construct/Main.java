/*
	Test stream class
	Author : chi
	Time   : 2017/2/8
*/

public class Main {
	public static void main(String[] args) {
		PersonFactory<Person> pf = Person::new;
		Person person = pf.create("Peter", "Parker");
		System.out.println("first name: " + person.getFirstName());
		System.out.println("last name: " + person.getLastName());
	}
}