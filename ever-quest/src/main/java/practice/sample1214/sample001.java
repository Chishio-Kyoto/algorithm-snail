package practice.sample1214;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class sample001 {
    public static void main(String[] args) {
        // test
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.remove(0);
        randomizedSet.remove(0);
        randomizedSet.insert(0);
        randomizedSet.getRandom();
        randomizedSet.remove(0);
        randomizedSet.insert(0);
        System.out.println(Arrays.toString(randomizedSet.nums.toArray()));
    }

    static class RandomizedSet {

        HashMap<Integer, Integer> numsToLocation;
        ArrayList<Integer> nums;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            numsToLocation = new HashMap<>();
            nums = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (numsToLocation.containsKey(val)) {
                return false;
            }
            numsToLocation.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (!numsToLocation.containsKey(val)) {
                return false;
            }
            int location = numsToLocation.get(val);
            // 替换尾数据并更新尾数据
            // 注意点：先put后remove,应对只有一个值时的情况
            numsToLocation.put(nums.get(nums.size()-1), location);
            numsToLocation.remove(val);
            nums.set(location, nums.get(nums.size()-1));
            nums.remove(nums.size()-1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            Random random = new Random();
            int r = random.nextInt(nums.size());
            return nums.get(r);
        }
    }
}
