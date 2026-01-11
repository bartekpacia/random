package problems.top_k_elements_in_list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Top K Frequent Elements: https://neetcode.io/problems/top-k-elements-in-list
// Top K Frequent Elements: https://leetcode.com/problems/top-k-frequent-elements

public class Main {
    public static void main(String[] args) {
        record Input(int[] nums, int k) {
        }
        //@formatter:off
        Input[] inputs = {
                new Input(new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3, 4}, 2),
                new Input(new int[]{7, 7}, 1),
        };
        //@formatter:on

        Solution solution = new SolutionC();
        for (Input input : inputs) {
            int[] result = solution.topKFrequent(input.nums, input.k);
            System.out.println("nums = " + Arrays.toString(input.nums) + ", k = " + input.k + ", answer = " + Arrays.toString(result));
        }
    }
}

interface Solution {
    int[] topKFrequent(int[] nums, int k);
}

class SolutionA implements Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            if (!occurrences.containsKey(num)) {
                occurrences.put(num, 1);
            } else {
                occurrences.put(num, occurrences.get(num) + 1);
            }
        }


        return Arrays.stream(nums).boxed().sorted((a, b) -> Integer.compare(occurrences.get(b), occurrences.get(a))).distinct().limit(k).mapToInt(Integer::intValue).toArray();
    }
}

class SolutionB implements Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        record Entry(int number, int occurrences) {
        }

        PriorityQueue<Entry> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.occurrences - o2.occurrences);
        for (var e : occurrences.entrySet()) {
            Entry entry = new Entry(e.getKey(), e.getValue());
            priorityQueue.offer(entry);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            Entry entry = priorityQueue.poll();
            result[i] = entry.number;
        }
        return result;
    }
}

class SolutionC implements Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int num : nums) {
            if (!occurrenceMap.containsKey(num)) {
                occurrenceMap.put(num, 1);
            } else {
                occurrenceMap.put(num, occurrenceMap.get(num) + 1);
            }
        }

        // nums = [1, 2, 2, 2, 3, 4, 4, 4]
        //
        // Create an array mapping
        // array index (occurences):                     [ 0  1       2   3      4  ... up to n]
        // values that occur this many times (as index): [    [1, 3]  []  [2, 4] [] ...  ]
        List<List<Integer>> counts = new ArrayList<>(nums.length + 1);
        for (int i = 0; i < nums.length + 1; i++) {
            counts.add(new ArrayList<>());
        }

        for (var entry : occurrenceMap.entrySet()) {
            int num = entry.getKey();
            int occurenceCount = entry.getValue();
            counts.get(occurenceCount).add(num);
        }

        int[] result = new int[k];
        int consumedK = 0;
        for (int i = counts.size() - 1; i >= 0; i--) {
            List<Integer> occurenceCounts = counts.get(i);
            for (int occurenceCount : occurenceCounts) {
                if (consumedK < k) {
                    result[consumedK] = occurenceCount;
                    consumedK++;
                } else {
                    break;
                }
            }
            if (consumedK >= k) {
                break;
            }
        }

        return result;
    }
}