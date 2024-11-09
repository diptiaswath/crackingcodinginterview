// https://leetcode.com/problems/powx-n/editorial/
class Solution {

    /*func pow(x, n):
            if n == 0: return 1
            if n < 0: return 1 / pow(x, -n)*/
    //      return x * pow(x, n - 1)
    // Binary exponentation changes:
    // func binaryExp(x, n):
    //    if n == 0: return 1.0
    //    if n < 0: return 1.0 / binaryExp(x, -n)
    //
    //    if n is odd: return x * binaryExp(x * x, (n - 1) / 2)
    //    otherwise: return binaryExp(x * x, n / 2)
    //


    public double myPow(double x, int n) {
        return binExp(x, (long) n);
    }

    private double binExp(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 1/binExp(x, -n);
        }

        if (n % 2 == 0) {
            return binExp(x * x, n /2);
        } else {
            return x * binExp(x * x, (n - 1) / 2);
        }
    }
}