/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/

public class FunctionalInterfaceTest {
	public static void main(String[] args) {
		System.out.println();
		System.out.println("FunctionalInterfaceTest");

		// FunctionalInterface<String, Integer> converter = (from) -> Integer.valueOf(from);
		FunctionalInterface<String, Integer> converter = Integer::valueOf;
		Integer converted = converter.convert("123");
		System.out.println(converted);    // 123

		converter.hello();

	}
}