import java.io.*;
import java.util.*;

public class Main {
    static class Regional {
        String country;
        double score;
        int slots;

        Regional(String country, double score) {
            this.country = country;
            this.score = score;
            this.slots = 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int N = Integer.parseInt(br.readLine());
        List<Regional> regionals = new ArrayList<>();

        // A1
        // 입력 순서: s p_t p_u r_t r_u f
        // site score = 0.56 * r_u + 0.24 * r_t + 0.14 * p_u + 0.06 * p_t + 0.3 * f
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            String country = st.nextToken();
            final int p_t = Integer.parseInt(st.nextToken());
            final int p_u = Integer.parseInt(st.nextToken());
            final int r_t = Integer.parseInt(st.nextToken());
            final int r_u = Integer.parseInt(st.nextToken());
            final int f   = Integer.parseInt(st.nextToken());
            double score = 0.56 * r_u + 0.24 * r_t + 0.14 * p_u + 0.06 * p_t + 0.3 * f;
            regionals.add(new Regional(country, score));
        }

        // A2
        regionals.sort((a, b)-> Double.compare(b.score, a.score));

        // A3
        final int remaining = N - 6;
        for (Regional reg : regionals) {
            reg.slots = 1;
        }
        int addBase = remaining / 6;
        for (Regional reg : regionals) {
            reg.slots += addBase;
        }
        int addExtra = remaining % 6;
        for (int i = 0; i < addExtra; i++) {
            regionals.get(i).slots++;
        }

        // A4
        int res = 0;
        for (Regional reg : regionals) {
            if (reg.country.equals("Taiwan")) {
                res = reg.slots;
                break;
            }
        }
        System.out.println(res);
    }
}
