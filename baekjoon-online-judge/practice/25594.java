import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String S = br.readLine();

        // Solve
        Map<Character, String> map = new HashMap<>();
        map.put('a', "aespa");
        map.put('b', "baekjoon");
        map.put('c', "cau");
        map.put('d', "debug");
        map.put('e', "edge");
        map.put('f', "firefox");
        map.put('g', "golang");
        map.put('h', "haegang");
        map.put('i', "iu");
        map.put('j', "java");
        map.put('k', "kotlin");
        map.put('l', "lol");
        map.put('m', "mips");
        map.put('n', "null");
        map.put('o', "os");
        map.put('p', "python");
        map.put('q', "query");
        map.put('r', "roka");
        map.put('s', "solvedac");
        map.put('t', "tod");
        map.put('u', "unix");
        map.put('v', "virus");
        map.put('w', "whale");
        map.put('x', "xcode");
        map.put('y', "yahoo");
        map.put('z', "zebra");

        sb.append("It's HG!\n");
        int idx = 0;
        while (idx < S.length()) {
            char c = S.charAt(idx);
            String s = map.get(c);
            if (idx + s.length() <= S.length() && s.equals(S.substring(idx, idx + s.length()))) {
                idx += s.length();
                sb.append(c);
            } else {
                sb = new StringBuilder("ERROR!");
                break;
            }
        }

        // Output
        System.out.println(sb);
    }
}