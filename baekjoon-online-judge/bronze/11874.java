import java.io.*;

public class Main {
    public static int sumDigits(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int L = Integer.parseInt(br.readLine());
        final int D = Integer.parseInt(br.readLine());
        final int X = Integer.parseInt(br.readLine());

        // Solve & Output
        for (int i = L; i <= D; i++) {
            if (sumDigits(i) == X) {
                System.out.println(i);
                break;
            }
        }

        for (int i = D; i >= L; i--) {
            if (sumDigits(i) == X) {
                System.out.println(i);
                break;
            }
        }
    }
}
