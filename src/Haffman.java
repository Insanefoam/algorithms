import java.util.*;

public class Haffman {
    Map<Character, String> map = new HashMap<>();

    public void body(String str) {
        int[] frequencies = new int[256];
        for (int i = 0; i < str.length(); i++) {
            frequencies[(int) str.charAt(i)] += 1;
        }
        PriorityQueue<Node> nodes = new PriorityQueue<>();
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] == 0)
                continue;
            nodes.add(new Node(frequencies[i], (char) i));
        }
        while (nodes.size() != 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();
            Node tmp = new Node(left.weight + right.weight, '*');
            tmp.leftNode = left;
            tmp.rightNode = right;
            nodes.add(tmp);
        }
        //Получаем корень
        Node root = nodes.poll();
        //Выводим дерево
        System.out.println("Вывод дерева Хаффмана:");
        print("", root, true);
        int treeDepth = heightOfTree(root);
        String binaryStr = "";
        char[] charMass = str.toCharArray();
        for (int i = 0; i < charMass.length; i++) {
            binaryStr += Integer.toBinaryString(charMass[i]);
        }
        System.out.println("\n\nИзначальная строка: " + binaryStr);
        System.out.println("Закодированная строка: " + returnTreeCode(root, str));
        System.out.println(map);
    }

    public void printTree(Node n, int dep) {
        LinkedList<Node> queue = new LinkedList<>();
        Node tmp;
        StringBuilder space = new StringBuilder();
        for (int i = 0; i < dep; i++) {
            space.append(" ");
        }

        System.out.print(space);
        System.out.print(n);
        System.out.print(space + "\n");
        space.deleteCharAt(space.length() - 1);
        queue.add(n.leftNode);
        queue.add(n.rightNode);
        queue.add(null);
        do {
            tmp = queue.poll();
            if (tmp == null) {
                System.out.println();
                space.deleteCharAt(space.length() - 1);
                tmp = queue.poll();
                queue.add(null);
            }
            try {
                if (tmp.leftNode != null) {
                    queue.add(tmp.leftNode);
                }
            } catch (NullPointerException e) {
            }
            try {
                if (tmp.rightNode != null) {
                    queue.add(tmp.rightNode);
                }
            } catch (NullPointerException e) {
            }

            System.out.print(space);
            System.out.print(tmp);
        } while (queue.size() != 1);
    }

    int heightOfTree(Node node) {
        if (node.rightNode == null && node.leftNode == null)
            return 1;
        int left, right;
        if (node.leftNode != null) {
            left = heightOfTree(node.rightNode);
        } else
            left = -1;
        if (node.rightNode != null) {
            right = heightOfTree(node.rightNode);
        } else
            right = -1;
        int max = left > right ? left : right;
        return max + 2;
    }

    public void getTreeCode(Node node, String str) {
        if (node != null) {
            map.put(node.symbol, str);
            getTreeCode(node.rightNode, str + "1");
            getTreeCode(node.leftNode, str + "0");
        }
    }

    public String returnTreeCode(Node node, String str) {
        getTreeCode(node, "");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            result.append(map.get(str.charAt(i)));
        }
        return result.toString();
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println(prefix + (isLeft ? "|-- " : "\\-- ") + n.symbol);
            print(prefix + (isLeft ? "|   " : "    "), n.leftNode, true);
            print(prefix + (isLeft ? "|   " : "    "), n.rightNode, false);
        }
    }
}


