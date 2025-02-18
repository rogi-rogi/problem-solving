import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());

        // Solve
        int happy = 0;
        while (N >= 10) {
            int temp = 1;
            while (N > 0) {
                temp *= N % 10;
                N /= 10;
            }
            N = temp;
            ++happy;
        }

        // Output
        System.out.println(happy);
    }
}