import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestGame {
	
	static Game game; 
	
	@BeforeClass 
	public static void setup() { 
		game = new Game(); 
	}

	@Test
	public void whenIcreateAGameIDoNotGetNull() {
		assertNotNull(game);
	}
	
	@Test 
	public void verifyThatICanSetSize() {
		game.setSize(5);
		
		assertEquals(5, game.getSize());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void verifyThatNegativeSize() { 
		game.setSize(-45);
	}
	
	@Test 
	public void verifyThatAGridIsCreated() { 
		game.setSize(3); 
		
		game.createGrid(); 
		
		assertTrue(game.getGrid().size() != 0); 
	}

	@Test
	public void verifyThatACellCanBeSetToAlive() {
		
		game.setSize(3);
		game.createGrid();
		
		game.setAlive(2, 2);
		assertTrue(game.isAlive(2, 2));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void verifyNotOutOfBounds() { 
		game.setSize(3);
		game.createGrid();
		
		game.setAlive(-4, -4);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void verifyNotGreaterThanSize()
	{
		game.setSize(5);
		game.createGrid();
		
		game.setAlive(6, 10);
	}
	
	@Test
	public void verifyCellID() {
		
		game.setSize(3);
		game.createGrid();
		
		game.setAlive(2);
		assertTrue(game.isAlive(2));
	}	
	/*
	@Test
	public void verifyThatICanGetNumberOfAliveNeighbors() { 
		game.setSize(3);
		game.createGrid();
		
		game.setAlive(2);
		game.setAlive(0);
		
		assertEquals(2, game.getNumberAliveNeighbors(1));
	}
	*/
}