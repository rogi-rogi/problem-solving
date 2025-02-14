import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Input
        double[] nums = new double[4];
        nums[0] = Double.parseDouble(st.nextToken());
        nums[3] = Double.parseDouble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        nums[1] = Double.parseDouble(st.nextToken());
        nums[2] = Double.parseDouble(st.nextToken());

        // Solve
        double val = 0;
        int cnt = 0;
        for (int i = 0; i <= 3; ++i) {
            double temp = nums[i]/nums[(1+i)%4] + nums[(3+i)%4]/nums[(2+i)%4];
            if (temp > val) {
                val = temp;
                cnt = i;
            }
        }

        // Output
        System.out.println(cnt);
    }
}
