/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/

import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class Fizzbuzz {
	public static void main(String[] args) {
		//fizzbuzz v1
		System.out.println("==== FizzBuzz v1 ====");
		IntStream.rangeClosed(1, 40)
			.forEach(i -> {
				if (i % 15 == 0) {
					System.out.println("FizzBuzz");
				} else if (i % 3 == 0) {
					System.out.println("Fizz");
				} else if (i % 5 == 0) {
					System.out.println("Buzz");
				} else {
					System.out.println(i);
				}
			});

		//fizzbuzz v2
		System.out.println("==== Fizzbuzz v2 ====");
		IntStream.rangeClosed(1, 40)
			.mapToObj(i -> i%15==0 ? "FizzBuzz" :
				i%3==0 ? "Fizz" :
				i%5==0 ? "Buzz" :
				String.valueOf(i))
			.forEach(s->System.out.println(s));

		//fizzbuzz v3
		System.out.println("==== Fizzbuzz v3 ====");
		IntStream.rangeClosed(1, 40)
			.boxed()
			.collect(Collectors.toMap(i->i, i -> i%15==0 ? "FizzBuzz" :
				i%3==0 ? "Fizz" :
				i%5==0 ? "Buzz" :
				String.valueOf(i)))
			.forEach((k,v)->System.out.println(k + ", " + v));

		
		IntStream.rangeClosed(1, 10)
		.boxed()  // .mapToObj(i -> i) でも同様
        .collect(Collectors.toMap(i -> i, 
                i -> IntStream.rangeClosed(1, i).reduce(1, (i1, i2) -> i1 * i2)))
        .forEach((k, v) -> System.out.println(k + "! = " + v));	

	}
}