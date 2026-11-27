import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());
        TreeSet<Integer> sang = new TreeSet<>();
        TreeSet<Integer> geun = new TreeSet<>();
        boolean[] has = new boolean[2*N + 1];
        for (int i = 0; i < N; ++i) {
            final int card = Integer.parseInt(br.readLine());
            sang.add(card);
            has[card] = true;
        }
        for (int num = 1; num <= 2*N; ++num) {
            if (!has[num]) {
                geun.add(num);
            }
        }

        // Solve
        int prevCard = -1;
        boolean sangTurn = true;
        while (!sang.isEmpty() && !geun.isEmpty()) {
            if (sangTurn) {
                Integer sangCurCard = sang.higher(prevCard);
                if (sangCurCard == null) {
                    prevCard = -1;
                } else {
                    sang.remove(sangCurCard);
                    prevCard = sangCurCard;
                }
            } else {
                Integer geunCurCard = geun.higher(prevCard);
                if (geunCurCard == null) {
                    prevCard = -1;
                } else {
                    geun.remove(geunCurCard);
                    prevCard = geunCurCard;
                }
            }
            sangTurn = !sangTurn;
        }

        // Output
        System.out.println(geun.size());
        System.out.println(sang.size());
    }
}