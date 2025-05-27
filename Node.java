public class Node {
    public String value;
    public Node next;

    public Node(String val, Node n) {
        value = val;
        next = n;
    }

    public Node(String val) {
        this(val, null);
    }
}