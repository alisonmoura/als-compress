/**
 * Created by alisonmoura on 04/09/16.
 */
public class Node <V,W extends Number>{

    private V val;
    private W weight;
    private Node left;
    private Node right;

    public V getVal() {
        return val;
    }

    public void setVal(V val) {
        this.val = val;
    }

    public W getWeight() {
        return weight;
    }

    public void setWeight(W weight) {
        this.weight = weight;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
