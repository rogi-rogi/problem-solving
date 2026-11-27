import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // Init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        br.readLine();

        // Solve
        HashMap<Integer, Integer> hashMap = new LinkedHashMap<>();
        int key;
        for (String num : br.readLine().split(" ")) {
            key = Integer.parseInt(num);
            if (hashMap.containsKey(key)) {
                hashMap.replace(key, hashMap.get(key) + 1);
            } else {
                hashMap.put(key, 1);
            }
        }

        ArrayList<Integer> res = new ArrayList<>(hashMap.keySet());
        res.sort((o1, o2) -> Integer.compare(hashMap.get(o2), hashMap.get(o1)));

        // Output
        for (Integer cnt : res) {
            for (int i = 0; i < hashMap.get(cnt); ++i)
                sb.append(cnt).append(" ");
        }
        System.out.println(sb);

    }
}
