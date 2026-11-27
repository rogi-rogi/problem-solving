import java.io.*;

public class Main {
    private static String solve(char[] S) {
        char[] Y = "YONSEI".toCharArray();
        char[] K = "KOREA".toCharArray();
        int yIdx = 0, kIdx = 0;
        for (char c : S) {
            if (c == Y[yIdx]) {
                ++yIdx;
                if (yIdx == Y.length) {
                    return "YONSEI";
                }
            }
            if (c == K[kIdx]) {
                ++kIdx;
                if (kIdx == K.length) {
                    return "KOREA";
                }
            }
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        char[] S = br.readLine().toCharArray();

        // Solve & Output
        System.out.println(solve(S));
    }
}