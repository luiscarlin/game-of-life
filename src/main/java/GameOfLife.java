public class GameOfLife {
	
	private Grid grid; 
	private int generationsToRun; 
	
	public GameOfLife(int generationsToRun, int numColumns, int numRows, Grid.Pattern pattern) { 
		this.generationsToRun = generationsToRun; 
		grid = new Grid(numColumns, numRows, pattern); 
	}
	
	public void start() { 
		
		for (int i = 0; i < generationsToRun; i++) { 
			
			System.out.println("Generation: " +  (i + 1)); 
			
			grid.displayGrid();
			
			grid.nextGeneration();
		}
	}
	
	public static void main(String[] args) { 
		
		GameOfLife game = new GameOfLife(5, 50, 5, Grid.Pattern.RANDOM); 
			
		game.start();
	}
}
