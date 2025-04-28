import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> listA = new ArrayList<>();
        List<Integer> tempA = new ArrayList<>();
        List<Integer> tempB = new ArrayList<>();

        // Solve
        Arrays.sort(A);
        Arrays.sort(B);
        int a = 0, b = 0, cnt = 0;
        while (a < N && b < N) {
            if (A[a] == B[b]) {
                listA.add(A[a++]);
                ++b;
                ++cnt;
            } else if (A[a] < B[b]) {
                tempA.add(A[a++]);
            } else {
                tempB.add(B[b++]);
            }
        }

        // Output
        sb.append(cnt).append("\n");
        for (Integer e : listA) {
            sb.append(e).append(" ");
        }
        for (Integer e : tempA) {
            sb.append(e).append(" ");
        }
        while (a < N) {
            sb.append(A[a++]).append(" ");
        }
        sb.append('\n');

        for (Integer e : listA) {
            sb.append(e).append(" ");
        }
        for (Integer e : tempB) {
            sb.append(e).append(" ");
        }
        while (b < N) {
            sb.append(B[b++]).append(" ");
        }
        System.out.println(sb);
    }
}