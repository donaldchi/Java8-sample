/*
	Collection comparation
	Author : chi
	Time   : 2017/2/4
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class ComparatorTest {

	public static void main(String[] args) {
		List<Person> personList = Person.createShortList();

		/*Collections.sort(personList, new Comparator<Person>() {
			public int compare(Person p1, Person p2) {
				return p1.getSurName().compareTo(p2.getSurName());
			}
		});*/
		
		System.out.println("=== Sorted asc SurName ==");				
		personList.forEach(p->System.out.println("Name: " + p.getSurName()));
		//for (Person p : personList) {
		//	System.out.println("Age: " + p.getAge());
		//}
		
		//lambda, asc
		System.out.println("=== Sorted asc SurName, Lambda  ==");				
		Collections.sort(personList, (p1, p2)->p1.getSurName().compareTo(p2.getSurName()));
		personList.forEach(p->System.out.println("Name: " + p.getSurName()));

		System.out.println("=== Sorted dsc SurName, Lambda  ==");				
		Collections.sort(personList, (Person p1, Person p2)->p2.getSurName().compareTo(p1.getSurName()));
		personList.forEach(p->System.out.println("Name: " + p.getSurName()));

	}
}
