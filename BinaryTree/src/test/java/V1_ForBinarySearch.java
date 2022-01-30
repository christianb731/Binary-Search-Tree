import edu.citytech.datastructure.sid23815642.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid23815642.bst.BinarySearchTree;

public class V1_ForBinarySearch {
    public static void main(String[] args) {
        var bst = new BinarySearchTree(new AVLTreeInsertion());
        bst.insert(42);
        bst.insert(100);
        bst.insert(50);
        bst.insert(30);
        bst.insert(40);
        bst.insert(5);
        bst.insert(7);

        System.out.println(bst);


    }
}
