import java.io.*;

public class Main {

    private static String solve(String in) {
        switch (in) {
            case "animal":
                return "Panthera tigris";
            case "flower":
                return "Forsythia koreana";
            default:
                return "Pinus densiflora";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String in;
        StringBuilder sb = new StringBuilder();
        while ((in = br.readLine()) != null) {
            // Solve
            if (in.equals("end")) break;
            sb.append(solve(in)).append('\n');
        }

        // Output
        System.out.println(sb);
    }
}