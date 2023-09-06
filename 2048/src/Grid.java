import java.util.ArrayList;

import processing.core.PApplet;

public class Grid {

	private Slots slots[][];
	private boolean cansomethingmove;
	public Grid() {
		
		slots = new Slots[4][4];
		
		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
				
					if(i == 1 ) {
						slots[i][j] = new Slots(i,j,true, new Tile(1,1,2,false));
						
					}
					else
						slots[i][j] = new Slots(i,j,false,null);
				
				
				}
			}
		
		
		
	}
	
	
	public String grabDATA() {
		String string = "";
		int s = 0;
		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
				
				if(slots[i][j].getFilled() == true ) {
					s =+ slots[i][j].getTile().getX();
					s =+ slots[i][j].getTile().getY();
					s =+ slots[i][j].getTile().getValue();
				}
			
			}
		}
		
		string = s + "";
		
		return string;
		
	}
	public boolean transferTile(int x, int y, int x2, int y2) {
		
		
		if(slots[x][y].getFilled() == true && slots[x2][y2].getFilled() == false) {
			
			Tile temp = slots[x][y].getTile();
			slots[x][y].setTile(null);
			slots[x][y].setFilled(false);
			slots[x2][y2].setTile(temp);
			slots[x2][y2].setFilled(true);
			
			slots[x2][y2].getTile().setMoved(true);
			
			System.out.println(x + "" + y + x2 + y2);
			return true;
		}
		else if(slots[x][y].getFilled() == true && slots[x2][y2].getFilled() == true && slots[x2][y2].getTile().getMoved() == false) {
			
			if(combine(x,y,x2,y2))
				slots[x2][y2].getTile().setMoved(true);
				
			return false;
		}
		else {
			
			
			return false;
		}
	}
	
	
	
	
	
	
	public boolean combine(int x, int y, int x2, int y2) {
		
	
		
		
	if(slots[x][y].getTile() != null && slots[x2][y2].getTile() != null) {
			if(slots[x][y].getTile().getValue() == slots[x2][y2].getTile().getValue()) {
				
				
				slots[x2][y2].getTile().setValue(slots[x][y].getTile().getValue() + slots[x2][y2].getTile().getValue());
				slots[x][y].setTile(null);
				slots[x][y].setFilled(false);
				slots[x2][y2].getTile().setMoved(true);	
				return true;
			}
			else {
				
				return false;
			}
		}
	else {
		
		return false;
		
	}
	}
	
	public void randomADD() {
		
		
	
		boolean moved = false;
		int count = 0;
	for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
				
				if(slots[i][j] != null && slots[i][j].getFilled() == true) {
					if(slots[i][j].getTile().getMoved() == false) {
						
						moved = true;
						
					}
				}
			}
		}
		
		
		
		if(moved == true) {
			
				//System.out.println(isMoved);
				ArrayList<Integer> availablenumbersx = new ArrayList<Integer>();
				ArrayList<Integer> availablenumbersy = new ArrayList<Integer>();
				
				for(int j = 0; j < slots.length; j++) {
					
					for(int i = 0; i < slots[0].length; i++) {
						
						if(slots[i][j].getFilled() == false) {
		
							availablenumbersx.add(i);
							availablenumbersy.add(j);
							
							
					}
				
					}
				}
			
			
			int randomcoord = (int)(Math.random() * (availablenumbersx.size()-1));
			int random2or4 = (int)(Math.random() * 4);
			
			//System.out.println(availablenumbersx.get(randomcoord));
			if(random2or4 == 2) {
				
				slots[availablenumbersx.get(randomcoord)][availablenumbersy.get(randomcoord)].setFilled(true);
				slots[availablenumbersx.get(randomcoord)][availablenumbersy.get(randomcoord)].setTile(new Tile(0,0,4,false));
			}
			else {
				
				slots[availablenumbersx.get(randomcoord)][availablenumbersy.get(randomcoord)].setFilled(true);
				slots[availablenumbersx.get(randomcoord)][availablenumbersy.get(randomcoord)].setTile(new Tile(0,0,2,false));
				}
			}
		//}
		//else {
			
			//cansomethingmove = true;
		//}
	}
	
	
	public void up() {
		

		transferTile(0,3,0,2);
		transferTile(1,3,1,2);
		transferTile(2,3,2,2);
		transferTile(3,3,3,2);
		
		transferTile(0,2,0,1);
		transferTile(1,2,1,1);
		transferTile(2,2,2,1);
		transferTile(3,2,3,1);
		
		
		transferTile(0,1,0,0);
		transferTile(1,1,1,0);
		transferTile(2,1,2,0);
		transferTile(3,1,3,0);
		
//		for(int j = 0; j < slots.length; j++) {
//			
//			for(int i = 0; i < slots[0].length; i++) {
//				
//				if(slots[i][j].getTile() != null && j != 0 && slots[i][j].getFilled() == true) {
//					if(slots[i][j].getTile().getMoved() == false ) {
//						
//						transferTile(i,j,i,j-1);
//					}
//				
//				}
//			}
//		}
//		



		
	}
	
	public void reset() {
		
	for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
				
				if(slots[i][j].getTile() != null) {
					
					
					slots[i][j].getTile().setMoved(false);
					
						}
					}
				}
		
	}
	public void down() {
		


		
		
		transferTile(0,2,0,3);
		transferTile(1,2,1,3);
		transferTile(2,2,2,3);
		transferTile(3,2,3,3);
		
		
		transferTile(0,1,0,2);
		transferTile(1,1,1,2);
		transferTile(2,1,2,2);
		transferTile(3,1,3,2);
		
		transferTile(0,0,0,1);
		transferTile(1,0,1,1);
		transferTile(2,0,2,1);
		transferTile(3,0,3,1);
		


	}
	
	public void left() {


	
		transferTile(1,0,0,0);
		transferTile(1,1,0,1);
		transferTile(1,2,0,2);
		transferTile(1,3,0,3);
		transferTile(2,0,1,0);
		transferTile(2,1,1,1);
		transferTile(2,2,1,2);
		transferTile(2,3,1,3);
		
		transferTile(3,0,2,0);
		transferTile(3,1,2,1);
		transferTile(3,2,2,2);
		transferTile(3,3,2,3);
		
		
		
		
		


	}
	
	public void right() {


	
		transferTile(2,0,3,0);
		transferTile(2,1,3,1);
		transferTile(2,2,3,2);
		transferTile(2,3,3,3);
		
		transferTile(1,0,2,0);
		transferTile(1,1,2,1);
		transferTile(1,2,2,2);
		transferTile(1,3,2,3);
		
		
		
		transferTile(0,0,1,0);
		transferTile(0,1,1,1);
		transferTile(0,2,1,2);
		transferTile(0,3,1,3);
		
		


	}
	
	
	
	public void draw(PApplet marker) {
		
		

		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
				
				if(slots[i][j].getFilled() == false) {
					
					marker.fill(255);
					marker.rect(slots[i][j].getX() * 250, slots[i][j].getY() * 250, 250, 250 );
				}
				else {
					
					 switch(slots[i][j].getTile().getValue()) {
					 	case 2:
					 		marker.fill(255,255,0);
					 		break;
					 	case 4:
					 		marker.fill(173,255,47);
					 		break;
					 	case 8:
					 		marker.fill(0,128,0);
					 		break;
					 	case 16:
					 		marker.fill(0,255,255);
					 		break;
					 	case 32:
					 		marker.fill(30,144,255);
					 		break;
					 	case 64:
					 		marker.fill(138,43,226);
					 		break;
					 	case 128:
					 		marker.fill(255,105,180);
					 		break;
					 	case 256:
					 		marker.fill(255,0,0);
					 		break;
					 	case 512:
					 		marker.fill(255,140,0);
					 		break;
					 	case 1024:
					 		marker.fill(39,69,19);
					 		break;
					 	case 2048:
					 		marker.fill(0);
					 		break;
					 
					 
					 
					 
					 }
					
					marker.rect(slots[i][j].getX() * 250, slots[i][j].getY() * 250, 250, 250 );
					
				}
				
				}
			}
		
		
	}
	
	
}
