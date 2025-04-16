package ArraysAndHashing;

import java.util.Arrays;

public class ProductExceptSelf238 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] prefixProduct = new int[nums.length];
        int[] postfixProduct = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixProduct[0] = nums[0];
                postfixProduct[0] = nums[nums.length - 1];
                System.out.println("Prefix:" + prefixProduct[0]);
                System.out.println("Postfix:" + postfixProduct[0]);
                continue;
            }
            prefixProduct[i] = nums[i] * prefixProduct[i - 1];
            System.out.println("prefixProduct[i] = " + nums[i] + "*"  + prefixProduct[i - 1]);
            postfixProduct[i] = nums[nums.length - 1 - i] * postfixProduct[i-1];
            System.out.println("prefixProduct[i] = " + nums[nums.length - 1 - i] + "*"  + postfixProduct[i-1]);
            System.out.println("Prefix:" + prefixProduct[i]);
            System.out.println("Postfix:" + postfixProduct[i]);
        }
        System.out.println(Arrays.toString(prefixProduct));
        System.out.println(Arrays.toString(postfixProduct));
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                answer[i] = postfixProduct[nums.length-2];
                continue;
            }
            if (i == nums.length-1) {
                answer[nums.length-1] = prefixProduct[nums.length-2];
                continue;
            }
            answer[i] = prefixProduct[i-1] * postfixProduct[nums.length-2-i];
        }

        return answer;
    }
}
