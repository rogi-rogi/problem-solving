import java.io.*;
import java.util.*;

public class Main {

    private static int solve(int N, int target, PriorityQueue<Integer> maxHeap) {
        if (N == 1) return 0;

        int cnt = 0;
        while (target <= maxHeap.peek()) {
            maxHeap.add(maxHeap.poll() - 1);
            ++cnt;
            ++target;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int target = Integer.parseInt(br.readLine());
        for (int i = 1; i < N; ++i) {
            maxHeap.add(Integer.parseInt(br.readLine()));
        }

        // Solve & Output
        System.out.println(solve(N, target, maxHeap));
    }
}