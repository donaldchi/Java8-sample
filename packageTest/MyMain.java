/*
	Lambda expression in Runnable
	Author : chi
	Time   : 2017/2/4
*/

import mypackage.MyAp;
import mypackage.subpackage.MySub;

public class MyMain {
	public static void main(String[] args) {
		System.out.println("MyMain Start!");

		MyAp ap = new MyAp();
		ap.hello(3, 3);

		MySub mysub = new MySub();
		mysub.hello();

		System.out.println("MyMain End!");
	}
}
