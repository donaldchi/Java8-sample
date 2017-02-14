/*
	Lambda expression in Runnable
	Author : chi
	Time   : 2017/2/4
*/

public class RunnableTest {
	public static void main(String[] args) {
		System.out.println("=== Runnable Test ===");
		
		//Annonymous Runnable
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello world one!");
			}
		};

		//Lambda Runnable
		Runnable r2 = () -> System.out.println("Hello world two!");

		//Run em!
		r1.run();
		r2.run();
	}
}
