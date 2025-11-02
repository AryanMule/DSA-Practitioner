
import java.util.*;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramSorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);

    }

    public static boolean isAnagramUsingMap(String s, String t) {
        // Step 1: Quick length check
        if (s.length() != t.length()) {
            return false;
        }
        // Step 2: Build frequency map for string s
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // Step 3: Reduce frequency based on string t
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false; // char in t not in s
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) {
                map.remove(c);// clean up to keep map small
            }
        }
        // Step 4: If map empty → perfect match
        return map.isEmpty();
    }

    public static void main(String[] args) {
        // 🔹 Test cases
        String[][] testCases = {
            {"anagram", "nagaram"},
            {"rat", "car"},
            {"listen", "silent"},
            {"aabb", "bbaa"},
            {"hello", "olleh"},
            {"abc", "abcd"}
        };

        System.out.println("✅ Valid Anagram Checker\n");

        for (String[] pair : testCases) {
            String s = pair[0], t = pair[1];
            System.out.println("s = \"" + s + "\", t = \"" + t + "\"");

            System.out.println("Using Array Count: " + isAnagram(s, t));
            System.out.println("Using Sorting:     " + isAnagramSorting(s, t));
            System.out.println("Using HashMap:     " + isAnagramUsingMap(s, t));
            System.out.println("------------------------------------");
        }
    }
}
