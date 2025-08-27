import java.util.Arrays;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        int max = 1, count = 1;
        int window = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] == window+1) {
                window = nums[i];
                count++;
            } else if(nums[i] != window){
                max = Math.max(max,count);
                window = nums[i];
                count = 1;
            }
        }
        max = Math.max(max,count);
        return max;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
        int[] nums = {1,0,1,2};
        System.out.println(lcs.longestConsecutive(nums));
    }
}
