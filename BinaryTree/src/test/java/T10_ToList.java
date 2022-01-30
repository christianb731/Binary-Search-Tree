
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.function.Predicate;

import edu.citytech.datastructure.sid23815642.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid23815642.bst.AdvanceSearchEngine;
import edu.citytech.datastructure.sid23815642.bst.BinarySearchTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jbbwebsolutions.bst.BSTFacade;
import com.jbbwebsolutions.bst.EnumComparison;



@DisplayName("FindAll")
class T10_ToList {
	
	static Long data[] = {4000l,3000l,5000l,2000l,3700l,4200l,6000l
		      ,1000l,2500l,3600l,3800l,4100l,4300l,5600l
		      ,7000l};
	
	
	
	@Test
	@DisplayName("Equal to 1,000")
	void equalTo() {
		
		BSTFacade<Long> bst = new BinarySearchTree<Long>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>() );
		bst.insert(data);		
		
		Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;		
		
		var list = bst.findAll(1000l, predicate,  (Long value,Long rowCount) -> {
			System.out.println(value + " - " + rowCount);
		});

		System.out.println("List: " + list + " size: " + list.size());	
		
		var actual = list.size();
		var expected = 1;
		
	    assertEquals(actual, expected);
		
	}
	
	@Test
	@DisplayName("Greater than 3,500")
	void gt3500() {
		
		BSTFacade<Long> bst = new BinarySearchTree<Long>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>() );	
		
		bst.insert(data);		
		
		Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;	
		
		
		var list = bst.findAll(3_500l, predicate,  (Long value,Long rowCount) -> {
			System.out.println(value + " - " + rowCount);
		});

		System.out.println("List: " + list + " size: " + list.size());	
		
		var actual = list.size();
		var expected = 11;
		
	    assertEquals(actual, expected);
		
	}
	
	@Test
	@DisplayName("Greater than 5_600l")
	void gte600() {
		
		BSTFacade<Long> bst = new BinarySearchTree<Long>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>() );	
		bst.insert(data);		
		
		Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;		
		
		var list = bst.findAll(5_600l, predicate,  (Long e1,Long e2) -> {
			System.out.println(e1 + " - " + e2);
		});

		System.out.println("List: " + list + " size: " + list.size());		
		
	}
	
	@Test
	@DisplayName("Greater or equal to 2,000")
	void gte2000() {
		
		BSTFacade<Long> bst = new BinarySearchTree<Long>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>() );	
		bst.insert(data);		
		
		Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;		
		predicate = predicate.or(e -> EnumComparison.EQUAL == e);
		
		var list = bst.findAll(2000l, predicate,  (Long e1,Long e2) -> {
			System.out.println(e1 + " - " + e2);
		});

		System.out.println("List: " + list + " size: " + list.size());	
		
		var actual = list.size();
		var expected = 14;
		
	    assertEquals(actual, expected);
	}

	
}