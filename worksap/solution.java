import java.util.stream.*;
import java.lang.*;

public class solution {
     public static void rot13(String value) {
        char[] values = value.toCharArray();

        IntStream.range(0, values.length)
                .mapToObj(i -> {
                    if ((values[i]>='a' && values[i]<='m') || (values[i]>='A' && values[i]<='M')) {
                        // Rotate lowercase letters.
                        return (char) (values[i] + 13);
                    } else if ((values[i]>='n' && values[i]<='z') || (values[i]>='N' && values[i]<='Z')) {
                        // Rotate uppercase letters.
                        return (char) (values[i] - 13);
                    } else {
                        // None Rotate operation done if input is not alphabet
                        return (char) (values[i]);
                    }
                })
                .forEach(i->System.out.print(i));

                System.out.println();
    }

    public static void main(String[] args) {
        if(args.length<1) {
            System.out.println("Please input at least one parameter!");
            return;
        }

        for(String input : args) {
            rot13(input);
        }
    }
}
