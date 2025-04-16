package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsHashmap = new HashMap<>();
        int complement;
        for (int i = 0; i < nums.length; i++){
            complement = target - nums[i];
            if (numsHashmap.containsKey(nums[i])) return new int[]{numsHashmap.get(nums[i]), i};
            numsHashmap.put(complement,i);
        }
        return null;
    }
}
