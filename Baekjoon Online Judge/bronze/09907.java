import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final char[] S = br.readLine().toCharArray();

        // Solve
        int[] weight = {2, 7, 6, 5, 4, 3, 2};
        int id = 0;
        for (int i = 0; i < 7; ++i) {
            id += (S[i] - '0') * weight[i];
        }

        // Output
        System.out.println("JABCDEFGHIZ".charAt(id % 11));
    }
}
