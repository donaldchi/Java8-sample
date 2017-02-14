/*
	Lambda expression in Runnable
	Author : chi
	Time   : 2017/2/4
*/
	
package mypackage;
	
public class MyAp {
	
	public MyAp() { }
	
	public void hello(int a,int b) {
		 System.out.println("Helle MyAP, "+(a+b)+"!");
	}
	
	public static void main(String[] args) {
		MyAp ap = new MyAp();
		ap.hello(3, 3);

	}
}
