package edu.citytech.datastructure.sid23815642.bst;
import com.jbbwebsolutions.bst.Node;
import com.jbbwebsolutions.bst.NodeFacadeInsertion;

import java.util.function.Consumer;
import static edu.citytech.datastructure.sid23815642.bst.TreeHelper.*;

public class AVLTreeInsertion <T extends  Comparable<T>> implements  NodeFacadeInsertion<T>{
    @Override
    public Node<T> insert(Node<T> node, T value, Consumer<Long> consumer) {
        if(isEmpty(node))
            return new Node<>(value);

        if(isLessThan(value, node.value))
            node.leftChild = insert(node.leftChild,value,consumer);
        if(isGreaterThan(value, node.value))
            node.rightChild = insert(node.rightChild,value,consumer);
        setHeight(node);
        node = rotate(node);
        return node;
    }
    private Node<T> rotate(Node<T> node) {
        node.balanceFactor = balanceFactor(node);
        if (isRightHeavy(node)) {

            if (balanceFactor(node.rightChild) > 0)
                node.rightChild = rotateRight(node.rightChild);
            node = rotateLeft(node);
        }
        else if (isLeftHeavy(node)) {
            if (balanceFactor(node.leftChild) < 0)
                node.leftChild = rotateLeft(node.leftChild);
            node = rotateRight(node);
        }
        return node;
    }

    private boolean isRightHeavy(Node<T> node){
        return balanceFactor(node) < -1;
    }
    private boolean isLeftHeavy(Node<T> node){
        return balanceFactor(node) > 1;
    }
    public Node<T> rotateLeft(Node<T> node){
        Node<T> newRoot = node.rightChild;
        node.rightChild = newRoot.leftChild;
        newRoot.leftChild = node;

        setHeight(node);
        setHeight(newRoot);
        node.balanceFactor = balanceFactor(node);
        newRoot.balanceFactor = balanceFactor(newRoot);
        return newRoot;
    }
    public Node<T> rotateRight(Node<T> node){
        Node<T> newRoot = node.leftChild;
        node.leftChild = newRoot.rightChild;
        newRoot.rightChild = node;

        setHeight(node);
        setHeight(newRoot);
        node.balanceFactor = balanceFactor(node);
        newRoot.balanceFactor = balanceFactor(newRoot);
        return newRoot;
    }
    private long balanceFactor(Node<T> node){
        if (isEmpty(node))
            return 0;
        long hLeft = height(node.leftChild);
        long hRight = height(node.rightChild);

        return hLeft - hRight;
    }

    private void setHeight(Node<T> node){
        long hLeft = height(node.leftChild);
        long hRight = height(node.rightChild);
        node.height = Math.max(hLeft,hRight) + 1;
    }
    private long height(Node<T> node){
        if (isEmpty(node))
            return -1;
        return node.height;
    }
}
