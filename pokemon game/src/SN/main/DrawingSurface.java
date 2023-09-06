package SN.main;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import processing.core.PApplet;
import processing.core.PImage;
import SN.Battle.Battle;
import SN.Player.Player;
import SN.Pokemons.*;
import java.io.FileWriter;

                                     
public class DrawingSurface extends PApplet {

	private PokemonGrid board;
	private Battle battleScreen;
	private int spawnpointx = 10;
	private int spawnpointy = 15;
	private boolean moved = false;
	private int countx = 0;
	private int county = 0;
	private boolean battlescene = false;
	private Pokemon pokemonFoundInGrass;
	private NButton run = new NButton(500, 700);
	private boolean switchscreen = false;
	private boolean attackScene = false;
	private ArrayList<Pokemon> orderOfPokemons = new ArrayList<Pokemon>(Arrays.asList(new Blastoise(),null,null,null,null,null));
	private Player player;
	private PImage grass;
	private PImage tallGrass;
	private PImage path;
	private PImage rocks;
	private PImage redCross;
	private PImage persontallGrass;
	private PImage persongrass;
	private PImage personpath;
	private PImage personStat;
	private int numOfCaptures;
	private boolean statscreen = false;
	private boolean started  = false;
	private int p = 0;
	private int currentpartyList = 0;
	private NButton startGame;
	private boolean pressed;
	
	public DrawingSurface() {
		numOfCaptures = 0;
		
		player = new Player(orderOfPokemons);
		player.readPokemon();
		
		if(player.getP1() != null){player.getP1().recover();}
		if(player.getP2() != null){
			player.getP2().recover();}
		
		if(player.getP3() != null) 
			player.getP3().recover();
		if(player.getP4() != null) 
			player.getP4().recover();
		if(player.getP5() != null) 
			player.getP5().recover();
		if(player.getP6() != null) 
			player.getP6().recover();
		
		startGame = new NButton(230, 60);
		pressed = false;
	}
	
	
	public void setup() {
	

		grass = loadImage("Textures//grass.jpg");
		redCross = loadImage("Textures//redCross.jpg");
		rocks = loadImage("Textures//rocks.jpg");
		tallGrass = loadImage("Textures//tallGrass.jpg");
		path = loadImage("Textures//path.jpg");
		persontallGrass = loadImage("Textures//personOnTallGrass.jpg");
		personpath = loadImage("Textures//personOnPath.jpg");
		persongrass = loadImage("Textures//personOnGrass.jpg");
		personStat = loadImage("Textures//personStat.jpg");
		//redCross = loadImage("Textures//StandingDown.jpg");
		
			board = new PokemonGrid("SavedMap" , grass, tallGrass, path,rocks, redCross, persongrass, personpath, persontallGrass, personStat ,250 );
		
			
	}
	

