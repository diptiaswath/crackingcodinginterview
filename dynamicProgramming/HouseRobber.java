package dynamicProgramming;

//https://leetcode.com/problems/house-robber/solution/
// Time: O(N)
public class HouseRobber {

    // Use a table to store the result of our sub problems
    // maxRobbedAmount table of length N + 1

    // 1. Set maxRobbedAmount[N] = 0, since there are no more houses left to rob
    // 2. Set maxRobbedAmount[N-1] = nums[N - 1] profit from robbing last house


    //At each step, the robber has two options.
    // If he chooses to rob the current house, he will have to skip the next house on the list by moving two steps forward.
    // If he chooses not to rob the current house, he can simply move on to the next house in the list. Let's see this mathematically.
    //robFrom(i)=max(robFrom(i+1),robFrom(i+2)+nums(i))

    // 3. Iterate from N-2 to 0 and set maxRobbedAmount[i] = max(maxRobbedAmount[i+1], maxRobbedAmount[i+2] + nums[i])
    // 4. return the maxRobbedAmount[0]
    public int rob(int[] nums) {
        int N = nums.length;
        if (nums.length == 0) {
            return 0;
        }

        int[] maxRobbedAmount = new int[N + 1];
        maxRobbedAmount[N] = 0;
        maxRobbedAmount[N-1] = nums[N-1];

        for (int i = N-2; i>=0; i--) {
            maxRobbedAmount[i]= Math.max(maxRobbedAmount[i+1], maxRobbedAmount[i+2] + nums[i]);
        }

        return maxRobbedAmount[0];

    }

}
