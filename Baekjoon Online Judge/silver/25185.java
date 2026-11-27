import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {

    /**
     * 1. 적힌 알파벳이 같으면서 숫자가 연속되는 세 장이 존재한다.
     *    연속한 세 숫자는 서로 다른 숫자여야 한다.
     */
    private static boolean isStraight(String[] cards) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (String card : cards) {
            char suit = card.charAt(1);
            int num = card.charAt(0) - '0';
            map.computeIfAbsent(suit, k -> new ArrayList<>()).add(num);
        }

        for (List<Integer> nums : map.values()) {
            if (nums.size() < 3) {
                continue;
            }
            Set<Integer> setNums = new HashSet<>(nums);
            List<Integer> sortedSetNums = new ArrayList<>(setNums);
            Collections.sort(sortedSetNums);

            if (sortedSetNums.size() >= 3) {
                for (int i = 0; i <= sortedSetNums.size() - 3; i++) {
                    if (sortedSetNums.get(i) + 1 == sortedSetNums.get(i + 1)&&
                        sortedSetNums.get(i + 1) + 1 == sortedSetNums.get(i + 2)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 2. 적힌 알파벳과 숫자가 모두 같은 세 장이 존재한다.
     * {A, A, A, B}
     * {A, A, A, A}
     * {A, B, B, B}
     */
    private static boolean isTripleOrMore(String[] cards) {
        String[] sortedCards = cards.clone();
        Arrays.sort(sortedCards);
        return sortedCards[0].equals(sortedCards[2]) ||
            sortedCards[1].equals(sortedCards[3]);
    }

    /**
     * 3. 두 장씩 짝지었을 때, 짝을 지은 카드끼리 적힌 숫자와 알파벳이 같다.
     * {2, 2} or {4}
     */
    private static boolean isTwoPairOrFour(String[] cards) {
        Map<String, Long> counts = Arrays.stream(cards)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return counts.values().stream()
            .allMatch(count -> count == 2 || count == 4);
    }

    private static boolean isHolyDay(String[] cards) {
        return isStraight(cards) || isTripleOrMore(cards) || isTwoPairOrFour(cards);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // Solve
            sb.append(isHolyDay(br.readLine().split(" ")) ? ":)" : ":(").append("\n");
        }

        // Output
        System.out.println(sb);
    }
}