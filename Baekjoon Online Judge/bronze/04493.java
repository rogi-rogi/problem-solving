import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int t = Integer.parseInt(br.readLine());

        // Solve
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int p1 = 0, p2 = 0;
            while (n-- > 0) {
                String[] res = br.readLine().split(" ");
                if (res[0].equals("R")) {
                    if (res[1].equals("P")) ++p2;
                    else if (res[1].equals("S")) ++p1;
                } else if (res[0].equals("P")){
                    if (res[1].equals("R")) ++p1;
                    else if (res[1].equals("S")) ++p2;
                } else { // S
                    if (res[1].equals("R")) ++p2;
                    else if (res[1].equals("P")) ++p1;
                }
            }
            if (p1 > p2) sb.append("Player 1\n");
            else if (p1 < p2)sb.append("Player 2\n");
            else  sb.append("TIE\n");
        }

        // Output
        System.out.print(sb);
    }
}
