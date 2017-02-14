/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
// import java.util.stream.Streams;
import java.util.stream.IntStream;

public class Test02 {
	public static void main(String[] args) {
		System.out.println("Test stream");

		int sum2 = IntStream.rangeClosed(1, 20)
					.filter(i->i%1==0)
					.sum();

		System.out.println(sum2);

		int sum3 = IntStream.rangeClosed(1, 20)
					.filter(i->i%1==0)
					.map(i -> i*2)
					.sum();
		System.out.println(sum3);

		int sum4 = IntStream.rangeClosed(1, 10)
					.map(i -> i*2)
					.reduce(0, (i1, i2) -> i1+i2);
		System.out.println(sum4);

		//compute kaijo 
		System.out.println("compute kaijo!");
		IntStream.rangeClosed(1, 10)
			.forEach(i->{
				int kaijo = IntStream.rangeClosed(1, i).reduce(1, (i1, i2) -> i1*i2);
				System.out.println(i + "! =" + kaijo);
			});

		//compute kaijo : map
		System.out.println("compute kaijo : map!");
		IntStream.rangeClosed(1, 10)
			.map(i -> IntStream.rangeClosed(1, i).reduce(1, (i1, i2) -> i1*i2))
			.forEach(i -> System.out.println(i));

		//compute kaijo : boxed
		System.out.println("compute kaijo : map!");
		IntStream.rangeClosed(1, 10)
			.boxed() //.mapToObj(i->i)でも同様
			.collect(Collectors.toMap(i->i, 
				i -> IntStream.rangeClosed(1, i).reduce(1, (i1, i2) -> i1*i2)))
			.forEach((k, v) -> System.out.println(k + "! = " + v));
	}
}