import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import edu.citytech.datastructure.sid23815642.bst.BinarySearchTree;
import edu.citytech.datastructure.sid23815642.bst.CustomSearchEngine;
import edu.citytech.datastructure.sid23815642.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.jbbwebsolutions.bst.BSTFacade;

class T7_Height {
	
	static Float[] $numbers;	
	static Product[] products;
	static double sum = 0;
	
	static {
		
		Product[] aProducts = {new Product("p1", 76f), new Product("p2", 40f), new Product("p2b", 10f)
				, new Product("p3", 96f), new Product("p4", 100f)
				, new Product("p5", 82f), new Product("p6", 88f)
				};
		
		products = Arrays.stream(aProducts).toArray(Product[]::new);
		
		sum = Arrays.stream(aProducts).mapToDouble(Product::getPrice).sum(); 
		
	}
	
	@Test
	@DisplayName("height 1")
	void e1() {
		
		BSTFacade<Product> bst = new BinarySearchTree<Product>(new CustomSearchEngine<>());
		var actual = bst.height();
		var expected = -1;
		
	    assertEquals(expected,actual);
	}
	
	
	@Test
	@DisplayName("height 2")
	void e2() {
		
		BSTFacade<Float> bst = new BinarySearchTree<Float>(new CustomSearchEngine<>());		
		var actual = bst.height();
		var expected = -1;
		
	    assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("height 3")
	void e3() {
		
		BSTFacade<Integer> bst = new BinarySearchTree<Integer>(new CustomSearchEngine<>());
		bst.insert(7,4,9,1,6,8,10);
		var actual = bst.height();
		var expected = 2;
		
	    assertEquals(expected,actual);
	}
	
	@Test
	@DisplayName("height 4")
	void e4() {
		
		BSTFacade<Integer> bst = new BinarySearchTree<Integer>(new CustomSearchEngine<>());
		bst.insert(20,10);
		var actual = bst.height();
		var expected = 1;
		
	    assertEquals(expected,actual);
	}	
	
	
	@Test
	@DisplayName("height 5")
	void e5() {
		
		BSTFacade<Product> bst = new BinarySearchTree<Product>(new CustomSearchEngine<>());
		bst.insert(products);
		var actual = bst.height();
		
		var expected = 3;
		
	    assertEquals(expected,actual);
	}
	@Test
	@DisplayName("height 6")
	void e6(){
		BSTFacade<Product> bst = new BinarySearchTree<>(new CustomSearchEngine());
		bst.insert(products);

		var actual = bst.height(new Product(96));
		var expected = 2;
		assertEquals(expected,actual);
	}
}