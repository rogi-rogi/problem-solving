import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int X = Integer.parseInt(br.readLine());

        // Solve & Output
        System.out.println("UOS".charAt((X - 1) % 3));
    }
}
