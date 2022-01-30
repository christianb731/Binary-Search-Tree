

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.citytech.datastructure.sid23815642.bst.BinarySearchTree;
import edu.citytech.datastructure.sid23815642.bst.CustomSearchEngine;
import edu.citytech.datastructure.sid23815642.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class T2_BSTWithProduct {
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
		var bst = new BinarySearchTree<Product>();
		bst.insert(products);
		var product = bst.find( new Product(105f));
		var actual = 105f;
		var expected = product.getPrice();
	    assertEquals(actual, expected);
	}

	@Test
	@DisplayName("Basic Test with Numbers")
	void testWithNumbers() {
		var bst = new BinarySearchTree<Float>();
		bst.insert(3f);
		bst.insert(10f);
		bst.insert(5f);

		var actual = bst.find( 3f);
		var expected = 3f;
		assertEquals(actual, expected);
	}


	@Test
	@DisplayName("Searching by Product with a consumer")
	void getBasicSearchEngine2() {
		List<Product> list = new ArrayList<>();
		var bst = new BinarySearchTree<Product>();
		bst.insert(products);

		var product = bst.find( new Product(105f), list::add);
		var actual = list.size();
		var expected = 4;
		assertEquals(expected, actual);
	}


	@Test
	@DisplayName("Searching by Product with a consumer, and Customer SearchEngine")
	void getBasicSearchEngine3() {
		List<Product> list = new ArrayList<>();
		var bst = new BinarySearchTree<Product>( new CustomSearchEngine<Product>());
		bst.insert(products);

		var product = bst.find( new Product(105f), list::add);
		System.out.println(product);
		var actual = list.size();
		var expected = 4;
		assertEquals(expected, actual);
	}
}