package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/intersection-of-two-arrays/solution/
class IntersectArrays {

    //Approach 1 : Uses built in set intersection. O(n+m) avg case, O(n*m) worst case
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i : nums2) {
            set2.add(i);
        }

        set1.retainAll(set2);

        int idx = 0;
        int[] output = new int[set1.size()];
        for (int i : set1) {
            output[idx++] = i;
        }
        return output;
    }

    private int[] intersect(Set<Integer> set1, Set<Integer> set2) {
        int idx = 0;
        int[] output = new int[set1.size()];
        for (int i : set1) {
            if (set2.contains(i)) {
                output[idx++] = i;
            }
        }
        return Arrays.copyOf(output, idx);
    }

    // Approach 2: Uses two sets. Iterate over smaller set check
    // presence of each element in the larger set. O(n+m) complexity
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i : nums2) {
            set2.add(i);
        }

        if (set1.size() < set2.size()) {
            return intersect(set1, set2);
        } else {
            return intersect(set2, set1);
        }
    }

    //Approach3: https://leetcode.com/explore/interview/card/facebook/54/sorting-and-searching-3/3033/
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> visited = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Iterate over num1 and make visited map
        for (int num : nums1) {
            visited.put(num, 1);
        }

        // Iterate over num2 and if it appears in visited, add to result list and make this count as 0
        for (int num : nums2) {
            if (visited.containsKey(num) && visited.get(num) == 1) {
                result.add(num);
                visited.put(num, 0);
            }
        }

        int[] intArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            intArray[i] = result.get(i);
        }
        return intArray;
    }
}
