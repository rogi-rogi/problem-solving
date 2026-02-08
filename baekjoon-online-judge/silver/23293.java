import java.io.*;
import java.util.*;

class Player {
    int no;
    int location;
    int[] item;

    public Player(int no) {
        this.no = no;
        this.location = 1;
        this.item = new int[54];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> cheating = new ArrayList<>();
        Set<Integer> blackSet = new HashSet<>();

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int T = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        // Solve
        Player[] players = new Player[N + 1];
        for (int i = 1; i <= N; i++) {
            players[i] = new Player(i);
        }
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            final int log = Integer.parseInt(st.nextToken());
            final int no = Integer.parseInt(st.nextToken());
            final String action = st.nextToken();
            final int arg = Integer.parseInt(st.nextToken());

            switch (action) {
                case "M":
                    players[no].location = arg;
                    break;
                case "F":
                    ++players[no].item[arg];
                    if (players[no].location != arg) {
                        cheating.add(log);
                    }
                    break;
                case "C":
                    int otherItem = Integer.parseInt(st.nextToken());
                    if (players[no].item[arg] <= 0 ||
                            players[no].item[otherItem] <= 0) {
                        cheating.add(log);
                    }
                    if (players[no].item[arg] > 0) {
                        --players[no].item[arg];
                    }
                    if (players[no].item[otherItem] > 0) {
                        --players[no].item[otherItem];
                    }
                    break;
                case "A":
                    if (players[no].location != players[arg].location) {
                        cheating.add(log);
                        blackSet.add(no);
                    }
                    break;
            }
        }

        cheating.sort(null);
        List<Integer> blackList = new ArrayList<>(blackSet);
        blackList.sort(null);

        // Output
        StringBuilder sb = new StringBuilder();
        sb.append(cheating.size()).append('\n');
        for (Integer log : cheating) {
            sb.append(log).append(' ');
        }
        if (!cheating.isEmpty()) {
            sb.append('\n');
        }
        sb.append(blackList.size()).append('\n');
        for (Integer black : blackList) {
            sb.append(black).append(' ');
        }

        System.out.println(sb);
    }
}