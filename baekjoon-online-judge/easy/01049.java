import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input
        String[] line = (br.readLine()).split(" ");
        final int N = Integer.parseInt(line[0]);
        final int M = Integer.parseInt(line[1]);

        // solve
        int minPriceOfPackage = 1000;
        int minPriceOfSingle = 1000;
        for (int i = 0; i < M; ++i) {
            line = (br.readLine()).split(" ");
            int priceOfPackage = Integer.parseInt(line[0]);
            int priceOfSingle = Integer.parseInt(line[1]);
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
