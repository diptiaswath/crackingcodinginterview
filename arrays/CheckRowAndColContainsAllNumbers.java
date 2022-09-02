package arrays;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/check-if-every-row-and-column-contains-all-numbers/
public class CheckRowAndColContainsAllNumbers {

    public boolean checkValid(int[][] matrix) {
        Set<String> checkS = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j];
                if (!checkS.add(val + " found in " + i) || !checkS.add(val + " found in " + j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
