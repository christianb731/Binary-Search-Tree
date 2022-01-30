import com.jbbwebsolutions.bst.BSTFacade;
import edu.citytech.datastructure.sid23815642.bst.BinarySearchTree;
import edu.citytech.datastructure.sid23815642.bst.CustomSearchEngine;
import edu.citytech.datastructure.sid23815642.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class T6_Sum {

	@Test
	@DisplayName("size 10,20,30 ")
	void getSize() {

		BSTFacade<Integer> bst = new BinarySearchTree<Integer>(new CustomSearchEngine<Integer>());
		bst.insert(10,20,30);

		var actual = bst.size();
		var expected = 3;

		assertEquals(expected, actual );
	}

	@Test
	@DisplayName("Add 10 + 20 + 30")
	void getSum() {

		BSTFacade<Integer> bst = new BinarySearchTree<Integer>(new CustomSearchEngine<Integer>());
		bst.insert(10,20,30);
		var actual = bst.sum();
		var expected = 60;
		
	    assertEquals(expected, actual);
	}


	@Test
	@DisplayName("Add Products 10 + 20 + 30")
	void getSumProduct() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new CustomSearchEngine<Product>());
		bst.insert( new Product("p1",10)
					,new Product("p2",20)
				    ,new Product("p3",30));

		var actual = bst.sum();
		var expected = 60;

		assertEquals(expected,actual );
	}
	@Test
	@DisplayName("Add Products 10 + 20 + 30")
	void stockTest() {

		BSTFacade<Product> bst = new BinarySearchTree<Product>(new CustomSearchEngine<Product>());
		bst.insert( new Product("p1",10)
				,new Product("p2",20)
				,new Product("p3",30));

		var actual = bst.sum();
		var expected = 60;

		assertEquals(expected,actual );
	}
}