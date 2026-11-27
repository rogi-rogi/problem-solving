import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line, temp[];
        StringBuilder sb = new StringBuilder();

        // Input &  Solve
        double speed;
        int weight, strength;
        boolean flag;
        while (true) {
            line = br.readLine();
            if (line.equals("0 0 0")) break;
            temp = line.split(" ");
            speed = Double.parseDouble(temp[0]);
            weight = Integer.parseInt(temp[1]);
            strength = Integer.parseInt(temp[2]);
            flag = false;
            if (speed <= 4.5 && weight >= 150 && strength >= 200) {
                sb.append("Wide Receiver ");
                flag = true;
            }
            if (speed <= 6.0 && weight >= 300 && strength >= 500) {
                sb.append("Lineman ");
                flag = true;
            }
            if (speed <= 5.0 && weight >= 200 && strength >= 300) {
                sb.append("Quarterback ");
                flag = true;
            }
            if (!flag) sb.append("No positions\n");
            else sb.append("\n");

        }
        // Output
        System.out.println(sb);
    }
}
