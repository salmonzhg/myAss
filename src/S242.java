import java.util.HashMap;
import java.util.Map;

public class S242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] cArray = s.toCharArray();
        char[] sArray = t.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : cArray) {
            Integer got = map.get(c);
            map.put(c, got == null ? 1 : got + 1);
        }

        for (char c : sArray) {
            Integer got = map.get(c);
            if (got == null) {
                break;
            } else {
                if (got == 1) {
                    map.remove(c);
                } else {
                    map.put(c, got - 1);
                }
            }
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        S242 tester = new S242();
        System.out.println(tester.isAnagram("naagram", "nagaram"));
    }
}
