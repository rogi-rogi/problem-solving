import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String[] input;
        int l, w, a;
        while (true) {
            input = br.readLine().split(" ");
            l = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);
            a = Integer.parseInt(input[2]);

            // Solve
            if (l + w + a == 0) break;
            if (a == 0) sb.append(String.format("%d %d %d\n", l, w, l * w));
            else if (l == 0){
                sb.append(String.format("%d %d %d\n", a / w, w, a));
            } else if (w == 0){
                sb.append(String.format("%d %d %d\n", l, a / l, a));
            }
        }
        
        // Output
        System.out.println(sb);
    }
}
