import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        StringBuilder sb = new StringBuilder();

        // Input
        double avg = 0;
        int cnt = 0;
        String[] gradeNameList = {"A+", "A0", "B+", "B0", "C+", "C0", "D+", "D0"};
        double[] gradeList = {4.5, 4.0, 3.5, 3.0, 2.5, 2.0, 1.5, 1.0};
        for (int i = 0; i < 20; ++i) {
            line = br.readLine().split(" ");
            String grade = line[2];

            // Solve
            if (grade.equals("P")) continue;
            double credit = Double.parseDouble(line[1]);
            for (int j = 0; j < 8; ++j) {
                if (grade.equals(gradeNameList[j])) {
                    avg += credit * gradeList[j];
                    break;
                }
            }
            cnt += credit;
        }

        // Output
        System.out.println(avg / cnt);
    }
}
