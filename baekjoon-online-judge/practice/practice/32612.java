import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
                
        double E = 0;
        for (String X : br.readLine().split(" ")) {
            
            // Solve
            E += (Double.parseDouble(X) + 1) / 2;
        }
        
        // Output
        System.out.println(E);
    }
}
