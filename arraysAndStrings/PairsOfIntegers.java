// Pairs with Sum: Design an algorithm to find all pairs of integers within an array
// which sum to a specified value
// Cracking the Coding Interview: Pg 520
// I was asked this in Meta Interview of 2024

public List<Pair> getPairs(int[] array, int sum) {
    Map<Integer, Integer> unpairedMap = new HashMap<>();
    List<Pair> result = new ArrayList<>();
    for (int x : array) {
        int comp = sum - x;
        if (unpairedMap.getOrDefault(comp, 0) > 0) {
            adjustCounter(unpairedMap, comp, -1);
            result.add(new Pair<>(x, comp));
        } else {
            adjustCounter(unpairedMap, x, 1); // x is unpaired
        }
    }
}

private void adjustCounter(Map<Integer, Integer> map, int key, int delta) {
    map.put(key, map.getOrDefault(key, 0) + delta);
}


// Another approach: sort array and have two pointers, first and last
public List<Pair> getPairsSorted(int[] array, int sum) {
    Arrays.sort(array);
    List<Pair> result = new ArrayList<>();
    int first = 0;
    int last = array.length - 1;
    while (first < last) {
        int s = array[first] + array[last];
        if (s < sum) { // need a larger number so move right
            first++;
        } else {
            last--;
        }
        if (s == sum) {
            result.add(new Pair(array[first], array[last]));
            first++;
            last--;
        }
    }
    return result;
}