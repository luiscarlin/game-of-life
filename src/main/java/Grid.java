import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Grid {
	
	public enum Pattern { 
		ALL_DEAD, 
		ALL_ALIVE, 
		RANDOM;
	}
	
	private int numColumns;  
	private int numRows;
	private Pattern pattern;
	
	private Map<Point, Cell> gridData;
	private Map<Point, Integer> AliveNeighbors;
	
	public Grid(int numColumns, int numRows) { 
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.pattern = Pattern.RANDOM;
		gridData = new HashMap<Point, Cell>();
		AliveNeighbors = new HashMap<Point, Integer>();
		
		populateGrid();
		updateNumberAliveNeighbors();
	}

	public Grid(int numColumns, int numRows, Pattern pattern) { 
		this.numColumns = numColumns;
		this.numRows = numRows;
		this.pattern = pattern;
		gridData = new HashMap<Point, Cell>();
		AliveNeighbors = new HashMap<Point, Integer>();
		
		populateGrid();
		updateNumberAliveNeighbors();
	}
	
	// factory
	public static Point at(int x, int y) { 
		return new Point(x, y);
	}
	
	public int getNumColumns() {
		return numColumns;
	}

	public int getNumRows() {
		return numRows;
	}

	public Pattern getPattern() {
		return pattern;
	}
	
	public void populateGrid() { 	
		switch (pattern) { 
			case ALL_DEAD: 	populateGridAllDead();
							break;
			case ALL_ALIVE:	populateGridAllAlive();
							break;
			case RANDOM:	populateGrideRandom();
							break;
			default:		throw new RuntimeException("Pattern not recognized");
		}		
	}

	public int[][] getGrid() { 
		int[][] gridArray = new int[numColumns][numRows];
		
		for (int y = 0; y < numRows; y++) {
			for (int x = 0; x < numColumns; x++) { 				
				gridArray[x][y] = isAlive(at(x, y)) ? 1 : 0;
			}
		}
		
		return gridArray; 
	}
	
	public void displayGrid() { 
		
		int[][] grid = getGrid();
		 for (int y = 0; y < numRows; y++) {
	            for (int x = 0; x < numColumns; x++) {
	                System.out.print(grid[x][y] + " ");
	            }
	            System.out.println();
	        }
	}
	
	public boolean isAlive(Point point) { 
		return gridData.get(point).getState().getValue(); 
	}
	
	public int getNumberAliveNeighbors(Point point) { 
		return AliveNeighbors.get(point); 
	}

	private void populateGridAllDead() {
		for (int y = 0; y < numRows; y++) {
			for (int x = 0; x < numColumns; x++) { 
				gridData.put(at(x, y), new Cell(Cell.State.DEAD));
			}
		}
	}
	
	private void populateGridAllAlive() {
		for (int y = 0; y < numRows; y++) {
			for (int x = 0; x < numColumns; x++) { 
				gridData.put(at(x, y), new Cell(Cell.State.ALIVE));
			}
		}
	}	
	
	private void populateGrideRandom() {
		
		Random rand = new Random();
		
		// generate a number to cover 25% to 75% of the board with live cells
		int range = (int)(numRows * numColumns * 0.5) + 1;
		
		int cellsCovered = (int)(rand.nextDouble() * range) + (int)(numRows * numColumns * 0.25);
		
		populateGridAllDead();
		
		for (int i = 0; i < cellsCovered; i++) {
			
			int x, y;
			
			while(isAlive(at(x = rand.nextInt(numColumns),  y = rand.nextInt(numRows))));
			
			gridData.get(at(x, y)).setState(Cell.State.ALIVE);	
		}
	}
	
	private void resetNumberAliveNeighbors() { 
		for (int y = 0; y < numRows; y++) {
			for (int x = 0; x < numColumns; x++) { 
				AliveNeighbors.put(at(x, y), 0);
			}
		}
	}
	
	private void updateNumberAliveNeighbors() { 
		
		resetNumberAliveNeighbors();
		
		Set<Point> coordinates = gridData.keySet(); 
		
		for (Point point : coordinates) { 
			
			int x = (int)point.getX(); 
			int y = (int)point.getY(); 
			
			// top left corner
			if (point.equals(at(0, 0))) { 
				right(point); 
				bottomRight(point);
				bottom(point); 
			}
			// top right corner
			else if (point.equals(at(numColumns - 1, 0))) { 
				left(point); 
				bottomLeft(point);
				bottom(point); 
			}
			// bottom right corner 
			else if (point.equals(at(numColumns - 1, numRows - 1))) { 
				top(point); 
				topLeft(point);
				left(point); 
			}
			// bottom left corner 
			else if (point.equals(at(0, numRows - 1))) { 
				top(point); 
				topRight(point);
				right(point); 
			}
			// done with corners. Now with borders
			// top border 
			else if (y == 0) { 
				right(point); 
				bottomRight(point);
				bottom(point); 
				bottomLeft(point); 
				left(point); 
			}
			// right border
			else if (x == numColumns - 1 ) { 
				top(point); 
				topLeft(point);
				left(point); 
				bottomLeft(point); 
				bottom(point); 
			}
			// bottom border
			else if (y == numRows - 1 ) { 
				left(point); 
				topLeft(point);
				top(point); 
				topRight(point); 
				right(point); 
			}
			// left border
			else if (x == 0) { 
				top(point); 
				topRight(point);
				right(point); 
				bottomRight(point); 
				bottom(point); 
			}
			// part of the body
			else { 
				top(point); 
				topRight(point);
				right(point); 
				bottomRight(point); 
				bottom(point); 
				bottomLeft(point); 
				left(point); 
				topLeft(point); 
			}
		}
		
	}
	
	private void right(Point thisCell) { 
		
		int x = (int)thisCell.getX(); 
		int y = (int)thisCell.getY(); 

		if (isAlive(at(x + 1, y))) { 
			AliveNeighbors.put(thisCell, AliveNeighbors.get(thisCell) + 1);
		}
	}
	
	private void bottomRight(Point thisCell) { 
		
		int x = (int)thisCell.getX(); 
		int y = (int)thisCell.getY(); 

		if (isAlive(at(x + 1, y + 1))) { 
			AliveNeighbors.put(thisCell, AliveNeighbors.get(thisCell) + 1);
		}
	}
	
	private void bottom(Point thisCell) { 
		
		int x = (int)thisCell.getX(); 
		int y = (int)thisCell.getY(); 

		if (isAlive(at(x, y + 1))) { 
			AliveNeighbors.put(thisCell, AliveNeighbors.get(thisCell) + 1);
		}
	}
	
	private void bottomLeft(Point thisCell) { 
		
		int x = (int)thisCell.getX(); 
		int y = (int)thisCell.getY(); 

		if (isAlive(at(x - 1, y + 1))) { 
			AliveNeighbors.put(thisCell, AliveNeighbors.get(thisCell) + 1);
		}
	}
	
	private void left(Point thisCell) { 
		
		int x = (int)thisCell.getX(); 
		int y = (int)thisCell.getY(); 

		if (isAlive(at(x - 1, y))) { 
			AliveNeighbors.put(thisCell, AliveNeighbors.get(thisCell) + 1);
		}
	}
	
	private void topLeft(Point thisCell) { 
		
		int x = (int)thisCell.getX(); 
		int y = (int)thisCell.getY(); 

		if (isAlive(at(x - 1, y - 1))) { 
			AliveNeighbors.put(thisCell, AliveNeighbors.get(thisCell) + 1);
		}
	}
	
	private void top(Point thisCell) { 
		
		int x = (int)thisCell.getX(); 
		int y = (int)thisCell.getY(); 

		if (isAlive(at(x, y - 1))) { 
			AliveNeighbors.put(thisCell, AliveNeighbors.get(thisCell) + 1);
		}
	}
	
	private void topRight(Point thisCell) { 
		
		int x = (int)thisCell.getX(); 
		int y = (int)thisCell.getY(); 

		if (isAlive(at(x + 1, y - 1))) { 
			AliveNeighbors.put(thisCell, AliveNeighbors.get(thisCell) + 1);
		}
	}

	public void nextGeneration() {
		
		Set<Point> coordinates = gridData.keySet(); 
		
		for (Point point : coordinates) { 
			if (isAlive(point)) { 	
				// originally alive
				if ((AliveNeighbors.get(point) < 2) || (AliveNeighbors.get(point) > 3)){ 
					// dies
					gridData.get(point).setState(Cell.State.DEAD);
				}
			} 
			else { 
				// originally dead
				if (AliveNeighbors.get(point) == 3) { 
					// lives
					gridData.get(point).setState(Cell.State.ALIVE);
				}
			}
		}	
		updateNumberAliveNeighbors();
	}
}