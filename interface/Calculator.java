/*
	Test stream class
	Author : chi
	Time   : 2017/2/7
*/
import java.lang.Math;

public class Calculator implements Formula {

	@Override
	public double calculate(int a) {
		return Math.sqrt(a);
	};	

	public static void main(String[] args) {
		Calculator formula = new Calculator();

		System.out.println("sqrt: " + formula.sqrt(100));
		System.out.println("sqrt: " + formula.calculate(100));
	}
}