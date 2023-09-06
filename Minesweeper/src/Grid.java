import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import processing.core.PApplet;
import processing.core.PFont;

public class Grid {

	private char[][] tempgrid;
	private Tile[][] grid;
	private String filename;
	private ArrayList<Tile> listforclicking = new ArrayList<Tile>();
	private boolean gameover;
	private boolean eight = false;
	private int counter = 0;
	private int counternumber = (int)(Math.random()*3) + 1 ;
	private int yStart, xStart;
	private boolean start = false;
	
	
	public Grid(String filename, boolean gameover) {
		//System.out.println(counternumber);
		this.gameover = gameover;
		this.filename = filename;
		tempgrid =  new char[21][21];
		grid = new Tile[21][21];
		readData(filename,tempgrid);
	}
	
	
	public void gameOver()
	{
		
		gameover = true;
		start = false;
		for(int j = 0; j < tempgrid.length; j++) {
			
			for(int i = 0; i < tempgrid[0].length; i++) {
				
				grid[i][j].setCovered(false);
				
				}
			}
		
	}	
	public boolean getEight() {
		
		return eight;
	}
	
	public void drawMenu(PApplet marker) {
		
		
		
		marker.textSize(50);
		marker.fill(0);
		marker.text("Select level",250,100);
		marker.fill(192,192,192);
		marker.stroke(0);
		marker.rect(100, 200, 200, 50);// 100-300 200-250
		marker.rect(100, 400, 200, 50);// 100-300 400-450
		marker.rect(100, 600, 200, 50);// 100-300 600-650
		marker.rect(500, 200, 200, 50);// 500-700 200-250
		marker.rect(500, 400, 200, 50);// 500-700 400-450
		marker.rect(500, 600, 200, 50);// 500-700 600-650
		marker.textSize(40);
		marker.fill(0);
		marker.text("1",195,240);
		marker.text("2",195,440);
		marker.text("3",195,640);
		marker.text("4",595,240);
		marker.text("5",595,440);
		marker.text("6",595,640);
		
	}
	

	public void setStart(boolean start) {
		
		this.start = start;
	}
	
	public boolean getStart() {
		
		return start;
	}

	public boolean getStatus() {
		
		return gameover;
	}
	
	public void makeArray() {
		System.out.println("ARRAYMETHOD");
		
		int y = 0;
		int x = 0;
		int count= 0;
		for(int j = 0; j < tempgrid.length; j++) {
			
			for(int i = 0; i < tempgrid[0].length; i++) {
				
				
//				 
				if(tempgrid[i][j] == '*'  ) {
					
					
					if(grid[i][j] == null) {
						grid[i][j] = new Tile(x,y,"", true, false,count,false, true);
						count++;
					}else {
						
						if(grid[i][j].getFlag() == true) {
							
							grid[i][j] = new Tile(x,y,"", true, false,count,true, true);
							count++;
							
						}
					}
					
					
					
				}
				else if(tempgrid[i][j] == '-') {
					
					//if(grid[i][j] == null) {
						grid[i][j] = new Tile(x,y,"", true, false,count,false, false);
						count++;
					//}
					
				}
			
				else if(tempgrid[i][j] == '5'){
					
					if(grid[i][j] == null) {
						grid[i][j] = new Tile(x,y,"", true, true,count,false, true);
						count++;
					}
					else {
						
						if(grid[i][j].getFlag() == true) {
							
							grid[i][j] = new Tile(x,y,"", true, true,count,true, true);
							count++;
							
						}
						
					}
				}
				
				//System.out.println(count);
				
				x += 40;
			}
			x = 0;
			y+= 40;
			
			
		}
		
		
			
	}
	
	public int ireturn(int index) {
		
		int returneri = 0;
		for(int j = 0; j < grid.length; j++) {
			
			for(int i = 0; i < grid[0].length; i++) {
				
				if(grid[i][j] != null && grid[i][j].getIndex() == index) {
					
					returneri = i;
					}
				
				}
			}
		
		return returneri;
	}
	
	public int jreturn(int index) {
		
		int returnerj = 0;
		for(int j = 0; j < grid.length; j++) {
			
			for(int i = 0; i < grid[0].length; i++) {
				
				if(grid[i][j] != null && grid[i][j].getIndex() == index) {
					
					returnerj = j;
					}
				
				}
			}
		
		return returnerj;
	}
	
