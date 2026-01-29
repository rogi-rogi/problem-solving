import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String in = br.readLine();
            if (in.equals("yonsei")) {
                System.out.println("Yonsei Won!");
                break;
            } else if (in.equals("korea")) {
                System.out.println("Yonsei Lost...");
                break;
            }
        }
    }
}
