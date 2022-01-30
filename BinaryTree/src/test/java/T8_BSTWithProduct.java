import edu.citytech.datastructure.sid23815642.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid23815642.bst.BinarySearchTree;
import edu.citytech.datastructure.sid23815642.bst.CustomSearchEngine;
import edu.citytech.datastructure.sid23815642.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class T8_BSTWithProduct {
	static Product[] products;
	static {
		
		Product[] aProducts = {new Product("p1", 76f), new Product("p2", 40f), new Product("p2b", 10f)
				, new Product("p3", 96f), new Product("p4", 100f)
				, new Product("p5", 82f), new Product("p6", 88f), new Product("p4", 9)
				, new Product("p7", 105f)};
		
		products = Arrays.stream(aProducts).toArray(Product[]::new);
		
	}

	@Test
	@DisplayName("Searching by Product")
	void getBasicSearchEngine() {
		var bst = new BinarySearchTree<Product>(new AVLTreeInsertion());
		bst.insert(products);
		var product = bst.find( new Product(105f));
		var actual = 105f;
		var expected = product.getPrice();
	    assertEquals(actual, expected);
	}
	@Test
	void rotateLeft(){
		var bst = new BinarySearchTree<Integer>(new AVLTreeInsertion());
		bst.insert(1500,2000,1750,3000);
		var node = bst.rotateLeft();
		System.out.println(node);
	}
	@Test
	void rotateLeftd(){
		var bst = new BinarySearchTree<Integer>(new AVLTreeInsertion());
		bst.insert(1,2,3,4);
		var node = bst.rotateLeft();
		System.out.println(node);
	}
	@Test
	void rotationRightHeavy(){
		var bst = new BinarySearchTree<Integer>(new AVLTreeInsertion());
		bst.insert(100,200,300);

		System.out.println("");
	}
	@Test
	void rotationLeftHeavy(){
		var bst = new BinarySearchTree<Integer>(new AVLTreeInsertion());
		bst.insert(300,150,200);

		System.out.println("");
	}

}