import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {
    public static boolean containsDuplicate(int[] nums){
        Set<Integer> numsSet = new HashSet<>();
        for (int num:nums){
            if (!numsSet.add(num)){
                return true;
            }
        }
        return false;
    }
}