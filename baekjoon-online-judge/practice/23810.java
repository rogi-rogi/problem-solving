import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        final int N = Integer.parseInt(br.readLine());

        // Solve & Output
        String fullLine = "@".repeat(5 * N);
        String sideLine = "@".repeat(N);

        // 상단 가로줄
        for (int i = 0; i < N; i++) {
            System.out.println(fullLine);
        }

        // 중간 세로줄 (왼쪽만)
        for (int i = 0; i < N; i++) {
            System.out.println(sideLine);
        }

        // 중간 가로줄
        for (int i = 0; i < N; i++) {
            System.out.println(fullLine);
        }

        // 하단 세로줄 (왼쪽만, 두 번 반복)
        for (int i = 0; i < 2 * N; i++) {
            System.out.println(sideLine);
        }
    }
}