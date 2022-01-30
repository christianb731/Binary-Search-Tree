package edu.citytech.datastructure.sid23815642.bst;

import com.jbbwebsolutions.bst.AbstractSearchEngine;
import com.jbbwebsolutions.bst.INumber;
import com.jbbwebsolutions.bst.Node;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static edu.citytech.datastructure.sid23815642.bst.TreeHelper.*;

public class CustomSearchEngine<T extends Comparable<T>> extends AbstractSearchEngine<T> {
    private T binarySearch(Node<T> node, T value, Consumer<T> consumer) {
          consumer.accept(node.value);
          if (isEqual(value, node.value)){
              System.out.println("isEqual = True");
              System.out.println(node.value);
              return node.value;
          }
          else if(isLessThan(value, node.value)){
              return binarySearch(node.leftChild,value,consumer);
          }
          else if (isGreaterThan(value, node.value)){
              return binarySearch(node.rightChild, value, consumer);
          }
          return null;
    }
    @Override
    public T find(Node<T> node, T value, BiConsumer<T, Long> biConsumer) {
        return this.binarySearch(node, value, biConsumer);
    }

    private T binarySearch(Node<T> node, T value, BiConsumer<T, Long> biConsumer) {
        biConsumer.accept(node.value, node.height);
        if (isEqual(value, node.value)){
            return node.value;
        }
        else if(isLessThan(value, node.value)){
            return binarySearch(node.leftChild,value,biConsumer);
        }
        else if (isGreaterThan(value, node.value)){
            return binarySearch(node.rightChild, value, biConsumer);
        }
        return null;
    }
    public T findMin(Node<T> node) {
        while (!isEmpty(node.leftChild)) {
            return findMin(node.leftChild);
        }
        return node.value;
    }
    public T findMax(Node<T> node) {
        while (!isEmpty(node.rightChild)) {
            return findMax(node.rightChild);
        }
        return node.value;
    }

    @Override
    public long height(Node<T> node) {

        if (isEmpty(node))
            return -1;

        if (isEmpty(node.leftChild) && isEmpty(node.rightChild))
            return 0;

        long leftChild = height(node.leftChild);
        long rightChild = height(node.rightChild);

        long max = Math.max(leftChild,rightChild) + 1;
        node.height = max;

        return max;
    }



    @Override
    public void traversePreOrder(Node<T> node, Consumer<T> consumer){
            if(node == null)
                return;

            consumer.accept(node.value);

            traversePreOrder(node.leftChild, consumer);
            traversePreOrder(node.rightChild, consumer);
    }

    @Override
    public double sum(Node<T> node) {
        AtomicReference<Double> total = new AtomicReference<>(0d);
        this.traversePreOrder(node, data -> {
            if (data instanceof Number){
                var $123 = ((Number) data).doubleValue() + total.get();
                total.set($123);
            }
            else if (data instanceof INumber){
                var $123 = ((INumber) data).getNumber() + total.get();
                total.set($123);
            }
        });
        return total.get();
    }

    @Override
    public T min(Node<T> node) {
        return findMin(node);
    }

    @Override
    public T max(Node<T> node) {
        return findMax(node);
    }

    @Override
    public T find(Node<T> root, T value, Consumer<T> consumer) {
        System.out.println("Custom Search Executed");
        return this.binarySearch(root, value, consumer);
    }

}
