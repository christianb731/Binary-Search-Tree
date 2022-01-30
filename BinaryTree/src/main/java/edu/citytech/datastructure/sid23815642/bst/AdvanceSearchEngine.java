package edu.citytech.datastructure.sid23815642.bst;

import com.jbbwebsolutions.bst.EnumComparison;
import com.jbbwebsolutions.bst.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import static edu.citytech.datastructure.sid23815642.bst.TreeHelper.*;
public class AdvanceSearchEngine <T extends Comparable<T>> extends  CustomSearchEngine<T>{
    @Override
    public List<T> findAll(Node<T> node, T value, Predicate<EnumComparison> predicate, BiConsumer<T, Long> biConsumer){
        List<T> outputList = new ArrayList<>();
        AtomicLong h = new AtomicLong(0);
        find(node, value, predicate, e -> {outputList.add(e);}, (T e1, Long e2) -> {biConsumer.accept(e1,e2);} );
        return outputList;
    }
    private Node<T> find(Node<T> node, T value, Predicate<EnumComparison> predicate, Consumer<T> consumer, BiConsumer<T,Long> consumer2) {
        boolean greaterThan = predicate.test(EnumComparison.GREATER_THAN);
        boolean equalTo = predicate.test(EnumComparison.EQUAL);
        boolean lessThan = predicate.test(EnumComparison.LESS_THAN);
        if(greaterThan && lessThan){
            if(isEqual(node.value,value)) {
                if(equalTo)
                    consumer.accept(node.value);
                consumer2.accept(node.value, 1L);
                traversePreOrder(node.leftChild, e -> consumer.accept(e));
                traversePreOrder(node.rightChild, e -> consumer.accept(e));
            }
            if (isLessThan(node.value, value)) {
                consumer2.accept(node.value, 1L);
                traversePreOrder(node.leftChild, e -> consumer.accept(e));
                if (!isEmpty(node.rightChild))
                    return find(node.rightChild, value, predicate, consumer, consumer2);
            }
            if (isGreaterThan(node.value, value)) {
                consumer2.accept(node.value, 1L);
                traversePreOrder(node.rightChild, e -> consumer.accept(e));
                if (!isEmpty(node.leftChild))
                    return find(node.leftChild, value, predicate, consumer, consumer2);
            }
        }
        else if (greaterThan){
            if(isEqual(node.value, value)){
                if(equalTo) {

                    consumer.accept(node.value);
                }
            }
            if(isGreaterThan(node.value, value)){
                consumer.accept(node.value);
                consumer2.accept(node.value, 1L);
                traversePreOrder(node.rightChild, e -> consumer.accept(e));
                if(!isEmpty(node.leftChild))
                    return find(node.leftChild, value,predicate,consumer, consumer2);
            }
            else{
                consumer2.accept(node.value, 1L);
                if(!isEmpty(node.rightChild))
                    return find(node.rightChild, value,predicate,consumer, consumer2);
            }
        }
        else if (lessThan){
            if(isEqual(node.value, value)) {
                if (equalTo) {
                    consumer2.accept(node.value, 1L);
                    consumer.accept(node.value);
                }
            }
            if(isLessThan(node.value, value)){
                consumer.accept(node.value);
                consumer2.accept(node.value, 1L);
                traversePreOrder(node.leftChild, e -> consumer.accept(e));
                if(!isEmpty(node.rightChild))
                    return find(node.rightChild, value,predicate,consumer, consumer2);
            }
            else{
                consumer2.accept(node.value, 1L);
                if(!isEmpty(node.leftChild))
                    return find(node.leftChild, value,predicate,consumer, consumer2);
            }
        }
        else if(equalTo){
            if(isEqual(node.value, value)) {
                consumer2.accept(node.value, 1L);
                consumer.accept(node.value);
            }
            else if(isGreaterThan(node.value, value)){
                consumer2.accept(node.value, 1L);
                return find(node.leftChild, value, predicate,consumer, consumer2);
            }
            else if(isLessThan(node.value, value)) {
                consumer2.accept(node.value, 1L);
                return find(node.rightChild, value, predicate, consumer, consumer2);
            }
        }

        return node;
    }
}
