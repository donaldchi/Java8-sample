/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/
import java.util.List;
import java.util.stream.IntStream;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.lang.Math;

public class Test03 {
	public static void main(String[] args) {
		List<Integer> source = IntStream.rangeClosed(2, 10)
				.boxed()
				.collect(Collectors.toCollection(LinkedList::new));
		List<Integer> result2 = new LinkedList<>();		
		while(true) {
			int firstElement = source.get(0);
			if(firstElement > Math.sqrt(10)) {
				break;
			}
			result2.add(firstElement);
			source.removeIf(elem -> elem % firstElement == 0);
		}
		result2.addAll(source);
		result2.forEach(i -> System.out.println(i + " "));
	}
}