import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Haffman {
    public void body(String str) {
        int strLen = str.length();
        int tmp = 0;
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < strLen; i++) {
            try {
                tmp = table.put(str.charAt(i), 1);
            } catch (NullPointerException e) {
                continue;
            }
            if (tmp >= table.get(str.charAt(i))) {
                table.put(str.charAt(i), tmp + 1);
            }
        }
        System.out.println(table);
    }
}
