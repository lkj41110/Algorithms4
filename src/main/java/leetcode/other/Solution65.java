package leetcode.other;


import java.util.HashMap;
import java.util.Map;

/**
 * -10  1  2  3  9  10
 */
public class Solution65 {

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        String minStr = s;
        int l = 0;
        int r = 0;
        boolean find = false;
        Map<Character, Integer> tMap = getMap(t);
        Map<Character, Integer> tempMap = new HashMap<>();

        do {

            while ((r - l < t.length() || !check(tempMap, tMap)) && r < s.length()) {
                char ch = s.charAt(r);
                Integer integer = tempMap.getOrDefault(ch, 0);
                tempMap.put(ch, ++integer);
                r++;
            }

            if ( check(tempMap, tMap) && (r - l < minStr.length()||!find)) {
                minStr = s.substring(l, r);
                find = true;
            }

            Integer integer = tempMap.get(s.charAt(l));
            tempMap.put(s.charAt(l), integer - 1);
            l++;

        } while (l < s.length());
        return find == false ? "" : minStr;
    }

    public boolean check(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        for (Map.Entry<Character, Integer> en : map2.entrySet()) {
            Integer integer = map1.getOrDefault(en.getKey(), 0);
            if (integer < en.getValue()) {
                return false;
            }
        }
        return true;
    }

    public Map<Character, Integer> getMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer integer = map.getOrDefault(ch, 0);
            map.put(ch, ++integer);
        }
        return map;
    }

    public static void main(String[] args) {
        Solution65 solution65 = new Solution65();
        String s = solution65.minWindow("AB", "ABC");
        System.out.println(s);
    }

}