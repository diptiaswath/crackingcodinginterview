public class Reverse {

    // Reverse integer. No check for overflow and underflow
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;

            // Overflow
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE && pop > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            // Underflow
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE && pop < Integer.MIN_VALUE % 10)) {
                return 0;
            }
        }
        return rev;
    }

    // Reverse string
    public void reverse(char[] s) {
        int j = s.length - 1;
        for (int i = 0; i < s.length/2; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
