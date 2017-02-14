/*
	Main class
	1. search expression by lambda
		problem statement
			a. Drivers: Persons over the age of 16
			b. Draftees: Male persons between the ages of 18 and 25
			c. Pilots (specifically commercial pilots): Persons between the ages of 23 and 65

	Author : chi
	Time   : 2017/2/4
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Main {
	public static void main(String[] args) {
		RunnableTest.main(args);

		List<Person> pl = Person.createShortList();
		SearchTest search = new SearchTest();

		// Predicates
		Predicate<Person> allDrivers = p -> p.getAge() >= 20;
		Predicate<Person> allDraftees = p ->  p.getAge()>=18 && p.getAge() <=25 && p.getGender() == Gender.Male;

		System.out.println("=== Search person over 16 years old. ===");
		search.phoneContacts(pl, allDrivers);

		System.out.println("=== Search Male persons between the ages of 18 and 25. ===");
		search.draftees(pl, allDraftees);
	}
}