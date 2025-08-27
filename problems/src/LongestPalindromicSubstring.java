//Manacher’s algorithm
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        char[] T = preprocess(s);    // "^#a#b#...#$
        int m = T.length;

        int[] P = new int[m];      // palindrome radii in T
        int C = 0, R = 0;            // current center and rightmost boundary
        int bestCenter = 0, bestLen = 0;

        for (int i = 1; i < m - 1; i++) {
            int mirror = 2 * C - i;

            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }

            // Try to expand beyond current radius
            while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) {
                P[i]++;
            }

            // Update rightmost reach
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }

            if (P[i] > bestLen) {
                bestLen = P[i];
                bestCenter = i;
            }
        }

        int start = (bestCenter - bestLen) / 2;      // map back to s
        return s.substring(start, start + bestLen);
    }

    private char[] preprocess(String s) {
        StringBuilder sb = new StringBuilder(2 * s.length() + 3);
        sb.append('^');
        for (int i = 0; i < s.length(); i++) {
            sb.append('#').append(s.charAt(i));
        }
        sb.append("#$");
        return sb.toString().toCharArray();
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        String input = "babad";
        String result = solution.longestPalindrome(input);
        System.out.println("Input: " + input);
        System.out.println("Longest Palindromic Substring: " + result);
    }
}
