import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        char[] S = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        int[] cnt = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // Solve
        int idx = Character.toUpperCase(S[0]) - 'A';
        cnt[idx] -= 2;
        if (cnt[idx] < 0) {
            sb.append("-1");
        } else {
            sb.append(S[0]);
            for (int i = 1; i < S.length; ++i) {
                if (S[i] == ' ') {
                    if (S[i - 1] != ' ')
                        --N;
                    if (N < 0) {
                        sb = new StringBuilder("-1");
                        break;
                    }
                } else if(S[i] != S[i - 1]) {
                    if (S[i - 1] == ' ') {
                        sb.append(S[i]);
                    }
                    idx = Character.toUpperCase(S[i]) - 'A';
                    cnt[idx] -= 1 + (S[i - 1] == ' ' ? 1 : 0);
                    if (cnt[idx] < 0) {
                        sb = new StringBuilder("-1");
                        break;
                    }
                }
            }
        }

        // Output
        System.out.println(sb.toString().toUpperCase());
    }
}