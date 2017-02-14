/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/
	
public interface FunctionalInterface <F, T>{
	default public void hello (){
		System.out.println("Helle Founctional interface!");
	}

	public T convert(F from);
}