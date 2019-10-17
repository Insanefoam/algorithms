import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Haffman {

    public void body(String str) {
        int[] frequencies = new int[256];
        int len = 0;
        for (int i = 0; i < str.length(); i++) {
            frequencies[(int) str.charAt(i)] += 1;
        }
        ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] == 0) {
                continue;
            }
            nodes.add(new Node(frequencies[i], (char) i));
        }
        nodes.sort(Comparator.comparingInt(o -> o.weight));
        len = nodes.size();
        for (int i = 0; i < len - 1; i++) {
            Node tmp = new Node(nodes.get(0).weight + nodes.get(1).weight, '\\');
            tmp.leftNode = nodes.get(0);
            tmp.rightNode = nodes.get(1);
            tmp.leftNode.parent = tmp;
            tmp.rightNode.parent = tmp;
            nodes.remove(0);
            nodes.remove(0);
            nodes.add(tmp);
            nodes.sort(Comparator.comparingInt(o -> o.weight));
        }
        Node root = nodes.get(0);
        int level = 0;
        Node tmp = nodes.get(0);
        String space = "\t\t\t\t\t";

        System.out.println(nodes.get(0).leftNode.leftNode);
    }

}
