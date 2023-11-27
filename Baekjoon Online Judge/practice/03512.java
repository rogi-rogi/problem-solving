import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // Input
        int N = Integer.parseInt(st.nextToken());
        final int C = Integer.parseInt(st.nextToken());

        // Solve
        int areaOfBedroom = 0;
        double areaOFBalcony = 0;
        int total = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            String type = st.nextToken();
            if (type.equals("balcony"))  areaOFBalcony += area;
            if (type.equals("bedroom")) areaOfBedroom += area;
            total += area;
        }

        // Output
        System.out.println(total+"\n"+areaOfBedroom+"\n"+(total-areaOFBalcony/2)*C);
    }
}
