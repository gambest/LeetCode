import java.util.*;

public class TopKFrequent347 {
    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};

        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> numberFrequencyMap = new HashMap<>();

        for (int num : nums) {
            Integer put = numberFrequencyMap.put(num, 1);
            if (put != null) {
                numberFrequencyMap.put(num, put + 1);
            }
        }

        List<Integer> numberList = new ArrayList<>(numberFrequencyMap.keySet());
        List<Integer> topKFrequentList = new ArrayList<>();
        int frequency = 0;
        int frequencyNumber = 0;

        for (int i = 0; i < k ;i++) {
            for (Integer number : numberList) {
                if (frequency < numberFrequencyMap.get(number)) {
                    frequency = numberFrequencyMap.get(number);
                    frequencyNumber = number;
                }
            }
            System.out.println("Added: " + frequencyNumber);
            topKFrequentList.add(frequencyNumber);
            numberList.remove(topKFrequentList.get(i));
            frequency = 0;
            System.out.println("i : " + i);
        }

        Integer[] topK = topKFrequentList.toArray(new Integer[k]);

        return Arrays.stream(topK).mapToInt(Integer::intValue).toArray();
    }
}
