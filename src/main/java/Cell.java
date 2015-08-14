/**
 * This class represents a cell in the 2d grid
 * @author Luis
 *
 */

public class Cell {

	public enum State { 
		DEAD(false), 
		ALIVE(true);
		
		private boolean value;    

		private State(boolean value) {
			this.value = value;
		}

		public boolean getValue() {
			return value;
		}
	}
	
	private State state;
	private int aliveNeighbors;
	
	Cell() { 
		state = State.DEAD;
		aliveNeighbors = 0;
	}
	
	Cell(State state) {
		this.state = state;
		aliveNeighbors = 0;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public int getAliveNeighbors() {
		return aliveNeighbors;
	}

	public void setAliveNeighbors(int aliveNeighbors) {
		this.aliveNeighbors = aliveNeighbors;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aliveNeighbors;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (aliveNeighbors != other.aliveNeighbors)
			return false;
		if (state != other.state)
			return false;
		return true;
	}

}