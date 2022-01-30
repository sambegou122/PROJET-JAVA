/**
 * 
 */
package board;

import java.util.*;

/**
 * @author max
 *
 */
public class Board {
	
	/**
	 * Attributes
	 */
	protected int width;
	protected int height;
	protected Tile[][] theTiles;
	protected ArrayList<Tile> Dispo;
	
	/**
	 * constructor
	 * @param width Board's width
	 * @param height Board's height
	 */
	public Board(int width, int height) {
		this.height=height;
		this.width=width;
		this.theTiles = new Tile[width][height];
		this.Dispo = new ArrayList<Tile>();
		this.placeTerrain();
		this.placeOcean();
	}
	
	/**
	 * La fonction placeTerrain à pour but d'instancier la partie terrestre du terrain qui correspond à un tiers du plateau
	 * Pour l'emplacement et son type on le fait de manière aléatoire.
	 * Chaque cases sont créer deux par deux tout en vérifiant que les cases sont libres
	 * on vérifie aussi l'emplacement de x et y afin d'adapter la création de la seconde case
	 * Si la case est en haut à droite du plateau alors on prend la seconde case à gauche ou en dessous par exemple.
	 */
	public void placeTerrain() {
		int dimension = this.width*this.height;
		int cpt = 0;
		Random r = new Random();
		while(cpt<=dimension/3) {
			int x = r.nextInt(this.width);
			int y = r.nextInt(this.height);
			if(this.theTiles[x][y]==null) {
			//Cas où la case se trouve à droite du plateau
				if(x==this.width-1) {
					
					// Cas où la case se trouve en bas du plateau
					if(y==this.height-1) {
						int pos = r.nextInt(2);
						if(pos==0 && this.theTiles[x-1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x-1][y]= this.terrainAlea(x-1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x-1][y]);
							cpt+=2;
	
						}
						else if(this.theTiles[x][y-1]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y-1]= this.terrainAlea(x,y-1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y-1]);
							cpt+=2;
						}
					}
					
					// Cas où la case se trouve en haut du plateau
					else if (y==0) {
						int pos = r.nextInt(2);
						if(pos==0 && this.theTiles[x-1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x-1][y]= this.terrainAlea(x-1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x-1][y]);
							cpt+=2;
	
						}
						else if(this.theTiles[x][y+1]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y+1]= this.terrainAlea(x,y+1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y+1]);
							cpt+=2;
						}
					}
					
					// Autre cas
					else {
						int pos = r.nextInt(4);
						if(pos==0 && this.theTiles[x-1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x-1][y]= this.terrainAlea(x-1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x-1][y]);
							cpt+=2;
						}
						else if(pos==1 && this.theTiles[x][y+1]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y+1]= this.terrainAlea(x,y+1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y+1]);
							cpt+=2;
						}
						else if( this.theTiles[x][y-1]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y-1]= this.terrainAlea(x,y-1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y-1]);
							cpt+=2;
						}
					}
				}
				
				// Cas où la case se situe à gauche
				else if(x==0) {
					if(y==this.height-1) {
						int pos = r.nextInt(2);
						if(pos==0 && this.theTiles[x+1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x+1][y]= this.terrainAlea(x+1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x+1][y]);
							cpt+=2;
	
						}
						else if(this.theTiles[x][y-1]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y-1]= this.terrainAlea(x,y-1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y-1]);
							cpt+=2;
						}
					}
					
					else if (y==0) {
						int pos = r.nextInt(2);
						
						if(pos==0 && this.theTiles[x+1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x+1][y]= this.terrainAlea(x+1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x+1][y]);
							cpt+=2;
	
						}
						
						else if (this.theTiles[1][y+1]==null){
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y+1]= this.terrainAlea(x,y+1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y+1]);
							cpt+=2;
						}
					}
					
					else {
						int pos = r.nextInt(3);
						if(pos==0 && this.theTiles[x+1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x+1][y]= this.terrainAlea(x+1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x+1][y]);
							cpt+=2;
	
						}
						else if(pos==1 && this.theTiles[x][y-1]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y-1]= this.terrainAlea(x,y-1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y-1]);
							cpt+=2;
	
						}
						else if(this.theTiles[x][y+1]==null) {	
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y+1]= this.terrainAlea(x,y+1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y+1]);
							cpt+=2;
						}
					}
				}
				
				// Autre cas
				else {
					if(y==this.height-1) {
						int pos = r.nextInt(3);
						if(pos==0 && this.theTiles[x-1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x-1][y]= this.terrainAlea(x-1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x-1][y]);
							cpt+=2;
						}
						
						else if(pos==1 && this.theTiles[x+1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x+1][y]= this.terrainAlea(x+1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x+1][y]);
							cpt+=2;
						}
						
						else if(this.theTiles[x][y-1]==null) {	
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y-1]= this.terrainAlea(x,y-1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y-1]);
							cpt+=2;
						}
					}
					
					else if (y==0) {
						int pos = r.nextInt(3);
						if(pos==0 && this.theTiles[x-1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x-1][y]= this.terrainAlea(x-1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x-1][y]);
							cpt+=2;
	
						}
						else if(pos==1 && this.theTiles[x+1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x+1][y]= this.terrainAlea(x+1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x+1][y]);
							cpt+=2;
	
						}
						else if(this.theTiles[x][y+1]==null) {	
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y+1]= this.terrainAlea(x,y+1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y+1]);
							cpt+=2;
						}
					}
					
					else {
						int pos = r.nextInt(4);
						if(pos==0 && this.theTiles[x-1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x-1][y]= this.terrainAlea(x-1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x-1][y]);
							cpt+=2;
						}
						else if(pos==1 && this.theTiles[x+1][y]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x+1][y]= this.terrainAlea(x+1,y);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x+1][y]);
							cpt+=2;
	
						}
						else if(pos == 2 && this.theTiles[x][y+1]==null) {	
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y+1]= this.terrainAlea(x,y+1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y+1]);
							cpt+=2;
						}
						else if(this.theTiles[x][y-1]==null) {
							this.theTiles[x][y]= this.terrainAlea(x,y);
							this.theTiles[x][y-1]= this.terrainAlea(x,y-1);
							this.Dispo.add(this.theTiles[x][y]);
							this.Dispo.add(this.theTiles[x][y-1]);
							cpt+=2;
						}
				}
			}
		}
		}
	}
	
	/**
	 * La fonction remplis les cases restantes en case de type OCEAN
	 */
	public void placeOcean() {
		for(int x=0;x<this.width;x++) {
			for(int y=0 ; y < this.height ;y++) {
				if(this.theTiles[x][y]==null) {
					this.theTiles[x][y]= new Tile(TileType.OCEAN,x,y);
				}
			}
		}
	}
	
	public Tile terrainAlea(int x, int y) {
		Random r = new Random();
		int rand = r.nextInt(4);
		if(rand == 0) {
			Tile t= new Tile(TileType.FORET,x,y);
			return t;
		}
		else if(rand == 1) {
			Tile t= new Tile(TileType.MONTAGNE,x,y);
			return t;
		}
		else if(rand == 2) {
			Tile t= new Tile(TileType.DESERT,x,y);
			return t;
		}
		Tile t= new Tile(TileType.PLAINE,x,y);
		return t;
	}
	
	/**
	 * get Board's width
	 * @return width
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * get Board's height
	 * @return height
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * get Tile at x and y position of theTiles
	 * @param x position X
	 * @param y position Y
	 * @return Tile at x and y position
	 */
	public Tile getTile(int x,int y) {
		return this.theTiles[x][y];
	}
	
	public ArrayList<Tile> getDispo(){
		return this.Dispo;
	}
	
	public void printBoard() {
		System.out.print(" ");
		for(int i = 0; i<this.height; i++) {
			System.out.print(" ");
			System.out.print(Integer.toString(i));
		}
		System.out.print("\n");
		for(int x = 0; x<this.width;x++) {
			System.out.print(Integer.toString(x));
			System.out.print(" ");
			for(int y = 0; y<this.height; y++) {
				if(this.theTiles[x][y].getType()==TileType.OCEAN) {
					System.out.print("O ");
				}
				else if(this.theTiles[x][y].getType()==TileType.DESERT) {
					System.out.print("D ");
				}
				else if(this.theTiles[x][y].getType()==TileType.FORET) {
					System.out.print("F ");
				}
				else if(this.theTiles[x][y].getType()==TileType.MONTAGNE) {
					System.out.print("M ");
				}
				else if(this.theTiles[x][y].getType()==TileType.PLAINE) {
					System.out.print("P ");
				}
			}
			System.out.print("\n");
		}
	}
}
