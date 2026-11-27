import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        HashSet<String> set = new HashSet<>(List.of(br.readLine().split(" ")));
        
        // Solve
        for (String word : br.readLine().split(" ")) {
            set.remove(word);
        }

        // Output
        System.out.println(set.toArray()[0]);
    }
}
