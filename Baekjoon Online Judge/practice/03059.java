import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            String str = br.readLine();

            // Solve
            int SIZE = str.length();
            boolean[] check = new boolean[26];
            for (int i = 0; i < SIZE; ++i)
                check[str.charAt(i) - 65] = true;
            int sum = 0;
            for (int i = 0; i < 26; ++i)
                if (!check[i]) sum += (65+i);
            sb.append(sum).append("\n");
        }

        // Output
        System.out.println(sb);
    }
}
