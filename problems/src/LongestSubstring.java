import java.util.Arrays;
import java.util.LinkedList;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        if(s.trim().isEmpty()) return 1;
        char[] arr = s.toCharArray();
        int[] last = new int[256];
        Arrays.fill(last,-1);
        int result = 0;
        int left =0;
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(last[c] >= left){
                left = last[c]+1;
            }
            last[c] = i;
            result = Math.max(result,i-left+1);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring(s));

    }
}
