import java.io.*;
import java.util.*;

public class Main {
    static class Driver {
        String name;
        int pos;
        Driver(String name, int pos) {
            this.name = name;
            this.pos = pos;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int T = Integer.parseInt(in[1]);

        List<Driver> drivers = new ArrayList<>(N);

        long sum = 0;
        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            String name = in[0];
            int ti = Integer.parseInt(in[1]);

            // Solve
            sum += ti;

            int pos = (int)((T - (sum % T)) % T);
            drivers.add(new Driver(name, pos));
        }

        drivers.sort(Comparator.comparingInt(d -> d.pos));

        List<String> can = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int j = (i + 1) % N;
            int gap = (drivers.get(j).pos - drivers.get(i).pos + T) % T;
            if (gap > 0 && gap <= 1000) {
                can.add(drivers.get(i).name);
            }
        }

        // Output
        if (can.isEmpty()) {
            System.out.println(-1);
            return;
        }

        Collections.sort(can);
        StringBuilder sb = new StringBuilder();
        for (String s : can) sb.append(s).append(' ');
        System.out.println(sb);
    }
}
