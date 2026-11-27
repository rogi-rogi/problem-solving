import java.io.*;
import java.util.*;

public class Main {
    static long A, B;

    private static int recursive(long num) {
        if (num > B) {
            return 0;
        }

        return (num >= A ? 1 : 0) + recursive(num * 10 + 4) + recursive(num * 10 + 7);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] in = br.readLine().split(" ");
        A = Long.parseLong(in[0]);
        B = Long.parseLong(in[1]);

        // Solve & Output
        System.out.println(recursive(4L) + recursive(7L));
    }
}