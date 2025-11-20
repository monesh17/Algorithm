//Manacher’s algorithm
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;

        char[] newS = preprocess(s);
        int[] palindrome = new int[newS.length];
        int center=0,right=0;
        int bestRad=0,bestCenter=0;
        for(int i=1;i<newS.length-1;i++){
            int mirror = 2 * center - i;
            if(i<right)
                palindrome[i] = Math.min(palindrome[mirror],right-i);
            while(newS[i-1 - palindrome[i]] == newS[i+1 + palindrome[i]]) palindrome[i]++;
            if(i+palindrome[i] > right){
                right = i+palindrome[i];
                center = i;
            }
            if (palindrome[i] > bestRad) { bestRad = palindrome[i]; bestCenter = i; }
        }
        int startInT = bestCenter - bestRad;
        int endInT   = bestCenter + bestRad;
        int start = (startInT - 1) / 2;
        int end   = (endInT - 1) / 2;
        return s.substring(start, end);

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
