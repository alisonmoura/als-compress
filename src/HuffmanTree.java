import java.util.Map;

/**
 * Created by alisonmoura on 04/09/16.
 */
public class HuffmanTree {

    private Node<Character, Integer> root;

    public void createTree(HuffmanMap map){
        int size = map.keySet().size();
        for(int i = 0; i < size; i++){
            Character minor = map.getMinorFrequency();
            Integer frequency = map.get(minor);
            insertLeaf(new HuffmanNode(minor),frequency);
            map.remove(minor);
        }
    }

    private void insertLeaf(Node leaf, Integer frequency){
        if(root == null){
            root = new HuffmanNode(0);
        }
        if(root.getLeft() == null){
            root.setLeft(leaf);
            root.setWeight(root.getWeight() + frequency);
        }
        else if(root.getRight() == null) {
            root.setRight(leaf);
            root.setWeight(root.getWeight() + frequency);
        }else{
            Node newRoot = new HuffmanNode(0);
            newRoot.setLeft(root);
            newRoot.setRight(leaf);
            newRoot.setWeight(root.getWeight() + frequency);
            root = newRoot;
        }
    }

}
