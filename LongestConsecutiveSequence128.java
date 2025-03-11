import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveSequence(nums));
    }

    public static int longestConsecutiveSequence(int[] nums){
        Queue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums){
            priorityQueue.add(num);
        }

        int number = priorityQueue.poll();
        int sequenceLength = 1;
        int maxLength = 1;
        int poll;

        while (!priorityQueue.isEmpty()){
            poll = priorityQueue.poll();
            System.out.println("Number: " + number + " Pool: " + poll);
            if (number == poll){
                continue;
            }
            else if (number + 1 == poll){
                System.out.println("São consecutivos; ");
                sequenceLength++;
                System.out.println("Sequencia: " + sequenceLength);
            } else{
                System.out.println("Sequencia quebrada.");
                if (sequenceLength > maxLength) {
                    maxLength = sequenceLength;
                }
                sequenceLength = 1;
            }
            number = poll;
        }
        if (sequenceLength > maxLength) {
            maxLength = sequenceLength;
        }
        return maxLength;
    }
}
