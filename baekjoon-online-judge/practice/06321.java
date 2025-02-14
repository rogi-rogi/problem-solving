import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        final int N = Integer.parseInt(br.readLine());

        for (int no = 1; no <= N; ++no) {
            char[] name = br.readLine().toCharArray();
            // Solve
            for (int i = 0; i < name.length; ++i) {
                name[i] = (char) ((name[i] - 'A' + 1) % 26 + 'A');
            }
            sb.append("String #").append(no).append("\n");
            sb.append(name).append("\n\n");
        }

        // Output
        System.out.println(sb);
    }
}
