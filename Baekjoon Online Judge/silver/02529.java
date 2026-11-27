import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] op;
    static ArrayList<String> list = new ArrayList<>();
    private static void permutation(boolean[] visited, String num, int len) {
        if (len == N + 1) {
            list.add(num);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            if (!visited[i]) {
                if (len == 0 || op[len - 1].equals(">") && (num.charAt(len - 1) - '0') > i
                    || op[len - 1].equals("<") && (num.charAt(len - 1) - '0') < i) {
                    visited[i] = true;
                    permutation(visited, num + i, len + 1);
                    visited[i] = false;
                }
            }
        }
    }
  
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        N = Integer.parseInt(br.readLine());
        op = br.readLine().split(" ");

        // Solve
        boolean[] visited = new boolean[10];
        permutation(visited, "", 0);

        // Output
        System.out.println(list.get(list.size()-1)+'\n'+list.get(0));
    }
}
