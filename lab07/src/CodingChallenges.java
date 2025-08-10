import edu.princeton.cs.algs4.Heap;

import java.util.HashMap;

public class CodingChallenges {

    /**
     * Return the missing number from an array of length N containing all the
     * values from 0 to N except for one missing number.
     */
    public static int missingNumber(int[] values) {
        // TODO
        if (values.length == 0) {
            return 0;
        }
        for (int i = 0; i < values.length; i++) {
            boolean get = false;
            for (int j = 0; j < values.length; j++) {
                if (values[j] == i) {
                    get = true;
                    break;
                }
            }
            if (!get) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns true if and only if s1 is a permutation of s2. s1 is a
     * permutation of s2 if it has the same number of each character as s2.
     */
    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            String temp = String.valueOf(s2.charAt(i));
            if (hashMap.containsKey(temp)) {
                hashMap.put(temp, hashMap.get(temp) + 1);
            } else {
                hashMap.put(temp, 1);
            }
        }
        for (int i = 0; i < s2.length(); i++) {
            String temp = String.valueOf(s2.charAt(i));
            Integer geted = hashMap.get(temp);
            if (geted == null || geted == 0) {
                return false;
            } else if (geted == 1) {
                hashMap.remove(temp);
            } else if (geted > 1) {
                hashMap.put(temp, hashMap.get(temp) - 1);
            } else {
                return false;
            }
        }
        // TODO
        return true;
    }
}