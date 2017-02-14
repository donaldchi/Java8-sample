/*
	Lambda expression in Runnable
	Author : chi
	Time   : 2017/2/4
*/
	
package mypackage.subpackage; 

public class MySub {
	public MySub() { } 

	public void hello() {
		System.out.println("Say Hello from Sub!");
	}

	public static void main(String[] args) {
		MySub mysub = new MySub();
		mysub.hello();
	}
}