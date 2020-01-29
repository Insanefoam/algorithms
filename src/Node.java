public class Node implements Comparable<Node> {
    public int weight;
    public char symbol;
    public Node leftNode = null;
    public Node rightNode = null;
    public Node parent = null;

    public Node(int weight, char symbol) {
        this.weight = weight;
        this.symbol = symbol;
    }

    public Node(int weight, char symbol, Node leftNode, Node rightNode) {
        this.weight = weight;
        this.symbol = symbol;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return Character.toString(symbol);
    }


    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
