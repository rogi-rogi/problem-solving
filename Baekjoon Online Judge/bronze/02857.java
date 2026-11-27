import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input & Solve
        int res = -1;
        for (int i = 1; i <= 5; ++i) {
            if (br.readLine().contains("FBI"))
                sb.append(i).append(' ');
        }
        
        // Output
        System.out.println(sb.length() == 0 ? "HE GOT AWAY!" : sb.toString());
    }
}
