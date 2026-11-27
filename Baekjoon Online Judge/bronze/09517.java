import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int time = 0;

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");

            // Solve
            time += Integer.parseInt(input[0]);
            if (time >= 210) {
              
                // Output
                System.out.println(K);
                break;
            }
            if (input[1].equals("T")) {
                ++K;
                if (K == 9) K = 1;
            }
        }
    }
}
