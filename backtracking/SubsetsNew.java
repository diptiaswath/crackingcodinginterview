import java.util.*;

// https://www.educative.io/courses/grokking-coding-interview-patterns-java/solution-subsets
// O(n * 2^n)
class FindSubsets {
    static int getBit(int num, int bit) {
        // shifts the first operand the specified number of bits to the left
        int temp = (1 << bit);

        // if binary number and current subset count are equal,
        // return 1 else return 0
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }

    public static List<List<Integer>> findAllSubsets(int[] nums) {
        List<List<Integer>> setsList = new ArrayList<>();
        if (nums.length != 0) {
            // finds number of subsets by taking power of length of input array
            int subsetsCount = (int) (Math.pow(2, nums.length));

            for (int i = 0; i < subsetsCount; ++i) {
                // Set is created to store each subset
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < nums.length; ++j) {
                    // if a specific bit is 1, chooses that number from the original set
                    // and add it to the current subset
                    if (getBit(i, j) == 1) {
                        int x = nums[j];
                        subset.add(x);
                    }
                }
                System.out.println("\tCurrent generated subset: "+ subset.toString());
                // all subsets are now pushed back in the set list
                setsList.add(subset);
                System.out.println("\tSubsets list: "+ setsList.toString()+"\n");
            }
        } else {
            List<Integer> emptySet = new ArrayList<>();
            setsList.add(emptySet);
        }
        return setsList;
    }

    public static void main(String[] args) {
        int[][] inputSets = {
                {},
                {2, 5, 7},
                {1, 2},
                {1, 2, 3, 4},
                {7, 3, 1, 5}
        };

        for (int i = 0; i < inputSets.length; i++) {
            int[] set = inputSets[i];
            System.out.println((i + 1) + ". Set: " + Arrays.toString(set));
            List<List<Integer>> subsets = findAllSubsets(set);
            System.out.println("   Subsets: " + subsets);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
