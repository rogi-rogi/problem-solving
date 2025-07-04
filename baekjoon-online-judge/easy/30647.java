import java.io.*;
import java.util.*;

class People implements Comparable<People> {
    String name;
    int score;
    int isHidden;

    public People(String name, int score, int isHidden) {
        this.name = name;
        this.score = score;
        this.isHidden = isHidden;
    }

    @Override
    public int compareTo(People o) {
        if (this.score != o.score) {
            return Integer.compare(o.score, this.score);
        }
        return this.name.compareTo(o.name);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());
        List<People> list = new ArrayList<>();
        while (T-- > 0) {
            String[] tokens = br.readLine().replaceAll("[\\[{\"}\\]]", "").split(",");

            // Solve
            String name = tokens[0].split(":")[1];
            int score = Integer.parseInt(tokens[1].split(":")[1]);
            int isHidden = Integer.parseInt(tokens[2].split(":")[1]);
            list.add(new People(name, score, isHidden));
        }

        // Solve
        Collections.sort(list);
        int rank = 1;
        int prevScore = -1;
        int actualRank = 0;

        for (int i = 0; i < list.size(); ++i) {
            People p = list.get(i);

            if (p.score != prevScore) {
                prevScore = p.score;
                rank = actualRank + 1;
            }
            ++actualRank;
            if (p.isHidden == 0) {
                sb.append(rank).append(" ").append(p.name).append(" ").append(p.score).append("\n");
            }
        }

        // Output
        System.out.println(sb);
    }
}