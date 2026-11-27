import java.io.*;
import java.util.*;

class Node {
    int no;
    int depth;
    int weight;
    int twinCnt;

    Node(int no, int depth, int weight, int twinCnt) {
        this.no = no;
        this.depth = depth;
        this.weight = weight;
        this.twinCnt = twinCnt;
    }
}

public class Main {
    static final int MAX = 5555;
    static final int L = 0, R = 1;
    static boolean[][] block = new boolean[MAX][2];

    static int D, N, U, T;
    static int pony = 0;
    static int visitedNodeCnt = 0;

    private static int twinTail() {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(1, 1, 0, 0));

        int maxWeight = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            maxWeight = Math.max(maxWeight, node.weight);
            ++visitedNodeCnt;

            if (node.depth == D || (block[node.no][L] && block[node.no][R])) continue;

            final int nextTwinCnt = node.twinCnt + (!block[node.no][L] && !block[node.no][R] ? 1 : 0);
            final int nextWeight = node.weight + U + T * nextTwinCnt;
            if (!block[node.no][L]) {
                queue.add(new Node(node.no << 1, node.depth + 1, nextWeight, nextTwinCnt));
            }
            if (!block[node.no][R]) {
                queue.add(new Node((node.no << 1) + 1, node.depth + 1, nextWeight, nextTwinCnt));
            }
        }
        return maxWeight;
    }

    private static void ponyTail(int depth, int no) {
        --visitedNodeCnt;

        if (depth == D) return;

        if (!block[no][L]) {
            pony += U;
            ponyTail(depth + 1, no << 1);
            if (visitedNodeCnt > 0) {
                pony += U;
            }
        }
        if (!block[no][R]) {
            pony += U;
            ponyTail(depth + 1, (no << 1) + 1);
            if (visitedNodeCnt > 0) {
                pony += U;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input = br.readLine().split(" ");
        D = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        U = Integer.parseInt(input[2]);
        T = Integer.parseInt(input[3]);

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            int S = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);
            block[S][(S << 1) == E ? L : R] = true;
        }

        // Solve
        if (block[1][0] && block[1][1]) {
            System.out.println(":blob_twintail_thinking:");
            return;
        }

        final int twin = twinTail();
        ponyTail(1, 1);

        // Output
        String res = ":blob_twintail_thinking:";
        if (twin < pony) {
            res = ":blob_twintail_aww:";
        } else if (twin > pony) {
            res = ":blob_twintail_sad:";
        }
        System.out.println(res);
    }
}