	public void drawPart(int index) {
		
		int i = ireturn(index);
		int j = jreturn(index);
		xStart = i;
		yStart = j;
		
		//System.out.println(xStart + " " + yStart);
		
		tempgrid[i][j] = '*';grid[i][j] = new Tile(grid[i][j].getX(),grid[i][j].getY(), "", true, false, grid[i][j].getIndex(),false, true);
		if(grid[i][j].getX() < 800 ) { 
			tempgrid[i+1][j] = '*';grid[i+1][j] = new Tile(grid[i+1][j].getX(),grid[i+1][j].getY(), "", true, false, grid[i+1][j].getIndex(),false, true);
		}
		if(grid[i][j].getX() < 800 && grid[i][j].getY() < 800 ) {
			tempgrid[i+1][j+1] = '*';grid[i+1][j+1] = new Tile(grid[i+1][j+1].getX(),grid[i+1][j+1].getY(), "", true, false, grid[i+1][j+1].getIndex(),false, true);
		}
		if( grid[i][j].getX() > 0 && grid[i][j].getY() > 0 ) {
			tempgrid[i-1][j-1] = '*';grid[i-1][j-1] = new Tile(grid[i-1][j-1].getX(),grid[i-1][j-1].getY(), "", true, false, grid[i-1][j-1].getIndex(),false, true);
		}
		if(grid[i][j].getY() < 800 ) {
			tempgrid[i][j+1] = '*';grid[i][j+1] = new Tile(grid[i][j+1].getX(),grid[i][j+1].getY(), "", true, false, grid[i][j+1].getIndex(),false, true);
		}
		if(grid[i][j].getY() > 0 ) {
			tempgrid[i][j-1] = '*';grid[i][j-1] = new Tile(grid[i][j-1].getX(),grid[i][j-1].getY(), "", true, false, grid[i][j-1].getIndex(),false, true);
		}
		if(grid[i][j].getX() < 800 && grid[i][j].getY() > 0 ) {
			tempgrid[i+1][j-1] = '*';grid[i+1][j-1] = new Tile(grid[i+1][j-1].getX(),grid[i+1][j-1].getY(), "", true, false, grid[i+1][j-1].getIndex(),false, true);
		}
		if(grid[i][j].getX() > 0 && grid[i][j].getY() <800) {
			tempgrid[i-1][j+1] = '*';grid[i-1][j+1] = new Tile(grid[i-1][j+1].getX(),grid[i-1][j+1].getY(), "", true, false, grid[i-1][j+1].getIndex(),false, true);
		}
		if(grid[i][j].getX() > 0 ) {
			tempgrid[i-1][j] = '*';grid[i-1][j] = new Tile(grid[i-1][j].getX(),grid[i-1][j].getY(), "", true, false, grid[i-1][j].getIndex(),false, true);
		}
		
		
		//start = true;
		makeDisplay();
	}
	
		
		
			
	
	
	public void check(int index) {
		
		int i = ireturn(index);
		int j = jreturn(index);
		
		
		if(grid[i][j].getDisplay().length() > 0&& grid[i][j].getBomb() == false ) {
			
			grid[i][j].setCovered(false);
		}
		else {
			
			
			if(grid[i][j] != null && grid[i][j].getBomb() == false  ) {
				
				grid[i][j].setCovered(false);
				
				if(grid[i][j].getX() < 800 && grid[i+1][j].getDisplay().length() == 0  && grid[i+1][j].getCovered() == true) {
					
					
					check(grid[i+1][j].getIndex());
					grid[i+1][j].setCovered(false);
					
					}
				else {
					if(grid[i][j].getX() < 800 && grid[i+1][j].getBomb() == false)
						grid[i+1][j].setCovered(false);
					
				}
					
				
				if(grid[i][j].getX() < 800 && grid[i][j].getY() < 800 && grid[i+1][j+1].getDisplay().length() == 0 && grid[i+1][j+1].getCovered() == true) {
					
					
					grid[i+1][j+1].setCovered(false);
					
					check(grid[i+1][j+1].getIndex());
					grid[i+1][j+1].setCovered(false);
					
					}
				else {
					if(grid[i][j].getX() < 800 && grid[i][j].getY() < 800&& grid[i+1][j+1].getBomb() == false)
						grid[i+1][j+1].setCovered(false);
					
				}
				if( grid[i][j].getX() > 0 && grid[i][j].getY() > 0 && grid[i-1][j-1].getDisplay().length() == 0 && grid[i-1][j-1].getCovered() == true) {
					
					
					grid[i-1][j-1].setCovered(false);
					
					check(grid[i-1][j-1].getIndex());
					grid[i-1][j-1].setCovered(false);
					
					}
				else {
					if(grid[i][j].getX() > 0 && grid[i][j].getY() > 0&& grid[i-1][j-1].getBomb() == false)
						grid[i-1][j-1].setCovered(false);
					
				}
				
				if(grid[i][j].getY() < 800 && grid[i][j+1].getDisplay().length() == 0 && grid[i][j+1].getCovered() == true) {
					
					grid[i][j+1].setCovered(false);
					
					check(grid[i][j+1].getIndex());
					grid[i][j+1].setCovered(false);
					
					}
				else {
					if(grid[i][j].getY() < 800&& grid[i][j+1].getBomb() == false)
						grid[i][j+1].setCovered(false);
					
				}
				if(grid[i][j].getY() > 0 && grid[i][j-1].getDisplay().length() == 0  && grid[i][j-1].getCovered() == true ) {
					
					
					grid[i][j-1].setCovered(false);
					
					check(grid[i][j-1].getIndex());
					grid[i][j-1].setCovered(false);
					
					}
				else {
					if(grid[i][j].getY() > 0&& grid[i][j-1].getBomb() == false)
						grid[i][j-1].setCovered(false);
					
				}
				if(grid[i][j].getX() < 800 && grid[i][j].getY() > 0 && grid[i+1][j-1].getDisplay().length() == 0 && grid[i+1][j-1].getCovered() == true) {
					
					
					grid[i+1][j-1].setCovered(false);
					
					check(grid[i+1][j-1].getIndex());
					grid[i+1][j-1].setCovered(false);
					
					}
				else {
					if(grid[i][j].getX() < 800 && grid[i][j].getY() > 0&& grid[i+1][j-1].getBomb() == false)
						grid[i+1][j-1].setCovered(false);
					
				}
				if(grid[i][j].getX() > 0 && grid[i][j].getY() <800 &&  grid[i-1][j+1].getDisplay().length() == 0 &&  grid[i-1][j+1].getCovered() == true) {
					
					
					grid[i-1][j+1].setCovered(false);
					
					check(grid[i-1][j+1].getIndex());
					grid[i-1][j+1].setCovered(false);
					
					}
				else {
					if(grid[i][j].getX() > 0 && grid[i][j].getY() <800 && grid[i-1][j+1].getBomb() == false )
						grid[i-1][j+1].setCovered(false);
					
				}
				if(grid[i][j].getX() > 0 && grid[i-1][j].getDisplay().length() == 0 && grid[i-1][j].getCovered() == true) {
					
					
					grid[i-1][j].setCovered(false);
					
					check(grid[i-1][j].getIndex());
					grid[i-1][j].setCovered(false);
					
					}
				else {
					if(grid[i][j].getX() > 0&& grid[i-1][j].getBomb() == false)
						grid[i-1][j].setCovered(false);
					
				}
			
			}
		
		}
	}
	
	
	
	
	public void makeDisplay() {
		
		
		for(int j = 0; j < grid.length; j++) {
			
			for(int i = 0; i < grid[0].length; i++) {
				
					int count = 0;
					
					if(grid[i][j] != null && grid[i][j].getBomb() == false   ) {
						
						if(grid[i][j].getX() < 800 && grid[i+1][j].getBomb() == true  ) {
								
								count++;
							}
						if(grid[i][j].getX() > 0 && grid[i-1][j].getBomb() == true ) {
							
								count++;
							}
						if(grid[i][j].getX() < 800 && grid[i][j].getY() < 800 && grid[i+1][j+1].getBomb() == true) {
							
								count++;
							}
						if( grid[i][j].getX() > 0 && grid[i][j].getY() > 0 && grid[i-1][j-1].getBomb() == true ) {
							
								count++;
							}
						if(grid[i][j].getY() < 800 && grid[i][j+1].getBomb() == true ) {
							
								count++;
							}
						if(grid[i][j].getY() > 0 && grid[i][j-1].getBomb() == true ) {
							
								count++;
							}
						if(grid[i][j].getX() < 800 && grid[i][j].getY() > 0 && grid[i+1][j-1].getBomb() == true) {
							
								count++;
							}
						if(grid[i][j].getX() > 0 && grid[i][j].getY() <800 &&  grid[i-1][j+1].getBomb() == true ) {
							
								count++;
							}
						
						if(count > 0) {
							
							grid[i][j].setDisplay("" + count);
							if(count == 7 || count == 8) {
								System.out.println("dfsdsfafadsafdsasfd");
							}
						}
						
					
					}
					
					count = 0;
				}
			}
		
		
	}
	
