/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/
import java.lang.Math;

public interface Formula {

	public double calculate(int a);

	default double sqrt(int a) {
		return Math.sqrt(a);
	}
}