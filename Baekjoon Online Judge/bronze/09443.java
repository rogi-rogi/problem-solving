import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int[] cnt = new int[26];
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            // Solve
            ++cnt[br.readLine().charAt(0) - 'A'];
        }
        int res = 26;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] == 0) {
                res = i;
                break;
            }
        }
        
        // Output
        System.out.println(res);
    }
}
