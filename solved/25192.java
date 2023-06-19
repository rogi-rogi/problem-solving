import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.HashMap;
import java.util.HashSet;

public class BOJ25192 {
    public static void main(String[] args) throws IOException {
        // init
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//        HashMap<String, Void> nameList = new HashMap<>();
        HashSet<String> nameList = new HashSet<>();

        // input
        int N = Integer.parseInt(bfr.readLine());
        int cnt = 0;

        // solution
        while (N-- > 0) {
            String name = bfr.readLine();
            if (name.equals("ENTER")) {
                nameList.clear();
                continue;
            }
//            if (!nameList.containsKey(name)) {
//                nameList.put(name, null);
//                cnt += 1;
//            }
            if (nameList.add(name)) cnt += 1;
        }

        // output
        System.out.println(cnt);
    }
}
