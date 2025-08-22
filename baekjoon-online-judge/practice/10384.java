import java.io.*;


public class Main {
    private static final String[] MSG = {
        "Not a pangram\n",
        "Pangram!\n",
        "Double pangram!!\n",
        "Triple pangram!!!\n"
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        final int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            char[] A = br.readLine().toCharArray();
            int[] count = new int[26];

            // Solve
            for (char a : A) {
                if (Character.isLetter(a)) {
                    if (Character.isUpperCase(a)) {
                        ++count[a - 'A'];
                    } else {
                        ++count[a - 'a'];
                    }
                }
            }

            int min = 3;
            for (int cnt : count) {
                min = Math.min(min, cnt);
            }
            sb.append("Case ").append(i).append(": ")
                .append(MSG[min]);
        }

        // Output
        System.out.println(sb);
    }
}