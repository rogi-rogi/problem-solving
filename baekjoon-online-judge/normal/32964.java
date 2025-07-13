import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        char[] up = br.readLine().toCharArray();
        char[] down = br.readLine().toCharArray();

        // Solve
        boolean goUp = true, goDown = (down[0] == 'L');
        for (int i = 1; i < N - 1; ++i) {
            boolean goUpAndNext = false, goDownAndNext = false;
            if (goUp) {
                if (up[i] == 'I') {
                    goUpAndNext = true;
                } else if (up[i] == 'L' && down[i] == 'L') {
                    goDownAndNext = true;
                }
            }
            if (goDown) {
                if (down[i] == 'I') {
                    goDownAndNext = true;
                } else if (down[i] == 'L' && up[i] == 'L') {
                    goUpAndNext = true;
                }
            }
            goUp = goUpAndNext;
            goDown = goDownAndNext;
        }

        // Output
        System.out.println(
                goDown || goUp && up[N - 1] == 'L' ? "YES" : "NO"
        );
    }
}