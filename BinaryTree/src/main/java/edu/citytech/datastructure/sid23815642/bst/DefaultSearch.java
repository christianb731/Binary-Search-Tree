package edu.citytech.datastructure.sid23815642.bst;

import com.jbbwebsolutions.bst.AbstractSearchEngine;
import com.jbbwebsolutions.bst.Node;

import java.util.function.Consumer;

public class DefaultSearch <T extends Comparable<T>> extends AbstractSearchEngine<T> {


    @Override
    public T find(Node<T> root, T value, Consumer<T> consumer) {
        System.out.println("Default Search Executed.");
        T t = null;
        var current = root;

        while (!TreeHelper.isEmpty(current)) {
            consumer.accept(current.value);

            if (TreeHelper.isLessThan(value, current.value)) {
                current = current.leftChild;

            } else if (TreeHelper.isGreaterThan(value, current.value)) {
                current = current.rightChild;


            } else
                return current.value;
        }
        return t;
    }

    private T findMin(Node<T> node) {
        while(!TreeHelper.isEmpty(node.leftChild)){
            node = node.leftChild;
        }
        return node.value;
    }
    private T findMax(Node<T> node) {
        while(!TreeHelper.isEmpty(node.rightChild)){
            node = node.rightChild;
        }
        return node.value;
    }
    
    @Override
    public T min(Node<T> node) {
        return findMin(node);
    }



    @Override
    public T max(Node<T> node) {
       return findMax(node);
    }

}