	public void draw() { 
		
		startGame.drawButton(this, 100, 100, "Start Game");
		text("click on the start game button if you want to play", 130, 440);
		text("Rules:", 940, 200);
		text("The person is the stick figure. If you want to move him, click on the right, left, up, or down arrow key", 940, 240);
		text("When you walk around in the grass, you have a chance to encounter pokemon, if you encounter one, you will go into a battle with it",940, 280);
		text("When the opponent has low hp, you can try to capture it", 940, 330);
		text("If you press enter, you will be shown your party, that is the pokemon you currently have, you are limited to 6 at a time \n clicking on a pokemon will show stats, enter to see party again, tab to leave", 940, 380);
		text("if you right click a pokemon while seeing your party, you will release it, it will no longer be with you and you've cleared a party spot", 940, 440);
		text("If you capture a pokemon and you already have 6, the 6th pokemon will be removed and replaced by the one you've captured ", 940, 500);	
		text("press y to save", 940, 560);
		if (pressed == true) {
			
		background(255);   
		fill(0);
		
		
		//System.out.println(started);
		if(battlescene == false && attackScene == false && switchscreen == false) { // if not in battle
		
		
		if (board != null) {
			
			if(started == false) {
				countx = board.returnX();
				county = board.returnY();
			}
			
			board.draw(this, countx,county, 20, 20);
			
			if(moved == false) {
				
				board.drawthing(0,0);
				
				}
		}
		
		
		
		}
		else if(switchscreen == true && statscreen == false) {
			
			battleScreen.drawSwitchScreen(this, player);
		}
		else if(switchscreen == true && statscreen == true && battlescene == false && attackScene == false) {
			
			if(p == 0)
				player.drawSwitchScreen(this, player);
			else if(p ==1)
				player.getP1().drawStatPage(this);
			else if(p ==2)
				player.getP2().drawStatPage(this);
			else if(p ==3)
				player.getP3().drawStatPage(this);
			else if(p ==4)
				player.getP4().drawStatPage(this);
			else if(p ==5)
				player.getP5().drawStatPage(this);
			else if(p ==6)
				player.getP6().drawStatPage(this);
		}
		else {
			battleScreen = new Battle(player.getP1(), pokemonFoundInGrass);
			if(pokemonFoundInGrass.getHealth() <= 0) {
				numOfCaptures = 0;
				attackScene = false;
				battlescene = false;
				battleScreen.getPokemon1().addXp(100);
				battleScreen.getPokemon1().levelUP();
				battleScreen.getPokemon1().setAttack(player.getP1().getTrueAttack());
				battleScreen.getPokemon1().setSpeed(player.getP1().getTrueSpeed());
				battleScreen.getPokemon1().setDefense(player.getP1().getTrueDefense());

				battleScreen.getPokemon1().setAttackT(false);
				battleScreen.getPokemon1().setDefenseT(false);
				battleScreen.getPokemon1().setSpeedT(false);
				
					
					battleScreen.getPokemon1().evolve();
				
			}
			else {
				
			
				if(battleScreen.getPokemon1().getHealth() <= 0) {
					
					numOfCaptures = 0;
					
					
					for(Pokemon e: orderOfPokemons) {
						
						if(e != null) {
							
							if(e.getHealth() > 0) {
								
								switchscreen = true;
							}
							else {
								battlescene = false;
								attackScene = false;
								
							}
						}
					}
					
					}
					else {
					
					if(attackScene == true) {
						battlescene = false;
						battleScreen.drawAttackScreen(this, player.getP1());
						
					
						battleScreen.startBattle();
					
						//}
						
						battleScreen.drawOrderChooser(this);
						
						
						
						if(battleScreen.getPokemon1().getSpeedT() == true) {
							
							battleScreen.getPokemon1().drawSpeedChange(this, 400, 150);
						}
						if(battleScreen.getPokemon1().getAttackT() == true) {
							
							battleScreen.getPokemon1().drawAttackChange(this, 500, 150);
						}
						if(battleScreen.getPokemon1().getDefenseT() == true) {
							
							battleScreen.getPokemon1().drawDefenseChange(this, 600, 150);
						}
						
						if(battleScreen.getPokemon2().getSpeedT() == true) {
							
							battleScreen.getPokemon2().drawSpeedChange(this, 1100, 100);
						}
						if(battleScreen.getPokemon2().getAttackT() == true) {
							
							battleScreen.getPokemon2().drawAttackChange(this, 1200, 100);
						}
						if(battleScreen.getPokemon2().getDefenseT() == true) {
							
							battleScreen.getPokemon2().drawDefenseChange(this, 1300, 100);
						}
						
						//System.out.println(battleScreen.getPokemon1().getDefense());
						
						
					//	System.out.println(battleScreen.getTurn1() + " turn1");
						//System.out.println(battleScreen.getTurn2()+ " turn2");
					}
					else {
						//battleScreen = new Battle(player.getP1(), pokemonFoundInGrass);
				
						battleScreen.drawBattleScreen(this, player.getP1(), battleScreen.getPokemon2());
						
						run.drawButton(this, 100, 50, "battle");
				
						
						}
					}
				}
			}
		}
	}
	
	
	
