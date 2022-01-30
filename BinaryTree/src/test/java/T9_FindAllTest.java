import com.jbbwebsolutions.bst.EnumComparison;
import edu.citytech.datastructure.sid23815642.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid23815642.bst.AdvanceSearchEngine;
import edu.citytech.datastructure.sid23815642.bst.BinarySearchTree;
import edu.citytech.datastructure.sid23815642.model.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;

public class T9_FindAllTest {
    Product[] aProducts = {new Product("p1", 76f), new Product("p2", 40f), new Product("p2b", 10f)
            , new Product("p3", 96f), new Product("p4", 100f)
            , new Product("p5", 82f), new Product("p6", 88f), new Product("p4", 9)
            , new Product("p7", 105f)};
Integer[] sampleValues = new Integer[]{4000,3000,5000,6000,4200,4300,4100,5600,7000,2000,2500,1000,3700,3600};

    @Test
    void greaterThan(){
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
        var bst = new BinarySearchTree<Integer>(new AdvanceSearchEngine(),new AVLTreeInsertion());
        bst.insert(sampleValues);
        AtomicLong h = new AtomicLong(0);
        List<Integer> consumerList = new ArrayList<>();
        var list = bst.findAll(4000,predicate, (Integer e1, Long e2) -> {consumerList.add(e1); h.set(e2);});
        System.out.println(list);
        System.out.println(consumerList);
        System.out.println(h);
    }
    @Test
    void equalTo(){
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;
        var bst = new BinarySearchTree<Integer>(new AdvanceSearchEngine(),new AVLTreeInsertion());
        bst.insert(sampleValues);
        AtomicLong h = new AtomicLong(0);
        List<Integer> consumerList = new ArrayList<>();
        var list = bst.findAll(4000,predicate, (Integer e1, Long e2) -> {consumerList.add(e1); h.set(e2);});
        System.out.println(list);
        System.out.println(consumerList);
        System.out.println(h);
    }
    @Test
    void lessThan(){
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN== e;
        var bst = new BinarySearchTree<Integer>(new AdvanceSearchEngine(),new AVLTreeInsertion());
        bst.insert(sampleValues);
        AtomicLong h = new AtomicLong(0);
        List<Integer> consumerList = new ArrayList<>();
        var list = bst.findAll(4000,predicate, (Integer e1, Long e2) -> {consumerList.add(e1); h.set(e2);});
        System.out.println(list);
        System.out.println(h);
    }
    @Test
    void greaterThanOrEqual(){
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
        var bst = new BinarySearchTree<Integer>(new AdvanceSearchEngine(),new AVLTreeInsertion());
        bst.insert(sampleValues);
        predicate = predicate.or(e -> EnumComparison.EQUAL == e); //optional for test but needs to be implemented
        AtomicLong h = new AtomicLong(0);
        List<Integer> consumerList = new ArrayList<>();
        var list = bst.findAll(4000,predicate, (Integer e1, Long e2) -> {consumerList.add(e1); h.set(e2);});
        System.out.println(list);
        System.out.println(h);
    }
    @Test
    void lessThanOrEqual(){
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN== e;
        var bst = new BinarySearchTree<Integer>(new AdvanceSearchEngine(),new AVLTreeInsertion());
        bst.insert(sampleValues);
        predicate = predicate.or(e -> EnumComparison.EQUAL == e);
        AtomicLong h = new AtomicLong(0);
        List<Integer> consumerList = new ArrayList<>();
        var list = bst.findAll(4000,predicate, (Integer e1, Long e2) -> {consumerList.add(e1); h.set(e2);});
        System.out.println(list);
        System.out.println(h);
    }
    @Test
    void greaterAndLessThan(){
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN== e;
        predicate = predicate.or(e -> EnumComparison.GREATER_THAN == e);
        var bst = new BinarySearchTree<Integer>(new AdvanceSearchEngine(),new AVLTreeInsertion());
        bst.insert(sampleValues);
        AtomicLong h = new AtomicLong(0);
        List<Integer> consumerList = new ArrayList<>();
        var list = bst.findAll(4000,predicate, (Integer e1, Long e2) -> {consumerList.add(e1); h.set(e2);});
        System.out.println(list);
        System.out.println(h);
    }
    @Test
    void everything(){
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN== e;
        predicate = predicate.or(e -> EnumComparison.GREATER_THAN == e).or(e -> EnumComparison.EQUAL == e);
        var bst = new BinarySearchTree<Integer>(new AdvanceSearchEngine(),new AVLTreeInsertion());
        bst.insert(sampleValues);
        AtomicLong h = new AtomicLong(0);
        List<Integer> consumerList = new ArrayList<>();
        var list = bst.findAll(4000,predicate, (Integer e1, Long e2) -> {consumerList.add(e1); h.set(e2);});
        System.out.println(list);
        System.out.println(h);
    }
    @Test
    void greaterThanProducts(){
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
        var bst = new BinarySearchTree<Product>(new AdvanceSearchEngine(),new AVLTreeInsertion());
        bst.insert(aProducts);
        AtomicLong h = new AtomicLong(0);
        List<Product> consumerList = new ArrayList<>();
        var list = bst.findAll(new Product(83),predicate, (Product e1, Long e2) -> {consumerList.add(e1); h.set(e2);});
        System.out.println(list);
        System.out.println(consumerList);
        System.out.println(h);
    }
}
