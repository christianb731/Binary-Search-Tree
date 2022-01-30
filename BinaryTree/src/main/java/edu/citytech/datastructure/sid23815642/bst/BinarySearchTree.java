package edu.citytech.datastructure.sid23815642.bst;
import com.jbbwebsolutions.bst.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class BinarySearchTree<T extends Comparable<T>> implements BSTFacade<T> {
    private Node<T> root;
    private AbstractSearchEngine<T> findEngine = null;
    private NodeFacadeInsertion<T> insertFacade = null;

    public BinarySearchTree(){
        this.findEngine = new DefaultSearch<T>();
        this.insertFacade = new BasicNodeInsertion<>();
    }
    public BinarySearchTree(NodeFacadeInsertion  insertFacade){
        this.findEngine = new DefaultSearch<T>();
        this.insertFacade = insertFacade;
    }
    public BinarySearchTree(AbstractSearchEngine findEngine){
        this.findEngine = findEngine;
        this.insertFacade = new BasicNodeInsertion<>();
    }
    public BinarySearchTree(AbstractSearchEngine findEngine, NodeFacadeInsertion insertFacade){
        this.findEngine = findEngine;
        this.insertFacade = insertFacade;
    }

    @Override
    public void insert(T... values) {
        Arrays.stream(values).forEach(this::insert);
    }

    private long size = 0;

    public void insert(T value){
        this.root = this.insertFacade.insert(root,value, e -> {
            this.size = e;
            this.height();
        });
    }

    public T find(T value){
        return this.find(value, e -> {});
    }

    public T find(T value, Consumer<T> consumer){
     return this.findEngine.find(root, value, consumer);
    }
    public T min(){
        return this.findEngine.min(root);
    }
    public T max(){
        return this.findEngine.max(root);
    }
    public double sum() {return this.findEngine.sum(root);}
    public Node<T> rotateLeft(){
        Node<T> newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        return newRoot;
    }
    public Node<T> rotateRight(Node<T> node){
        Node<T> newRoot = node.leftChild;
        node.leftChild = node.rightChild;
        newRoot.rightChild = node;

        return newRoot;
    }
    @Override
    public List<T> toList() {

        List<T> list = new ArrayList<>();
        this.findEngine.traversePreOrder(this.root, list::add);
        return list;
    }
    @Override
    public List<T> findAll(T value, Predicate<EnumComparison> predicate, BiConsumer<T, Long> biConsumer) {
        return this.findEngine.findAll(root, value, predicate, biConsumer);
    }


    @Override
    public long size() {
        return this.size;
    }

    @Override
    public long height(T t) {
        AtomicLong h = new AtomicLong(-1);
         this.findEngine.find(root, t, (e, height) -> {
            h.set(height);
        });
         return h.get();
    }

    @Override
    public long height() {
        return this.findEngine.height(root);
    }
}
