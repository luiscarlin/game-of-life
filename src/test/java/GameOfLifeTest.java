import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameOfLifeTest {
	/*
	 * todo: needs to be convrerted
	static GameOfLife game; 
	
	@BeforeClass 
	public static void setup() { 
		game = new GameOfLife(); 
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
	@Test 
	public void verifyTopRow() {
		
		game.setSize(3);
		game.createGrid();
		
		assertTrue(game.inTopRow(2));
	}
	@Test 
	public void verifyRightColumn() {
		
		game.setSize(3);
		game.createGrid();
		
		assertTrue(game.inRightColumn(5));
	}
	@Test 
	public void verifyBottomRow() {
		
		game.setSize(3);
		game.createGrid();
		
		assertTrue(game.inBottomRow(7));
	}
	@Test 
	public void verifyLeftColumn() {
		
		game.setSize(3);
		game.createGrid();
		
		assertTrue(game.inLeftColumn(3));
	}
	@Test
	public void verifyNotBorder() {
		
		game.setSize(4);
		game.createGrid();
		
		assertTrue(game.notOnBorder(5));
		assertTrue(game.notOnBorder(6));
		assertTrue(game.notOnBorder(9));
		assertTrue(game.notOnBorder(10));
	}
	
	// checking the corner conditions now
	
	@Test 
	public void verifyTopLeftCorner() {
		
		game.setSize(3);
		game.createGrid();
		
		assertTrue(game.inTopLeft(0));
	}

	@Test 
	public void verifyTopRightCorner() {
		
		game.setSize(3);
		game.createGrid();
		
		assertTrue(game.inTopRight(2));
	}
	@Test 
	public void verifyBottomLeftCorner() {
		
		game.setSize(3);
		game.createGrid();
		
		assertTrue(game.inBottomLeft(6));
	}
	@Test 
	public void verifyBottomRightCorner() {
		
		game.setSize(3);
		game.createGrid();
		
		assertTrue(game.inBottomRight(8));
	}

	@Test
	public void verifyThatICanGetNumberOfAliveNeighbors() { 
		game.setSize(3);
		game.createGrid();
		
		game.setAlive(1);
		game.setAlive(5);
		game.setAlive(7);
	
		assertEquals(1, game.getNumberAliveNeighbors(0));
		assertEquals(1, game.getNumberAliveNeighbors(1));
		assertEquals(2, game.getNumberAliveNeighbors(2));
		assertEquals(2, game.getNumberAliveNeighbors(3));
		assertEquals(3, game.getNumberAliveNeighbors(4));
		assertEquals(2, game.getNumberAliveNeighbors(5));
		assertEquals(1, game.getNumberAliveNeighbors(6));
		assertEquals(1, game.getNumberAliveNeighbors(7));
		assertEquals(2, game.getNumberAliveNeighbors(8));
	}	
	
	@Test 
	public void whenTheUserRequestsForTheIdTheCorrectOneIsReturned() { 
		game.setSize(3);
		game.createGrid(); 
		
		game.setAlive(0,0);
		assertTrue(game.isAlive(0));
	}
	
	*/
}