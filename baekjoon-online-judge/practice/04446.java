import java.io.*;


public class Main {
    static char[] vowels = "aiyeou".toCharArray();
    static char[] consonants = "bkxznhdcwgpvjqtsrlmf".toCharArray();

    private static int isVowels(char chr) {
        return "aiyeou".indexOf(chr);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // Input
        String line;
        while ((line = br.readLine()) != null) {

            char[] input = line.toCharArray();

            // Solve
            for (char chr : input) {
                if (!Character.isLetter(chr)) {
                    sb.append(chr);
                    continue;
                }

                boolean isUpper = Character.isUpperCase(chr);
                char lowerChr = Character.toLowerCase(chr);
                char newChr;

                int idx = isVowels(lowerChr);
                if (idx != -1) {
                    newChr = vowels[(idx + 3) % vowels.length];
                } else {
                    idx = "bkxznhdcwgpvjqtsrlmf".indexOf(lowerChr);
                    newChr = consonants[(idx + 10) % consonants.length];
                }
                sb.append(isUpper ? Character.toUpperCase(newChr) : newChr);
            }
            sb.append("\n");
        }

        // Output
        System.out.println(sb);
    }
}