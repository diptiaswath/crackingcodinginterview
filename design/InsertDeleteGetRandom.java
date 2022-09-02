package design;

import java.util.*;

//https://leetcode.com/problems/insert-delete-getrandom-o1/solution/
public class InsertDeleteGetRandom {
    Map<Integer, Integer> hashmap;
    List<Integer> list;
    Random rand;

    public InsertDeleteGetRandom() {
        this.hashmap = new HashMap<>();
        this.list = new ArrayList<Integer>();
        this.rand = new Random();
    }

    public boolean insert(int val) {
        if (hashmap.containsKey(val)) {
            return false;
        }
        hashmap.put(val, list.size());
        list.add(list.size(), val);
        return true;
    }

    public boolean remove(int val) {
        if (!hashmap.containsKey(val)) {
            return false;
        }
        // get idx of val in hashmap
        int idx = hashmap.get(val);

        // put the last element of list into idx
        list.set(idx, list.get(list.size() - 1));
        hashmap.put(list.get(list.size() - 1), idx);

        // delete the last element in list
        list.remove(list.size() - 1);
        hashmap.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
