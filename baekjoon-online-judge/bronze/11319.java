import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        int T = Integer.parseInt(br.readLine());
        char[] vowels = new char[]{'A','E','I','O','U','a','e','i','o','u'};

        // Solve
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] S = br.readLine().toCharArray();

            int vowelCnt = 0, consonantCnt = 0;
            for (char chr : S) {
                if (chr == ' ') continue;
                boolean isVowel = false;
                for (char vowel: vowels) {
                    if (chr == vowel) {
                        ++vowelCnt;
                        isVowel = true;
                        break;
                    }
                }

                if (!isVowel) {
                    ++consonantCnt;
                }
            }
            sb.append(consonantCnt).append(' ').append(vowelCnt).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}