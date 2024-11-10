import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        char[] S = br.readLine().toCharArray();

        // Solve
        for (char c : S) {
            if ('A' <= c && c <= 'Z') {
                sb.append(c - 'A' + 27);
            } else if ('a' <= c && c <= 'i') {
                sb.append('0').append(c - 'a' + 1);
            } else if ('j' <= c && c <= 'z') {
                sb.append(c - 'a' + 1);
            } else if ('0' <= c && c <= '9') {
                sb.append('#').append(c);
            } else {
                sb.append(c);
            }
        }

        // Output
        System.out.println(sb);
    }
}
