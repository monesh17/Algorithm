import java.util.*;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (t == null || t.isEmpty()) return "";
        if (s == null || s.length() < t.length()) return "";

        int[] need = new int[256];
        int distinct = 0;

        for(char c: t.toCharArray()){
            if(need[c] == 0)
                distinct++;
            need[c]++;
        }
        int[] have = new int[256];
        int formed = 0;
        int l=0;
        int bestLen = Integer.MAX_VALUE;
        int bestL = 0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            have[c]++;
            if(have[c] == need[c])
                formed++;

            while((formed == distinct) && (l<=r)){
                if((r-l+1)< bestLen){
                    bestLen = r-l+1;
                    bestL = l;
                }
                char ch = s.charAt(l++);
                have[ch]--;
                if(have[ch] < need[ch]){
                    formed --;
                }
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestL, bestL + bestLen);

    }

    public static void main(String[] args) {
      String s ="ADOBECODEBANC";
      String t = "ABC";

      String result = minWindow(s,t);
      System.out.println(result);
    }
}
