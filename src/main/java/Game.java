import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

	private int size;
	private List<List<Integer>> grid;

	public Game() {
		grid = new ArrayList<List<Integer>>();
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		
		if (size < 0)
		{
			throw new IllegalArgumentException();
		}
		
		this.size = size;
	}
	
	public void createGrid() {
		
		for (int i = 0; i < size; i++) { 
			
			List<Integer> newList = new ArrayList<Integer>();
			
			for (int j = 0; j < size; j++) { 
				newList.add(0); 
			}
			
			grid.add(newList);
		}
	}

	public List<List<Integer>> getGrid() {
		return grid;
	}
	
	public void setAlive(int x, int y) { 
		
		if ((x < 0) || (y < 0)) { 
			throw new IllegalArgumentException();
		}
		
		if ((x >= size) || (y >= size)) { 
			throw new IllegalArgumentException();
		}
		
		grid.get(x).add(y, 1);
	}
	
	public void setAlive(int id) { 
		
		if ((id < 0) || (id > Math.pow(size, 2) - 1)) { 
			throw new IllegalArgumentException();
		}
		
		// loop through list
		int position = 0;
		
		for (int i = 0; i < size; i++) { 
			for (int j = 0; j < size; j++) { 
				
				if (position == id) { 
					grid.get(i).add(j, 1);
				}
				
				position +=1;				
			}
		}
	}
	
	public boolean isAlive(int x, int y) { 
		
		if ((x < 0) || (y < 0)) { 
			throw new IllegalArgumentException();
		}
		
		if ((x >= size) || (y >= size)) { 
			throw new IllegalArgumentException();
		}
		
		if(grid.get(x).get(y) == 1) 
			return true;
		else 
			return false;
		
	}
	
	public boolean isAlive(int id) { 
		
		if ((id < 0) || (id > Math.pow(size, 2) - 1)) { 
			throw new IllegalArgumentException();
		}
		
		// loop through list
		int position = 0;
		
		for (int i = 0; i < size; i++) { 
			for (int j = 0; j < size; j++) { 
				
				if (position == id) { 
					if (grid.get(i).get(j) == 1) { 
						return true;
					}
					else {
						return false;
					}
				}
				
				position +=1;				
			}
		}
		throw new RuntimeException();
	}
	
	public void display() { 
		for (int i = 0; i < size; i++) {
			
			for (int j = 0; j < size; j++) { 
				System.out.print(grid.get(i).get(j) + " "); 
				
				//System.out.print("(" + i + ","  + j + ") "); 
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws InterruptedException, IOException { 
		Game game = new Game() ;
		game.setSize(10);
		game.createGrid();
		
		
		int numGenerations = 10;
		
		Random randAlive = new Random();
		
		for (int x = 0; x < numGenerations; x++) { 	
			for (int i = 0; i < 10; i++) { 
				game.setAlive(randAlive.nextInt(99)); 
			}
			game.display();
			
			Thread.sleep(1000);
			
			Runtime.getRuntime().exec("cls.exe");
		} 
	}

	public int getNumberAliveNeighbors(int id) {
		
		int numNeighborsAlive = 0; 
		
		if (notOnBorder(id)) { 
			if (isAlive(getLeftId(id))) numNeighborsAlive++; 
			if (isAlive(getTopId(id))) numNeighborsAlive++; 
			if (isAlive(getRightId(id))) numNeighborsAlive++; 
			if (isAlive(getBottomId(id))) numNeighborsAlive++; 
			if (isAlive(getTopLeftId(id))) numNeighborsAlive++; 
			if (isAlive(getTopRightId(id))) numNeighborsAlive++; 
			if (isAlive(getBottomLeftId(id))) numNeighborsAlive++; 
			if (isAlive(getBottomRightId(id))) numNeighborsAlive++; 
		}
		else if (inTopLeft(id)) { 
			if (isAlive(getRightId(id))) numNeighborsAlive++;
			if (isAlive(getBottomId(id))) numNeighborsAlive++; 
			if (isAlive(getBottomRightId(id))) numNeighborsAlive++; 
		}
		else if (inTopRight(id)) { 
			if (isAlive(getLeftId(id))) numNeighborsAlive++;
			if (isAlive(getBottomId(id))) numNeighborsAlive++; 
			if (isAlive(getBottomLeftId(id))) numNeighborsAlive++; 
		}
		else if (inBottomRight(id)) { 
			if (isAlive(getTopId(id))) numNeighborsAlive++;
			if (isAlive(getTopLeftId(id))) numNeighborsAlive++; 
			if (isAlive(getLeftId(id))) numNeighborsAlive++; 
		}
		else if (inBottomLeft(id)) { 
			if (isAlive(getTopId(id))) numNeighborsAlive++;
			if (isAlive(getTopRightId(id))) numNeighborsAlive++; 
			if (isAlive(getRightId(id))) numNeighborsAlive++; 
		}
		else if (inLeftColumn(id)) {
			if (isAlive(getTopId(id))) numNeighborsAlive++;
			if (isAlive(getTopRightId(id))) numNeighborsAlive++; 
			if (isAlive(getRightId(id))) numNeighborsAlive++; 
			if (isAlive(getBottomRightId(id))) numNeighborsAlive++; 
			if (isAlive(getBottomId(id))) numNeighborsAlive++; 
		}
		else if (inTopRow(id)) {
			if (isAlive(getLeftId(id))) numNeighborsAlive++;
			if (isAlive(getBottomLeftId(id))) numNeighborsAlive++;
			if (isAlive(getBottomId(id))) numNeighborsAlive++; 
			if (isAlive(getBottomRightId(id))) numNeighborsAlive++; 
			if (isAlive(getRightId(id))) numNeighborsAlive++; 
		}
		else if (inRightColumn(id)) {
			if (isAlive(getLeftId(id))) numNeighborsAlive++;
			if (isAlive(getBottomLeftId(id))) numNeighborsAlive++;
			if (isAlive(getBottomId(id))) numNeighborsAlive++; 
			if (isAlive(getTopLeftId(id))) numNeighborsAlive++; 
			if (isAlive(getTopId(id))) numNeighborsAlive++; 
		}
		else if (inBottomRow(id)) {
			if (isAlive(getLeftId(id))) numNeighborsAlive++;
			if (isAlive(getTopRightId(id))) numNeighborsAlive++;
			if (isAlive(getRightId(id))) numNeighborsAlive++; 
			if (isAlive(getTopLeftId(id))) numNeighborsAlive++; 
			if (isAlive(getTopId(id))) numNeighborsAlive++; 
		}
		else {
			throw new RuntimeException("Unexplained Error!!!");
		};	
		
		return numNeighborsAlive;
	}

	private int getBottomRightId(int id) {
		return id + size + 1;
	}

	private int getBottomLeftId(int id) {
		return id + size - 1;
	}

	private int getTopRightId(int id) {
		return id - size + 1;
	}

	private int getTopLeftId(int id) {
		return id - size - 1;
	}

	private int getBottomId(int id) {
		return id + size;
	}

	private int getRightId(int id) {
		return id + 1;
	}

	private int getTopId(int id) {
		return id - size;
	}

	private int getLeftId(int id) {
		return id - 1;
	}

	public boolean inTopRow(int id) {
		
		if (id <= (size - 1)) { 
			return true;
		}
		
		return false;
	}

	public boolean inRightColumn(int id) {
		
		if ((id + 1) % size == 0) { 
			return true;
		}
		
		return false;
	}

	public boolean inBottomRow(int id) {
		if (((Math.pow(size, 2) - size) <= id)  && (id <=  Math.pow(size, 2) - 1)) { 
			return true;
		}
		return false;
	}

	public boolean inLeftColumn(int id) {
		
		if (id % size == 0) { 
			return true;
		}
		
		return false;
	}

	public boolean inTopRight(int id) {
		if (inTopRow(id) && inRightColumn(id)) {
			return true; 
		}
		return false;
	}

	public boolean inTopLeft(int id) {
		if (inTopRow(id) && inLeftColumn(id)) {
			return true; 
		}
		return false;
	}

	public boolean inBottomRight(int id) {
		if (inBottomRow(id) && inRightColumn(id)) {
			return true; 
		}
		return false;
	}

	public boolean inBottomLeft(int id) {
		if (inBottomRow(id) && inLeftColumn(id)) {
			return true; 
		}
		return false;
	}

	public boolean notOnBorder(int id) {
		if (inTopRow(id)) {
			return false;
		}		
		else if (inBottomRow(id)) {
			return false;
		}
		else if (inLeftColumn(id)) {
			return false;
		}
		else if (inRightColumn(id)) {
			return false;
		}
		else {
			return true;
		}
	}
}
