import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);

        // Solve
        int cnt = 0;
        while (Integer.bitCount(N) > K) {
            ++N;
            ++cnt;
        }

        // Output
        System.out.println(cnt);
        /*
        1 1 1 1 1 1 1 1 1 1 1 1 1
        2   2   2   2   2   2   1
        4       4       4       1
        8               4       1
       =1101
       -> 1111
        */
        /*
        1111 1000 0000 0000 0000
        64
        128
        256
        1024
        2048
        4096
        8192
         */
    }
}
