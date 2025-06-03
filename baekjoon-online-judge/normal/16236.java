import java.io.*;
import java.util.*;


class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    Point(Node node) {
        this.x = node.x;
        this.y = node.y;
    }
}

class Node extends Point {
    int dist;
    Node(int x, int y, int dist) {
        super(x, y);
        this.dist = dist;
    }
}

class Shark extends Point {
    int size, eatFishCnt, dist;
    Shark(int x, int y) {
        super(x, y);
        this.size = 2;
        this.eatFishCnt = 0;
        this.dist = 0;
    }
    void eatFish(int[][] board, Node node) {
        dist += node.dist;
        x = node.x;
        y = node.y;
        board[x][y] = 0;

        if (++eatFishCnt == size) {
            eatFishCnt = 0;
            ++size;
        }
    }
}


public class Main {
    static int N;
    static int[] dx = new int[]{0, 0, 1, -1}, dy = new int[]{1, -1, 0, 0};
    static int[][] board;

    private static boolean canEat(int x, int y, int size) {
        return 1 <= board[x][y] && board[x][y] <= size;
    }

    private static boolean isValid(Node next, boolean[][] visited, int size) {
        return 0 <= next.x & next.x < N && 0 <= next.y && next.y < N &&
                !visited[next.x][next.y] && board[next.x][next.y] <= size;
    }

    private static Node getNextNode(List<Point> eatFishList, int minDist) {
        if (eatFishList.isEmpty()) {
            return null;
        }
        eatFishList.sort((a, b) -> {
            if (a.x != b.x) return Integer.compare(a.x, b.x);
            return Integer.compare(a.y, b.y);
        });
        Point first = eatFishList.get(0);
        return new Node(first.x, first.y, minDist);
    }

    private static Node bfs(Shark shark) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(shark.x, shark.y, 0));

        boolean[][] visited = new boolean[N][N];
        visited[shark.x][shark.y] = true;
        int minDist = 400;

        List<Point> eatFishList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.dist > minDist) {
                continue;
            }
            for (int d = 0; d < 4; ++d) {
                Node next = new Node(cur.x + dx[d], cur.y + dy[d], cur.dist + 1);
                if (isValid(next, visited, shark.size)) {
                    visited[next.x][next.y] = true;
                    if (canEat(next.x, next.y, shark.size - 1)) {
                        if (next.dist < minDist) {
                            minDist = next.dist;
                            eatFishList.clear();
                            eatFishList.add(new Point(next));
                        } else if (next.dist == minDist) {
                            eatFishList.add(new Point(next));
                        }
                    }
                    queue.add(new Node(next.x, next.y, next.dist));
                }
            }
        }
        return getNextNode(eatFishList, minDist);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; ++i) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // Solve
        int fishCnt = 0;
        Shark shark = null;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (canEat(i, j, 6)) {
                    ++fishCnt;
                } else if (board[i][j] == 9) {
                    shark = new Shark(i, j);
                    board[i][j] = 0;
                }
            }
        }

        while (fishCnt-- > 0) {
            Node next = bfs(shark);
            if (next == null) {
                break;
            }
            shark.eatFish(board, next);
        }

        // Output
        System.out.println(shark.dist);
    }
}