package board;

public enum TileType {
	PLAINE,MONTAGNE,DESERT,FORET,OCEAN;


	/**
	 * @return the number of gold coins produced by each tile
	 */
	public int nbPO() {
		if(this == PLAINE || this == FORET) {
			return 2;
		}
		else if(this == MONTAGNE) {
			return 8;
		}
		else if(this == DESERT) {
			return 5;
		}
		return 0;
	}
		
	/**
	 * @return the capacity of each tile
	 */
	public int capacity() {
		if (this == PLAINE ||  this == FORET) {
			return 5;
		}
		else if(this == MONTAGNE || this == DESERT) {
			return 3;
		}
		else {
			return 0;
		}
	}
	
	/**
	 * @return the number of food units produced by each tile
	 */
	public int givingFood() {
		if(this == PLAINE) {
			return 5;
		}
		else if(this == FORET) {
			return 2;
		}
		return 0;
	}
	
	
	/**
	 * @return the number of times the amount of food the character needs for each tile
	 */
	public int foodNeeded() {
		if(this == DESERT ) {
			return 2;
		}
		return 1;
	}
	
	/**
	 * @return the number of gold coins produced by each tile
	 */
	public int givingPO() {
		if(this == PLAINE || this == FORET) {
			return 1;
		}
		else if(this == MONTAGNE) {
			return 5;
		}
		else if(this == DESERT) {
			return 3;
		}
		return 0;		
	}
	
	
	/**
	 * @return the power 'increase of the characters
	 */
	public int power() {
        if(this == MONTAGNE) {
            return 2;
        }
        return 0;
    }
	
	/**
	 * @return the player's bonus points according to the type of tile
	 */
	public int bonus() {
		if (this == MONTAGNE || this == DESERT) {
			return 4;
		}
		if(this == FORET) {
			return 2;
		}
		return 1;
	}
	
	
	
}