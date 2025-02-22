import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int tree_a = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        final int adapter_w = Integer.parseInt(info[0]);
        final int adapter_v = Integer.parseInt(info[1]);

        // Solve & Output
        System.out.println(adapter_w / adapter_v >= tree_a ? 1 : 0);
    }
}
