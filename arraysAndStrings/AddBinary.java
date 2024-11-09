// https://leetcode.com/problems/add-binary/editorial/
import java.math.BigInteger;
class AddBinary {

    // Brute force. If String is too huge, cannot find a 32 bit Integer
    public String addBinary(String a, String b) {
        //Integer binA = Integer.parseInt(a, 2);
        // Integer binB = Integer.parseInt(b, 2);

        // Integer result = binA + binB;
        // return Integer.toBinaryString(result);
        return Integer.toBinaryString(
                Integer.parseInt(a, 2) + Integer.parseInt(b, 2)
        );
    }


    // Alternate: O(N + M) where N = length of a,M = length of b
    public String addBinaryBetter(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }

}