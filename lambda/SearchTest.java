/*
	Collection comparation
	Author : chi
	Time   : 2017/2/4
*/
import java.util.List;
import java.util.ArrayList;

public class SearchTest {
	public void phoneContacts(List<Person> pl , Predicate<Person> pred) {
	    for(Person p:pl) {
	      if (pred.test(p)) {
	        roboCall(p);
	      }
	    }
	}

	public void draftees(List<Person> pl , Predicate<Person> pred) {
		for(Person p:pl) {
			if(pred.test(p)) {
				roboDraftees(p);
			}
		}
	}

	public void roboCall(Person p){
    	System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone());
  	}

  	public void roboDraftees(Person p){
    	System.out.println("Calling " + p.getGivenName() + " " + p.getSurName() + " age " + p.getAge() + " at " + p.getPhone() + " gender: " + p.getGender());
  	}
}