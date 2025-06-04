import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve
        StringBuilder sb = new StringBuilder();
        sb.append("int a;\n");
        if (N >= 1) {
            sb.append("int *ptr = &a;\n");
        }
        if (N >= 2) {
            sb.append("int **ptr2 = &ptr;\n");
        }
        for (int i = 3; i <= N; ++i) {
            sb.append("int ");
            for (int j = 0; j < i; ++j) {
                sb.append("*");
            }
            sb.append("ptr").append(i).append(" = ").append("&ptr").append(i - 1).append(";\n");
        }

        // Output
        System.out.println(sb);
    }
}