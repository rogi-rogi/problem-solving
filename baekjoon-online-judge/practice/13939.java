import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        br.readLine();
        String[] sentenceList = br.readLine().split("[.!?]");

        for (String sentence : sentenceList) {
            // Solve
            int cnt = 0;
            for (String word : sentence.trim().split(" ")) {
                if (Character.isUpperCase(word.charAt(0)) && !word.matches(".*\\d.*")) {
                    ++cnt;
                }
            }

            // Output
            System.out.println(cnt);
        }
    }
}
