package test;

import static org.junit.jupiter.api.Assertions.*;
import main.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void testAddRental() {
		Customer customer = new Customer("Max");
		customer.addRental(new Rental(new Movie("Test", Movie.NEW_RELEASE), 0));
		
		String statement = customer.statement();
		
		assertEquals(5, statement.split("\n").length);
		
	}

	@Test
	void testGetName() {
		String name = "Max";
		Customer customer = new Customer(name);
		
		assertEquals(name, customer.getName());
	}

	@Test
	void testEmptyRental() {
		Customer customer = new Customer("Max");
		String statement = customer.statement();
		
		assertEquals(4, statement.split("\n").length);
	}

}
