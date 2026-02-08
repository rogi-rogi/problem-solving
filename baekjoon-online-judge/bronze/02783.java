import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int X = Integer.parseInt(st.nextToken());
        final int Y = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(br.readLine());

        // Solve
        double minPricePerGram = (double) X / Y;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            double pricePerGram = (double) x / y;
            if (pricePerGram < minPricePerGram){
                minPricePerGram = pricePerGram;
            }
        }

        // Output
        System.out.println(minPricePerGram * 1000);
    }
}
