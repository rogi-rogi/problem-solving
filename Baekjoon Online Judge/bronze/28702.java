import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> words = Set.of("FizzBuzz", "Fizz", "Buzz");

        int num = 0;
        for (int i = 0; i < 3; ++i) {
            // Input
            String input = br.readLine();

            // Solve
            if (!words.contains(input)) {
                num = Integer.parseInt(input) + (3 - i);
                break;
            }
        }
        String res =    (num % 15 == 0) ? "FizzBuzz" :
                        (num % 3 == 0) ? "Fizz" :
                        (num % 5 == 0) ? "Buzz" : String.valueOf(num);
        
        // Output
        System.out.println(res);
    }
}
