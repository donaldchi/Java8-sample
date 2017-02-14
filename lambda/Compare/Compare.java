/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.*;
import java.util.Comparator;

public class Compare {
	public static void main(String[] args) {
		System.out.println("Compare!!");
		List<String> t = Arrays.asList("pine", "apple", "banana", "melon");
		
		// Collections.sort(t, new Comparator<String>() {
		// 	@Override
		// 	public int compare(String a, String b) {
		// 		return b.compareTo(a);
		// 	}
		// });
		// System.out.println(t);

		Collections.sort(t, (a, b) -> a.compareTo(b));
		// System.out.println(t);

		System.out.println("=== use for loop ===");
		for(String a : t) {
			System.out.println(a);
		}

		System.out.println("===  use stream  ===");
		t.stream()
		.forEach(s -> System.out.println(s));
	}
}