import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int A = Integer.parseInt(br.readLine());
        final int B = Integer.parseInt(br.readLine());
        final int C = Integer.parseInt(br.readLine());
        final int D = Integer.parseInt(br.readLine());
        final int P = Integer.parseInt(br.readLine());

        // Solve & Output
        System.out.println(Math.min(A * P, B + (P <= C ? 0 : (P - C) * D)));
    }
}