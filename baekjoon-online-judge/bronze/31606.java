import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int X = Integer.parseInt(br.readLine());
        final int Y = Integer.parseInt(br.readLine());

        // Solve & Output
        System.out.println(X + Y + 3);
    }
}
