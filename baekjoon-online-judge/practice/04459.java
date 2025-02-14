import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int q = Integer.parseInt(br.readLine());
        String[] rules = new String[q];
        for (int i = 0; i < q; ++i)
            rules[i] = br.readLine();
        int r = Integer.parseInt(br.readLine());

        // Solve
        while (r-- > 0) {
            int num = Integer.parseInt(br.readLine());
            sb.append("Rule ").append(num);
            if (1 <= num && num <= q) {
                sb.append(": ").append(rules[num - 1]).append("\n");
            } else sb.append(": No such rule\n");
        }

        // Output
        System.out.print(sb);
    }
}