	public void mousePressed() {
		
	
		if (mouseX >= startGame.getX() && mouseX <= startGame.getX() + startGame.getW() && mouseY >= startGame.getY()
				&& mouseY <= startGame.getY() + startGame.getL()) {
			pressed = true;
		}
		if (pressed) {
		int leftright = 0;
		if (mouseButton == LEFT) {
			
			leftright = 1;
			
			if(leftright == 1) {
			if(battlescene == true && attackScene == false) {
				
				if(mouseX > run.getX() && mouseX < run.getX() + run.getL() && mouseY > run.getY() && mouseY < run.getY() + run.getW()) {
					run.mouseAnimation(this, 100, 50);
					attackScene = true;
				}
			}
			
			
			if(switchscreen == true && statscreen == false) {
				
				boolean switched = false;
				
				
					if(mouseX > 200 && mouseX < 700  && mouseY > 400 && mouseY < 500) {
						
						if(player.getP2().getHealth() > 0) {
							Pokemon p = player.getP1();
							player.setP1(player.getP2());
							player.setP2(p);
						
							switched = true;
							//System.out.println(player.getP1().getHealth());
						
							battleScreen = new Battle(player.getP1(),pokemonFoundInGrass);
							battleScreen.drawAttackScreen(this, player.getP1());
							battleScreen.setTurn1(false);
							battleScreen.setTurn2(true);
						
						
						
							}
						}
					else if(mouseX > 200 && mouseX < 700  && mouseY > 700 && mouseY < 800) {
						if(player.getP3().getHealth() > 0) {
						Pokemon p = player.getP1();
						player.setP1(player.getP3());
						player.setP3(p);
						
						
						//System.out.println(player.getP1().getHealth());
						switched = true;
						battleScreen = new Battle(player.getP1(),pokemonFoundInGrass);
						battleScreen.drawAttackScreen(this, player.getP1());
						battleScreen.setTurn1(false);
						battleScreen.setTurn2(true);
						
						}
						}
					else if(mouseX > 1100 && mouseX < 1600  && mouseY > 100 && mouseY < 200) {
						if(player.getP4().getHealth() > 0) {
						Pokemon p = player.getP1();
						player.setP1(player.getP4());
						player.setP4(p);
						
						
						//System.out.println(player.getP1().getHealth());
						switched = true;
						battleScreen = new Battle(player.getP1(),pokemonFoundInGrass);
						battleScreen.drawAttackScreen(this, player.getP1());
						battleScreen.setTurn1(false);
						battleScreen.setTurn2(true);
						}
						
						}
					else if(mouseX > 1100 && mouseX < 1600  && mouseY > 400 && mouseY < 500) {
						if(player.getP5().getHealth() > 0) {
						Pokemon p = player.getP1();
						player.setP1(player.getP5());
						player.setP5(p);
						
						
					//	System.out.println(player.getP1().getHealth());
						switched = true;
						battleScreen = new Battle(player.getP1(),pokemonFoundInGrass);
						battleScreen.drawAttackScreen(this, player.getP1());
						battleScreen.setTurn1(false);
						battleScreen.setTurn2(true);
						
						}
						}
					else if(mouseX > 1100 && mouseX < 1600  && mouseY > 700 && mouseY < 800) {
						if(player.getP6().getHealth() > 0) {
						Pokemon p = player.getP1();
						player.setP1(player.getP6());
						player.setP6(p);
						
						
						
						//System.out.println(player.getP1().getHealth());
						switched = true;
						battleScreen = new Battle(player.getP1(),pokemonFoundInGrass);
						battleScreen.drawAttackScreen(this, player.getP1());
						battleScreen.setTurn1(false);
						battleScreen.setTurn2(true);
						
						}
						
						}

					if(switched == true) {
						switchscreen = false;
						attackScene = true;
						//System.out.println(battleScreen.getPokemon1().getHealth() + " HP" + battleScreen.getPokemon1().getHealth());
						//battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
						//System.out.println(battleScreen.getPokemon1().getHealth() + " HP" + battleScreen.getPokemon1().getHealth());
						//battleScreen.setTurn1(true);
						//battleScreen.setTurn2(false);
					}
				}
			}
		if(switchscreen == true && statscreen == true && battlescene == false && attackScene == false) {
			
			
			
				if(mouseX > 200 && mouseX < 700  && mouseY > 100 && mouseY < 200) {
					p = 1;
					player.getP1().drawStatPage(this);
				}
				else if(mouseX > 200 && mouseX < 700  && mouseY > 400 && mouseY < 500) {
						p = 2;
						player.getP2().drawStatPage(this);
					}
				else if(mouseX > 200 && mouseX < 700  && mouseY > 700 && mouseY < 800) {
						p = 3;	
						player.getP3().drawStatPage(this);
					}
				else if(mouseX > 1100 && mouseX < 1600  && mouseY > 100 && mouseY < 200) {
						p = 4;
						player.getP4().drawStatPage(this);
					}
				else if(mouseX > 1100 && mouseX < 1600  && mouseY > 400 && mouseY < 500) {
						p = 5;
						player.getP5().drawStatPage(this);
					}
				else if(mouseX > 1100 && mouseX < 1600  && mouseY > 700 && mouseY < 800) {
						p = 6;
						player.getP6().drawStatPage(this);
					}
		}
			if(attackScene == true && battlescene == false) {
				
				
				if(player.getP1().getHealth() >= 0 && pokemonFoundInGrass.getHealth() >= 0) {
					
					
					if(battleScreen.getTurn1() == true) {
						
						if(mouseX >= battleScreen.getCapturingButton().getX() && mouseX <= battleScreen.getCapturingButton().getX() + battleScreen.getCapturingButton().getL() && mouseY >= battleScreen.getCapturingButton().getY() && mouseY <= battleScreen.getCapturingButton().getY() + battleScreen.getCapturingButton().getW()){
								if(battleScreen.getPokemon2().canCapture()) {
									Pokemon p = battleScreen.getPokemon2();
									currentpartyList++;
									System.out.println(currentpartyList);
									if(currentpartyList >= 5) {
										
										orderOfPokemons.set(5, p);
									}else {
										
									orderOfPokemons.set(currentpartyList , p);
									}
									System.out.println("You've successfully captured pokemon " + battleScreen.getPokemon2().getName());
									battlescene = false;
									attackScene = false;
									numOfCaptures++;
								}
								if(!battleScreen.getPokemon2().canCapture()) {
									
									battleScreen.setTurn1(false);
									battleScreen.setTurn2(true);
								}
								
							}
					}
					else {
						
						battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
						System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );							
						if(battleScreen.getPokemon1().getHealth() > 0) {
							if(mouseX >= battleScreen.getCapturingButton().getX() && mouseX <= battleScreen.getCapturingButton().getX() + battleScreen.getCapturingButton().getL() && mouseY >= battleScreen.getCapturingButton().getY() && mouseY <= battleScreen.getCapturingButton().getY() + battleScreen.getCapturingButton().getW()){
								if(battleScreen.getPokemon2().canCapture()) {
									Pokemon p = battleScreen.getPokemon2();
									currentpartyList++;
									System.out.println(currentpartyList);
									if(currentpartyList >= 5) {
										
										orderOfPokemons.set(5, p);
									}else {
										
									orderOfPokemons.set(currentpartyList, p);
									}
									System.out.println("You've successfully captured pokemon " + battleScreen.getPokemon2().getName());
									battlescene = false;
									attackScene = false;
									numOfCaptures++;
								}	
							
								if(!battleScreen.getPokemon2().canCapture()) {
									//System.out.println
									battleScreen.setTurn1(false);
									battleScreen.setTurn2(true);
								}
							
							}
						}
					}
					
				if(mouseX >= 30 && mouseX <= 180 && mouseY >= 110 && mouseY <= 160) {
					
					
					
					switchscreen = true;
					attackScene = false;
					
					
					
					
					
				}
				
				if(mouseX > 400 && mouseX < 800  && mouseY > 500 && mouseY < 630) {
					if(battleScreen.getTurn1() == true) {
						
						
							
						battleScreen.getPokemon1().attack(battleScreen.getPokemon1().getMoves().get(0), battleScreen.getPokemon2());
						System.out.println("YOU ATTACKED  OPPONENT NOW HAS  " + " HP " +  battleScreen.getPokemon2().getHealth() + " D " + battleScreen.getPokemon2().getDefense() + " A " + battleScreen.getPokemon2().getAttack() + " S " + battleScreen.getPokemon2().getSpeed() );
						
						if(battleScreen.getPokemon2().getHealth() > 0) {
							battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
							System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );
						}
					
					}
					else {
						
							battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
							System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );							
							if(battleScreen.getPokemon1().getHealth() > 0) {
								battleScreen.getPokemon1().attack(battleScreen.getPokemon1().getMoves().get(0), battleScreen.getPokemon2());
								System.out.println("YOU ATTACKED  OPPONENT NOW HAS  " + " HP " +  battleScreen.getPokemon2().getHealth() + " D " + battleScreen.getPokemon2().getDefense() + " A " + battleScreen.getPokemon2().getAttack() + " S " + battleScreen.getPokemon2().getSpeed() );
							}
					
					}
				}
				else if(mouseX > 1100 && mouseX < 1500  && mouseY > 500 && mouseY < 630) {
					
					
					if(battleScreen.getTurn1() == true) {
						
						battleScreen.getPokemon1().attack(battleScreen.getPokemon1().getMoves().get(1), battleScreen.getPokemon2());
						System.out.println("YOU ATTACKED  OPPONENT NOW HAS  " + " HP " +  battleScreen.getPokemon2().getHealth() + " D " + battleScreen.getPokemon2().getDefense() + " A " + battleScreen.getPokemon2().getAttack() + " S " + battleScreen.getPokemon2().getSpeed() );
						
						if(battleScreen.getPokemon2().getHealth() > 0) {
							battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
							System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );						}
					
					}
					else {
						
							battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
							System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );							
							if(battleScreen.getPokemon1().getHealth() > 0) {
								battleScreen.getPokemon1().attack(battleScreen.getPokemon1().getMoves().get(1), battleScreen.getPokemon2());
								System.out.println("YOU ATTACKED  OPPONENT NOW HAS  " + " HP " +  battleScreen.getPokemon2().getHealth() + " D " + battleScreen.getPokemon2().getDefense() + " A " + battleScreen.getPokemon2().getAttack() + " S " + battleScreen.getPokemon2().getSpeed() );
							}
					
					}
					
				}
				else if(mouseX > 400 && mouseX < 800  && mouseY > 700 && mouseY < 830) {
					
					
					if(battleScreen.getTurn1() == true) {
						
						battleScreen.getPokemon1().attack(battleScreen.getPokemon1().getMoves().get(2), battleScreen.getPokemon2());
						System.out.println("YOU ATTACKED  OPPONENT NOW HAS  " + " HP " +  battleScreen.getPokemon2().getHealth() + " D " + battleScreen.getPokemon2().getDefense() + " A " + battleScreen.getPokemon2().getAttack() + " S " + battleScreen.getPokemon2().getSpeed() );
						
						if(battleScreen.getPokemon2().getHealth() > 0) {
							battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
							System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );						}
					
					}
					else {
						
							battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
							System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );							
							if(battleScreen.getPokemon1().getHealth() > 0) {
								battleScreen.getPokemon1().attack(battleScreen.getPokemon1().getMoves().get(2), battleScreen.getPokemon2());
								System.out.println("YOU ATTACKED  OPPONENT NOW HAS  " + " HP " +  battleScreen.getPokemon2().getHealth() + " D " + battleScreen.getPokemon2().getDefense() + " A " + battleScreen.getPokemon2().getAttack() + " S " + battleScreen.getPokemon2().getSpeed() );
							}
					
					}
				}
				else if(mouseX > 1100 && mouseX < 1500  && mouseY > 700 && mouseY < 830) {
	
					if(battleScreen.getTurn1() == true) {
						
						battleScreen.getPokemon1().attack(battleScreen.getPokemon1().getMoves().get(3), battleScreen.getPokemon2());
						System.out.println("YOU ATTACKED  OPPONENT NOW HAS  " + " HP " +  battleScreen.getPokemon2().getHealth() + " D " + battleScreen.getPokemon2().getDefense() + " A " + battleScreen.getPokemon2().getAttack() + " S " + battleScreen.getPokemon2().getSpeed() );
						
						if(battleScreen.getPokemon2().getHealth() > 0) {
							battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
							System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );						}
					
					}
					else {
						
							battleScreen.getPokemon2().randomAttack(battleScreen.getPokemon1());
							System.out.println("OPPONENT ATTACKED  YOU NOW HAVE  " + " HP" +  battleScreen.getPokemon1().getHealth() +  " D " + battleScreen.getPokemon1().getDefense() + " A " + battleScreen.getPokemon1().getAttack() + " S " + battleScreen.getPokemon1().getSpeed()  );							
							if(battleScreen.getPokemon1().getHealth() > 0) {
								battleScreen.getPokemon1().attack(battleScreen.getPokemon1().getMoves().get(3), battleScreen.getPokemon2());
								System.out.println("YOU ATTACKED  OPPONENT NOW HAS  " + " HP " +  battleScreen.getPokemon2().getHealth() + " D " + battleScreen.getPokemon2().getDefense() + " A " + battleScreen.getPokemon2().getAttack() + " S " + battleScreen.getPokemon2().getSpeed() );
							}
					
					}
				}
				
			
				}
				else {
					
					battlescene = false;
					attackScene = false;
				}
			}
		}
		
			if(mouseButton == RIGHT) {
				
				leftright = 2;
				
				if(leftright == 2) {
				
				if(mouseX > 200 && mouseX < 700  && mouseY > 100 && mouseY < 200) {
					
					player.setP1(player.getP2());
					player.setP2(player.getP3());
					player.setP3(player.getP4());
					player.setP4(player.getP5());
					player.setP5(player.getP6());
					player.setP6(null);
					
				}
				else if(mouseX > 200 && mouseX < 700  && mouseY > 400 && mouseY < 500) {
					
					
					player.setP2(player.getP3());
					player.setP3(player.getP4());
					player.setP4(player.getP5());
					player.setP5(player.getP6());
					player.setP6(null);
					}
				else if(mouseX > 200 && mouseX < 700  && mouseY > 700 && mouseY < 800) {
					
					player.setP3(player.getP4());
					player.setP4(player.getP5());
					player.setP5(player.getP6());
					player.setP6(null);
					}
				else if(mouseX > 1100 && mouseX < 1600  && mouseY > 100 && mouseY < 200) {
					
					player.setP4(player.getP5());
					player.setP5(player.getP6());
					player.setP6(null);
					}
				else if(mouseX > 1100 && mouseX < 1600  && mouseY > 400 && mouseY < 500) {
					
					player.setP5(player.getP6());
					player.setP6(null);
					}
				else if(mouseX > 1100 && mouseX < 1600  && mouseY > 700 && mouseY < 800) {
					
					player.setP6(null);
						}
					
					}
				}
			}		
		}
	
	
				

	public void keyPressed() {
		started = true;
		if (keyCode == KeyEvent.VK_ENTER) {
			if(battlescene == false && attackScene == false) {
				p = 0;
				switchscreen = true;
				statscreen = true;
			}
			
		}
		if (keyCode == KeyEvent.VK_TAB) {
			//p = 0;
			
			//if(battlescene = false) {
				
				statscreen = false;
				switchscreen = false;
			//}
			
		}
		
		if(battlescene == false) {
			
			
		
		if (keyCode == KeyEvent.VK_DOWN) {
			
		//	player.savedPokemon();
			if(board.canMove(board.getX(), board.getY() + 1)  == true) {
			board.movething(0, 1);
			moved = true;
			county -= 40;
			//BOARD SWITCHUPS
			
			if(board.switchMap2()) {
				//System.out.println("dsaffsad");
			
				countx = 0;
				county = 0;
				board = new PokemonGrid("Map2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
				moved = false;
			}
			
			if(board.switchMap1()) {
			//	System.out.println("dsaffsad");
				
				
				if(board.getMap().equals("Map2.txt")) {
					countx = -8400;
					county = 0;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromMap2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				else if(board.getMap().equals("HealingCenter.txt")) {
					
					countx = -1200;
					county = -800;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromHealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				else if(board.getMap().equals("SavedMap") && board.getMapChar() == '3') {
					
					countx = -1200;
					county = -800;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromHealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
					moved = false;
				}
				else if(board.getMap().equals("SavedMap") && board.getMapChar() == '2') {
					
					countx = -8400;
					county = 0;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromMap2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
					moved = false;
				}
				
			}
			
			
			
			if(board.switchMapHealingCenter()) {
				//System.out.println("dsaffsad");
			
				countx = 0;
				county = 0;
				
				board = new PokemonGrid("HealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 50);
				moved = false;
				if(player.getP1() != null)
					if(player.getP1() != null){player.getP1().recover();}
				if(player.getP2() != null){player.getP2().recover();}
				
				if(player.getP3() != null) 
					player.getP3().recover();
				if(player.getP4() != null) 
					player.getP4().recover();
				if(player.getP5() != null) 
					player.getP5().recover();
				if(player.getP6() != null) 
					player.getP6().recover();
				
				
				
			}
			
			
			
			//ENCOUNTERS
			Pokemon p = board.encounter();
				if(p != null) {
					pokemonFoundInGrass = p;
					battlescene = board.getStatus();
					
				}
			}
		} else if (keyCode == KeyEvent.VK_UP) {
			
			if(board.canMove(board.getX(), board.getY() - 1)  == true) {
			board.movething(0, -1);
			moved = true;
			county += 40;
			Pokemon p = board.encounter();
			
			//BOARD SWITCHUPS
			if(board.switchMap2()) {
				
				
				countx = 0;
				county = 0;
				board = new PokemonGrid("Map2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
				moved = false;
			}
			
			if(board.switchMap1()) {
			
				
				
				if(board.getMap().equals("Map2.txt")) {
					countx = -8400;
					county = 0;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromMap2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				else if(board.getMap().equals("HealingCenter.txt")) {
					countx = -1200;
					county = -800;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromHealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
					moved = false;
				}
				else if(board.getMap().equals("SavedMap") && board.getMapChar() == '3') {
					
					countx = -1200;
					county = -800;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromHealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				else if(board.getMap().equals("SavedMap") && board.getMapChar() == '2') {
					
					countx = -8400;
					county = 0;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromMap2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
					moved = false;
				}
			}
			
			
			
			if(board.switchMapHealingCenter()) {
				//System.out.println("dsaffsad");
				
				countx = 0;
				county = 0;
				
				board = new PokemonGrid("HealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 50);
				moved = false;
				if(player.getP1() != null){player.getP1().recover();}
				if(player.getP2() != null){player.getP2().recover();}
				if(player.getP3() != null) 
					player.getP3().recover();
				if(player.getP4() != null) 
					player.getP4().recover();
				if(player.getP5() != null) 
					player.getP5().recover();
				if(player.getP6() != null) 
					player.getP6().recover();
				
				
			}
			
			
			//ENCOUNTERS
			if(p != null) {
				pokemonFoundInGrass = p;
				battlescene = board.getStatus();
			
			}
			}
		}else if (keyCode == KeyEvent.VK_LEFT) {
			if(board.canMove(board.getX() - 1, board.getY())  == true) {
			board.movething(-1, 0);
			countx += 40;
			moved = true;
			
		//	System.out.println(countx);
		//	System.out.println(county);
			Pokemon p = board.encounter();
			
			
			//BOARD SWITCHUPS
			if(board.switchMap2()) {
				//System.out.println("dsaffsad");
				
				countx = 0;
				county = 0;
				board = new PokemonGrid("Map2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
				moved = false;
			}
			
			if(board.switchMap1()) {
				System.out.println("dsaffsad " + board.getMapChar());
				
				
				if(board.getMap().equals("Map2.txt")) {
					countx = -8400;
					county = 0;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromMap2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
					moved = false;
				}
				else if(board.getMap().equals("HealingCenter.txt")) {
					countx = -1200;
					county = -800;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromHealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				else if(board.getMap().equals("SavedMap") && board.getMapChar() == '3') {
					
					countx = -1200;
					county = -800;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromHealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				else if(board.getMap().equals("SavedMap") && board.getMapChar() == '2') {
					
					countx = -8400;
					county = 0;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromMap2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				
			}
			
			
			
			if(board.switchMapHealingCenter()) {
			//	System.out.println("dsaffsad");
				
				countx = 0;
				county = 0;
				
				board = new PokemonGrid("HealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,50);
				moved = false;
				if(player.getP1() != null){player.getP1().recover();}
				if(player.getP2() != null){player.getP2().recover();}
				if(player.getP3() != null) 
					player.getP3().recover();
				if(player.getP4() != null) 
					player.getP4().recover();
				if(player.getP5() != null) 
					player.getP5().recover();
				if(player.getP6() != null) 
					player.getP6().recover();
				
				
			}
			
			
			//ENCOUNTERS
			if(p != null) {
				pokemonFoundInGrass = p;
				battlescene = board.getStatus();
				
			}
			}
		}
		else if (keyCode == KeyEvent.VK_RIGHT) {
			
			if(board.canMove(board.getX() + 1, board.getY())  == true) {
			board.movething(1, 0);
			countx -= 40;
			moved = true;
		//	System.out.println(countx);

			//BOARD SWITCHUPS
			if(board.switchMap2()) {
				//System.out.println("dsaffsad");
				
				countx = 0;
				county = 0;
				board = new PokemonGrid("Map2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
				moved = false;
			}
			
			if(board.switchMap1()) {
				//System.out.println("dsaffsad");
				
				
				if(board.getMap().equals("Map2.txt")) {
					countx = -8400;
					county = 0;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromMap2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				else if(board.getMap().equals("HealingCenter.txt")) {
					countx = -1200;
					county = -800;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromHealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 250);
					moved = false;
				}
				else if(board.getMap().equals("SavedMap") && board.getMapChar() == '3') {
					
					countx = -1200;
					county = -800;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromHealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				else if(board.getMap().equals("SavedMap") && board.getMapChar() == '2') {
					
					countx = -8400;
					county = 0;
					board = new PokemonGrid("Map1Tps//Map1SwitchFromMap2.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat ,250);
					moved = false;
				}
				
				
			}
			
			
			
			if(board.switchMapHealingCenter()) {
			//	System.out.println("dsaffsad");
				
				countx = 0;
				county = 0;
				
				board = new PokemonGrid("HealingCenter.txt" , grass, tallGrass, path,rocks,redCross,persongrass, personpath,persontallGrass, personStat, 50);
				moved = false;
				if(player.getP1() != null){player.getP1().recover();}
			
					if(player.getP2() != null){player.getP2().recover();}
				if(player.getP3() != null) 
					player.getP3().recover();
				if(player.getP4() != null) 
					player.getP4().recover();
				if(player.getP5() != null) 
					player.getP5().recover();
				if(player.getP6() != null) 
					player.getP6().recover();
				
				
			}
			
			
			//ENCOUNTERS
			Pokemon p = board.encounter();
			if(p != null) {
				pokemonFoundInGrass = p;
				battlescene = board.getStatus();
				
					}
				}
			}
		else if(keyCode == KeyEvent.VK_A){
			
			
			try {
			
			board.savedMap(countx,county);
			player.savedPokemon();
		} catch (IOException e) {
			System.out.println("n");
			e.printStackTrace();
		}
			
		}
		
		
			
	}
		
		
		
	}

}