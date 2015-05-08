package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
			}
			
			System.out.println();
		}
	}
	
	public static void main(String[] args) { 
		Game game = new Game() ;
		game.setSize(50);
		game.createGrid();
		
		game.setAlive(0);
		;
		game.setAlive(49);
		
		game.display();
	}

	public int getNumberAliveNeighbors(int id) {
		
		// TODO:
		return 0;
		
	}
}
