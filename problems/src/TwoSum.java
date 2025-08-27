import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {2,5,5,11};
        int target = 10;
        TwoSum ts = new TwoSum();
        int[] result = ts.twoSum(nums, target);
        for (int j : result) System.out.println(j);
    }
}
