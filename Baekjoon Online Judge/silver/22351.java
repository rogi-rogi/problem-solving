import java.io.*;

public class Main {
    static boolean match(String s, int startNum) {
        int n = s.length();
        int pos = 0;
        int cur = startNum;

        while (pos < n) {
            String numStr = Integer.toString(cur);
            int len = numStr.length();

            if (pos + len > n) return false;
            for (int i = 0; i < len; ++i) {
                if (s.charAt(pos + i) != numStr.charAt(i)) return false;
            }
            pos += len;
            ++cur;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String in = br.readLine();
        int startNum = 0;
        int range = Math.min(3, in.length());

        for (int i = 0; i < range; ++i) {
            startNum = startNum * 10 + (in.charAt(i) - '0');

            if (match(in, startNum)) {
                int pos = 0;
                int x = startNum;
                while (pos < in.length()) {
                    pos += Integer.toString(x).length();
                    ++x;
                }

                // Output
                System.out.println(startNum + " " + (x - 1));
                return;
            }
        }
    }
}
