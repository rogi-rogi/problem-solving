import java.io.*;
import java.util.*;

public class Main {
    private static String getGrade(int score) {
        if (score >= 97) return "A+";
        if (score >= 90) return "A";
        if (score >= 87) return "B+";
        if (score >= 80) return "B";
        if (score >= 77) return "C+";
        if (score >= 70) return "C";
        if (score >= 67) return "D+";
        if (score >= 60) return "D";
        return "F";
    }

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // Input
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            sb.append(String.format("%s %s\n", st.nextToken(), getGrade(Integer.parseInt(st.nextToken()))));
        }

        // Output
        System.out.println(sb);
    }
}