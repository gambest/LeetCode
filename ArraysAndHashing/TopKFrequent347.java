package ArraysAndHashing;

import java.util.*;

public class TopKFrequent347 {
    public static void main(String[] args) {
        int[] nums = {-1,-1};

        topKFrequent(nums, 1);
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) return nums;

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num:nums){
            if (frequencyMap.get(num)==null){
                frequencyMap.put(num,1);
                continue;
            }
            frequencyMap.put(num, frequencyMap.get(num) + 1);
        }
        System.out.println(frequencyMap.size());
        if (frequencyMap.size()==k){
            int[] kFrequency = new int[k];
            List<Integer> kFrequentsList = new ArrayList<>(frequencyMap.keySet());

            for (int i = 0; i<k;i++){
                kFrequency[i] = kFrequentsList.get(i);
                System.out.println(kFrequency[i]);
                System.out.println(kFrequentsList.get(i));
            }
            return kFrequency;
        }

        System.out.println(frequencyMap);

        List<Integer> frequencyList = new ArrayList<>(frequencyMap.values());
        frequencyList.sort(Comparator.naturalOrder());

        System.out.println(frequencyList);

        int[] higherFrequencies = new int[k];
        for (int i=frequencyList.size() - 1; i>frequencyList.size()-k-1;i--){
            higherFrequencies[i-1]=frequencyList.get(i);
            System.out.println(higherFrequencies[i-1]);
        }

        List<Integer> kFrequentsList = new ArrayList<>();

        for (Integer num:frequencyMap.keySet()){
            Integer frequency = frequencyMap.get(num);
            for (int i = 0; i<k;i++){
                if (frequency == higherFrequencies[i]){
                    kFrequentsList.add(num);
                    System.out.println("Added:" + num);
                }
            }
        }

        System.out.println(kFrequentsList);
        int[] kFrequency = new int[k];

        for (int i = 0; i<k;i++){
            kFrequency[i] = kFrequentsList.get(i);
            System.out.println(kFrequency[i]);
            System.out.println(kFrequentsList.get(i));
        }

        return kFrequency;
    }
}
