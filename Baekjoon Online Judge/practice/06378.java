import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        while (true) {
            String N = br.readLine();
            if (N.equals("0")) break;

            // Solve
            int num = 0;
            int SIZE = N.length();
            for (int i = 0; i < SIZE; ++i) {
                num += N.charAt(i) - '0';
            }
            
            // Output
            System.out.println(getDigitalRoot(num));
        }
    }
    
    private static int getDigitalRoot(int num) {
        if (num < 10) return num;
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return getDigitalRoot(res);
    }
}