	public void makeList() {
		
		for(int j = 0; j < grid.length; j++) {
			
			for(int i = 0; i < grid[0].length; i++) {
				
				
				if(grid[i][j] != null) {
					
					listforclicking.add(grid[i][j]);
					
					}
				}	
			}
	}
	
	public void makeArrayFromList() {
		
		
		int f = 0;
		
		for(int j = 0; j < grid.length; j++) {
			
			for(int i = 0; i < grid[0].length; i++) {
					
				if(grid[i][j] != null) {
					grid[i][j].setCovered(listforclicking.get(f).getCovered());
					f++;
					
					}
				}	
			}

	}	
	
	public void print() {
		
		for(int j = 0; j < tempgrid.length; j++) {
			
			for(int i = 0; i < tempgrid[0].length; i++) {
				
				
				System.out.print(tempgrid[i][j]);
				}
			System.out.println();
			}
	}
	
	public ArrayList<Tile> getGrid(){
		
		return listforclicking;
	}
	
	
	
	
	public void drawGrid(PApplet marker) {
		
		marker.fill(0,255,0);
		
		for(int j = 0; j < grid.length; j++) {
			
			
			for(int i = 0; i < grid[0].length; i++) {
				
				if(grid[i][j] != null) {
					
				//System.out.println(grid[i][j].getFlag() );
				
				 if(grid[i][j].getCovered() == true && grid[i][j].getFlag() == false) {
					 marker.fill(192,192,192);
					 marker.rect(grid[i][j].getX(), grid[i][j].getY(), 40,40);
				 }
				 else if(grid[i][j].getCovered() == true && grid[i][j].getFlag() == true) {
					 
					 marker.fill(255,0,0);
					 marker.rect(grid[i][j].getX(), grid[i][j].getY(), 40,40);
				 }
				 else {
					 
					 
						 
						 if(grid[i][j].getBomb() == true) {
							marker.fill(0);
						 	marker.rect(grid[i][j].getX(), grid[i][j].getY(), 40,40);
						 }
						 else
						 {
							
							 marker.fill(220,220,220);
							 marker.rect(grid[i][j].getX(), grid[i][j].getY(), 40,40);
							
							 marker.textSize(30);
							 if(grid[i][j].getDisplay().length() > 0) {
								// System.out.println("fsdfs");
							 
								 switch(grid[i][j].getDisplay()) {
							 
							 		case "1":
							 			marker.fill(0,0,255);
							 			marker.text(grid[i][j].getDisplay() ,grid[i][j].getX() + 10,grid[i][j].getY() + 38);
							 			break;
							 		case "2":
							 			marker.fill(0,128,0);
							 			marker.text(grid[i][j].getDisplay() ,grid[i][j].getX() + 10,grid[i][j].getY() + 38);
							 			break;
							 		case "3":
							 			marker.fill(200,0,0);
							 			marker.text(grid[i][j].getDisplay() ,grid[i][j].getX() + 10,grid[i][j].getY() + 38);
							 			break;
							 		case "4":
							 			marker.fill(148,0,211);
							 			marker.text(grid[i][j].getDisplay() ,grid[i][j].getX() + 10,grid[i][j].getY() + 38);
							 			break;
							 		case "5":
							 			marker.fill(255,140,0);
							 			marker.text(grid[i][j].getDisplay() ,grid[i][j].getX() + 10,grid[i][j].getY() + 38);
							 			break;
							 		case "6":
							 			marker.fill(255,105,180);
							 			marker.text(grid[i][j].getDisplay() ,grid[i][j].getX() + 10,grid[i][j].getY() + 38);
							 			break;
							 		case "7":
							 			marker.fill(255);
							 			marker.text(grid[i][j].getDisplay() ,grid[i][j].getX() + 10,grid[i][j].getY() + 38);
							 			break;
							 		case "8":
							 			marker.fill(255,255,0);
							 			marker.text(grid[i][j].getDisplay() ,grid[i][j].getX() + 10,grid[i][j].getY() + 38);
							 			break;
	
								 
							 }
							 
						 }
					 }
					 
					
				 }
				
				
			}
				
			}
			}
			
			
			
		}
	
	
	
	public void drawRandomizedGrid() {
		
		String f = "";
		
		
	
		
		for(int x = 0; x < 21; x++) {
		
			for(int y = 0; y < 21; y++) {
				
				if((int)(Math.random() * 5) == 2) {
					
					f += "5";
					
				//	System.out.println(x + " " + y);
					
				}else {
					f += "*";
					
				}
				
		
			}
			
			f+= "\n";
		}
		
		
		FileWriter writer = null;
		
		try {
			writer = new FileWriter("Grid//Grid");
			
			writer.write(f);
			writer.close();
			
		
			
		} catch(IOException e){
			
			e.printStackTrace();
		}
		
		
	}
	
	public void readData(String filename, char[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
					reader = new FileReader(dataFile);
					in = new Scanner(reader);

					while (in.hasNext()) {
						String line = in.nextLine();
						for(int i = 0; i < line.length(); i++)
							if (i < gameData.length && count < gameData[i].length) {
								gameData[i][count] = line.charAt(i);
							}

						count++;
					}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}
			
		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}
}
