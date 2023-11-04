import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        // solve
        int minPriceOfPackage = 1000;
        int minPriceOfSingle = 1000;
        for (int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());
            int priceOfPackage = Integer.parseInt(st.nextToken());
            int priceOfSingle = Integer.parseInt(st.nextToken());
            if (priceOfPackage < minPriceOfPackage) minPriceOfPackage = priceOfPackage;
            if (priceOfSingle < minPriceOfSingle) minPriceOfSingle = priceOfSingle;
        }

        int money = 0;
        if (minPriceOfPackage < minPriceOfSingle * 6) {
            money += (N / 6) * minPriceOfPackage;
            money += Math.min(minPriceOfPackage, minPriceOfSingle * (N % 6));
        } else money += minPriceOfSingle * N;

        // output
        System.out.println(money);
    }
}
