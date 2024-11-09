package arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {

    int removeDuplicates(int[] array) {
        int i = 0;
        for (int j = i + 1; j < array.length; j++) {
            if (array[i] != array[j]) {
                i++;
                array[i] = array[j];
            }
        }
        return i + 1; // return new length of trimmed array
    }
}
