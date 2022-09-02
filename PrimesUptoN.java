public class PrimesUptoN {

    // To check if a number is prime or not, we simply check
    // if its divisors include anything other than 1 and the number itself.
    public int countPrimes(int n) {

        boolean[] numbers = new boolean[n];

        for (int p = 2; p < (int)Math.sqrt(n); ++p) { // for every prime number less that sqrt(n),
            // we iterate over all multiples of that prime number (p) between p^2 and n
            if (numbers[p] == false) {
                // iterate over all multiples of that prime number p between p * p and n
                for (int j = p * p; j < n; j += p) {
                    numbers[j] = true;
                }
            }
        }

        int countOfPrimes = 0;
        for (int i = 2; i < n; i++) {
            if (numbers[i] == false) {
                System.out.println(i);
                ++countOfPrimes;
            }
        }
        return countOfPrimes;

    }
}
