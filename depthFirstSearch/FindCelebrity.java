// Approach:
// Our code is split into 2 parts.
//The first part finds a celebrity candidate. This requires doing n−1 calls to knows(...) API, and so is O(n)

//The second part is the same as before—checking whether or not a given person is a celebrity. We determined that this is O(n).
// Total O(2n).

// https://leetcode.com/problems/find-the-celebrity/editorial/
public class Solution extends Relation {

    private int numberOfPeople;
    private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();

    @Override
    public boolean knows(int a, int b) {
        if (!cache.containsKey(new Pair(a, b))) {
            cache.put(new Pair(a, b), super.knows(a, b));
        }
        return cache.get(new Pair(a, b));
    }

    public int findCelebrity(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) { // TIP: pick a celebrity candidate.
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) { //TIP this is it. if i is celeb, if celeb knows j or j does not know celeb, then i is not celeb
                return false;
            }
        }
        return true;
    }
}

// TIP: See the Editorial (no video) just code to see how we evolve from O(n^2) to O(2n), and with use of cache