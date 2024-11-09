// https://www.educative.io/courses/grokking-coding-interview-patterns-java/next-greater-element
// This soultion is based off the first page approach. I wrote it from the outline.
// 1. Create an empty stack and an empty hash map.
// 2. Iterate over nums2, and for each element, compare it with the top element of the stack.
// 3. If the current element of nums2 is greater than the top element, pop the top element and put a key-value pair in the hash map with the popped element as the key and the current element of nums2 as the value.
// 4. Push the current element onto the stack.
// 5. Repeat the process above until we have iterated over all elements in nums2.
// 6. Finally, iterate over nums1, and for each element, append its corresponding value from the hash map to a new array ans and return the ans array as the final result.
public class NextGreater{
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> myStack = new Stack<>();
        Map<Integer, Integer> myNum2Map = new HashMap<>();

        for (int num : nums2) {
            while (!myStack.isEmpty() && num > myStack.peek()) {
                myNum2Map.put(myStack.pop(), num);
            }
            myStack.push(num);
        }

        int[] ans = new int[nums1.length];
        int i = 0;
        for (int num: nums1) {
            int nextGreater = myNum2Map.containsKey(num) ? myNum2Map.get(num): -1; // TIP: OBSERVE THIS
            ans[i++] = nextGreater;
        }

        // Replace this placeholder return statement with your code
        return ans;
    }
}
