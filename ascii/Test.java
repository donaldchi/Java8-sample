import java.util.*;
import java.lang.*;

public class Test {
	public static void main(String[] args) {
		if(args.length<1) return;
		
		int a = 8;
		System.out.println("a: " + a + ", >>2: " + (a>>2) + ", <<2: " + (a<<2));	


		String input = Integer.toBinaryString(Integer.parseInt(args[0]));
		System.out.println(input);
		char[] keys  = input.toCharArray();
		for(char i : keys) {
			System.out.println(i + ": " + (int)i);
		}

		

	}
}
