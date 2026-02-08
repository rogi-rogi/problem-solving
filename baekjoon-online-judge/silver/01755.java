import java.io.*;
import java.util.*;

class NumWithWord implements Comparable<NumWithWord> {
    static final String[] NUM_WORDS = {
            "ze", "on", "tw", "th", "fo", "fi", "si", "se", "ei", "ni"
    };
    int num;
    String word;

    NumWithWord(int num) {
        this.num = num;
        this.word = toWord(num);
    }

    static String toWord(int num) {
        StringBuilder sb = new StringBuilder();
        for (char c : String.valueOf(num).toCharArray()) {
            sb.append(NUM_WORDS[c - '0']).append(" ");
        }
        return sb.toString().trim(); // 마지막 공백 제거
    }

    @Override
    public int compareTo(NumWithWord o) {
        return this.word.compareTo(o.word);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // Input
        final int M = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        List<NumWithWord> list = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            list.add(new NumWithWord(i));
        }

        // Solve
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).num).append((i + 1) % 10 == 0 ? "\n" : " ");
        }

        // Output
        System.out.println(sb);
    }
}
