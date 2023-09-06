
package SN.Pokemons;
import SN.Attack.*;
import SN.Type.*;

import java.text.DecimalFormat;
import java.util.ArrayList;



import SN.Attack.*;
import SN.Type.*;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;



public abstract class Pokemon {
	private ArrayList<Attack> moves;
	private float health;
	private float speed;
	private float defense;
	private float attack;
	private String name;
	private Type type;
	private float trueHp;
	private float rgeneHealth = (int)(Math.random() * 15) - (int)(Math.random() * 10);
	private float rgeneSpeed= (int)(Math.random() * 15) - (int)(Math.random() * 10);
	private float rgeneAttack= (int)(Math.random() * 15) - (int)(Math.random() * 10);
	private float rgeneDefense= (int)(Math.random() * 15) - (int)(Math.random() * 10);
	
	private float xp;
	private int level;
	private String filename;
	private Pokemon evolution;
	private int evolveLevel;
	
	private boolean speedChange = false;
	private boolean attackChange = false;
	private boolean defenseChange = false;
	
	private float trueAttack;
	private float trueDefense;
	private float trueSpeed;
	
	private float changeAttack = 0;
	private float changeDefense = 0;
	private float changeSpeed = 0;
	
	private float attackMultiplier;
	private float speedMultiplier;
	private float defenseMultiplier;
	
	
	public Pokemon(ArrayList<Attack> a, float h , float s, float d, float at, Type t, String name, float trueHP, String filename, float xp, int level, Pokemon evolution, int evolvingLevel) {
		moves = a; 
		health = h + rgeneHealth;
		speed = s + rgeneSpeed; 
		defense = d + rgeneDefense; 
		attack = at + rgeneAttack;
		trueAttack = attack;
		trueDefense = defense;
		trueSpeed = speed;
		type = t;
		this.name = name;
		trueHp = health;
		this.filename = filename;
		this.xp = xp;
		this.level = level;
		this.evolution = evolution;
		evolveLevel = evolvingLevel;
	}
	public ArrayList<Attack> getMoves() {
		return moves;
	}
	public float getHealth() {
		return health;
	}
	public float getTrueHp() {
		return trueHp;
	}
	public float getXp() {
		return xp;
	}
	public float getLevel() {
		return level;
	}
	public void setLevel(int level) {
		 this.level = level;
	}
	public void levelUP() {
		if(xp >= 1000) {
			level++;
			xp = 0;
		}
	}
	
	
	public void setTrueAttack(float a) {
		
		trueAttack = a;
	}
	public void setTrueDefense(float d) {
		
		trueDefense = d;
	}
	public void setTrueSpeed(float s) {
	
		trueSpeed = s;
	}
	
	public int getEvolveLevel() {
		
		return evolveLevel;
	}
	
	public Pokemon getEvolution() {
		
		return evolution;
	}
	public void evolve() {
		
		if(level == evolveLevel) {
			attack = evolution.getAttack() + rgeneAttack;
			defense = evolution.getDefense() + rgeneDefense;
			speed = evolution.getSpeed() + rgeneSpeed;
			health = evolution.getHealth() + rgeneHealth;
			type = evolution.getType();
			name = evolution.getName();
			filename = evolution.getFilename();
			trueHp = evolution.getTrueHp();
			evolveLevel = evolution.getEvolveLevel();
			evolution = evolution.getEvolution();
		}
		
	}
	public void addXp(int xp) {
		
		this.xp = this.xp + xp;
	}
	public String getName() {
		return name;
	}
	public float getDefense() {
		return defense;
	}
	
	public float getAttack() {
		return attack;
	}
	public float getSpeed() {
		return speed;
	}
	public float getTrueDefense() {
		return trueDefense;
	}
	
	public float getTrueAttack() {
		return trueAttack;
	}
	
	
	public void setAttackT(boolean set) {
		
		attackChange = set;
	}
	public void setDefenseT(boolean set) {
		
		defenseChange = set;
	}
	public void setSpeedT(boolean set) {
		
		speedChange = set;
	}
	public float getTrueSpeed() {
		return trueSpeed;
	}
	public Type getType() {
		return type;
	}
	public float takeDamage(float damage) {
		health = health + damage;
		return health;
	}
	public String getFilename() {
		return filename;
	}
	public void setMoves(ArrayList<Attack> moves) {
		this.moves = moves;
	}
	
	public void recover() {
		health = trueHp;
		attack = trueAttack;
		speed = trueSpeed;
		defense = trueDefense;
		changeAttack = 0;
		changeDefense = 0;
		changeSpeed = 0;
	}
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	public void setAttack(float attack) {
		this.attack = attack;
	}
	public void setDefense(float defense) {
		this.defense = defense;
	}
	
	public boolean getSpeedT() {
		
		return speedChange;
	}
	public boolean getAttackT() {
		
		return attackChange;
	}
	public boolean getDefenseT() {
	
		return defenseChange;
	}
	public void healthBar(PApplet marker, float x, float y) {
		marker.fill(0,0,0);
		marker.rect(x, y, trueHp, 25);
		marker.fill(0,255,0);
		marker.rect(x + 10, y + 5, trueHp * (health / trueHp) -25, 15 );
		marker.fill(0,0,0);
	}
	public void xpBar(PApplet marker, float x, float y) {
		marker.fill(0,0,0);
		marker.rect(x, y + 45, 300, 25);
		marker.fill(0,255,255);
		marker.rect(x + 10, y + 50, (xp/3.333333333f), 15 );
		marker.fill(0,0,0);
		marker.textSize(18);
		marker.text(level + "", x, y + 42);
	}

	
	public void randomAttack(Pokemon opponent) {
		int f = (int)(Math.random()* 4);
		Attack attack = null;
		if(f == 0) {
			
			attack = opponent.getMoves().get(0);
		}
		else if(f == 1) {
			
			attack = opponent.getMoves().get(1);
		}
		else if(f == 2) {
	
			attack = opponent.getMoves().get(2);
		}
		else if(f == 3) {
	
			attack = opponent.getMoves().get(3);
		}
		
		
		if(attack.getOpDamage() > 0) {
			
			opponent.takeDamage( (opponent.getDefense() * (1/10))  - attack.getOpDamage() + (this.attack * (1/10)) );
		}
	
		if(attack.getOpSpeed() != 0) {

			if(attack.getOpSpeed() == -1)
				opponent.speedMultiplier = 0.67f;
			else if(attack.getOpSpeed() == -2)
				opponent.speedMultiplier = 0.5f;
			else if(attack.getOpSpeed() == -3)
				opponent.speedMultiplier = 0.4f;
			else if(attack.getOpSpeed() == -4)
				opponent.speedMultiplier = 0.33f;
			else if(attack.getOpSpeed() == 4)
				opponent.speedMultiplier = 3;
			else if(attack.getOpSpeed() == 3)
				opponent.speedMultiplier = 2.5f;
			else if(attack.getOpSpeed() == 2)
				opponent.speedMultiplier = 2f;
			else if(attack.getOpSpeed() == 1)
				opponent.speedMultiplier = 1.5f;
		

			opponent.setSpeed(opponent.speedMultiplier * opponent.getSpeed());
			opponent.speedChange = true;
			opponent.changeSpeed += attack.getOpSpeed();
			
	}
	if(attack.getOpAttack() != 0) {
		
		float attack1 = 0;
		
		if(attack.getOpAttack() == -1)
			opponent.attackMultiplier = 0.67f;
		else if(attack.getOpAttack() == -2)
			opponent.attackMultiplier = 0.5f;
		else if(attack.getOpAttack() == -3)
			opponent.attackMultiplier = 0.4f;
		else if(attack.getOpAttack() == -4)
			opponent.attackMultiplier = 0.33f;
		else if(attack.getOpAttack() == 4)
			opponent.attackMultiplier = 3;
		else if(attack.getOpAttack() == 3)
			opponent.attackMultiplier = 2.5f;
		else if(attack.getOpAttack() == 2)
			opponent.attackMultiplier = 2f;
		else if(attack.getOpAttack() == 1)
			opponent.attackMultiplier = 1.5f;
	
			opponent.setAttack(opponent.attackMultiplier * opponent.getAttack());
			opponent.attackChange = true;
			opponent.changeAttack += attack.getOpAttack();
			
	}
	if(attack.getOpDefense() != 0) {
		
		
		
		if(attack.getOpDefense() == -1)
			opponent.defenseMultiplier = 0.67f;
		else if(attack.getOpDefense() == -2)
			opponent.defenseMultiplier = 0.5f;
		else if(attack.getOpDefense() == -3)
			opponent.defenseMultiplier = 0.4f;
		else if(attack.getOpDefense() == -4)
			opponent.defenseMultiplier = 0.33f;
		else if(attack.getOpDefense() == 4)
			opponent.defenseMultiplier = 3;
		else if(attack.getOpDefense() == 3)
			opponent.defenseMultiplier = 2.5f;
		else if(attack.getOpDefense() == 2)
			opponent.defenseMultiplier = 2f;
		else if(attack.getOpDefense() == 1)
			opponent.defenseMultiplier = 1.5f;
	
		opponent.setDefense(opponent.defenseMultiplier * opponent.getDefense());
		opponent.defenseChange = true;
		opponent.changeDefense += attack.getOpDefense();
	}
			
		
		if(attack.getSelfDamage() > 0) {
			
			takeDamage( (defense * (1/10))  - attack.getSelfDamage() + (this.attack * (1/10)) );
		}
	
		
		
		if(attack.getSelfSpeed() != 0) {
			
			if(attack.getSelfSpeed() == -1)
				speedMultiplier = 0.67f;
			else if(attack.getSelfSpeed() == -2)
				speedMultiplier = 0.5f;
			else if(attack.getSelfSpeed() == -3)
				speedMultiplier = 0.4f;
			else if(attack.getSelfSpeed() == -4)
				speedMultiplier = 0.33f;
			else if(attack.getSelfSpeed() == 4)
				speedMultiplier = 3;
			else if(attack.getSelfSpeed() == 3)
				speedMultiplier = 2.5f;
			else if(attack.getSelfSpeed() == 2)
				speedMultiplier = 2f;
			else if(attack.getSelfSpeed() == 1)
				speedMultiplier = 1.5f;
			
			speed = speedMultiplier * speed;
			speedChange = true;
			changeSpeed += attack.getSelfSpeed();
			
		}
		if(attack.getSelfAttack() > 0) {
			
			
			if(attack.getSelfAttack() == -1)
				attackMultiplier = 0.67f;
			else if(attack.getSelfAttack() == -2)
				attackMultiplier = 0.5f;
			else if(attack.getSelfAttack() == -3)
				attackMultiplier = 0.4f;
			else if(attack.getSelfAttack() == -4)
				attackMultiplier = 0.33f;
			else if(attack.getSelfAttack() == 4)
				attackMultiplier = 3;
			else if(attack.getSelfAttack() == 3)
				attackMultiplier = 2.5f;
			else if(attack.getSelfAttack() == 2)
				attackMultiplier = 2f;
			else if(attack.getSelfAttack() == 1)
				attackMultiplier = 1.5f;
			
			this.attack = attackMultiplier * this.attack;
			attackChange = true;
			changeAttack += attack.getSelfAttack();
			
		}
		if(attack.getSelfDefense() > 0) {
			
			if(attack.getSelfDefense() == -1)
				defenseMultiplier = 0.67f;
			else if(attack.getSelfDefense() == -2)
				defenseMultiplier = 0.5f;
			else if(attack.getSelfDefense() == -3)
				defenseMultiplier = 0.4f;
			else if(attack.getSelfDefense() == -4)
				defenseMultiplier = 0.33f;
			else if(attack.getSelfDefense() == 4)
				defenseMultiplier = 3;
			else if(attack.getSelfDefense() == 3)
				defenseMultiplier = 2.5f;
			else if(attack.getSelfDefense() == 2)
				defenseMultiplier = 2f;
			else if(attack.getSelfDefense() == 1)
				defenseMultiplier = 1.5f;
			
			defense = defenseMultiplier * defense;
			defenseChange = true;
			changeDefense *= attack.getSelfDefense();
		}
}
	
	
	
	public  void attack(Attack attack, Pokemon opponent) {
		
		if(attack.getOpDamage() > 0) {
			
			int x = 0;
			
			
				
				for(Type f : opponent.getType().getWeakness()) {
					
					//.println(f.getName() + " " + attack.getType().getName());
					if(attack.getType().getName().equals(f.getName())) {
						//.println("ITS SUPER EFFECTIVE");
						x++;
					}
				}
				
				for(Type f : opponent.getType().getStrength()) {
					
					//.println(f.getName() + " " + attack.getType().getName());
					if(attack.getType().getName().equals(f.getName())) {
						//.println("ITS SUPER EFFECTIVE");
						x--;
					}
				}
			

			if(x > 0) {
				//.println(x);
				opponent.takeDamage( 1.5f * ( (opponent.getDefense() * (1/5))  - (attack.getOpDamage() + (this.attack * (1/5)))) );
			}
			else if(x < 0) {
				//.println(x);
				opponent.takeDamage( 0.75f * ( (opponent.getDefense() * (1/5))  - (attack.getOpDamage() + (this.attack * (1/5)))) );
			}
			else if(x == 0) {
				//.println(x);
				opponent.takeDamage(( (opponent.getDefense() * (1/5))  - (attack.getOpDamage() + (this.attack * (1/5)))));
			}
			else {
				
				//.println(opponent.getType().getWeakness() + " " + attack.getType());
				opponent.takeDamage(( (opponent.getDefense() * (1/5))  - (attack.getOpDamage() + (this.attack * (1/5)))));
			}
		}
		

		if(attack.getOpDamage() > 0) {
			
			opponent.takeDamage( (opponent.getDefense() * (1/10))  - attack.getOpDamage() + (this.attack * (1/10)) );
		}
	
		if(attack.getOpSpeed() != 0) {
		
				
				
				if(attack.getOpSpeed() == -1)
					opponent.speedMultiplier = 0.67f;
				else if(attack.getOpSpeed() == -2)
					opponent.speedMultiplier = 0.5f;
				else if(attack.getOpSpeed() == -3)
					opponent.speedMultiplier = 0.4f;
				else if(attack.getOpSpeed() == -4)
					opponent.speedMultiplier = 0.33f;
				else if(attack.getOpSpeed() == 4)
					opponent.speedMultiplier = 3;
				else if(attack.getOpSpeed() == 3)
					opponent.speedMultiplier = 2.5f;
				else if(attack.getOpSpeed() == 2)
					opponent.speedMultiplier = 2f;
				else if(attack.getOpSpeed() == 1)
					opponent.speedMultiplier = 1.5f;
			
	
				opponent.setSpeed(opponent.speedMultiplier * opponent.getSpeed());
				opponent.speedChange = true;
				opponent.changeSpeed += attack.getOpSpeed();
				
		}
		if(attack.getOpAttack() != 0) {
			
			float attack1 = 0;
			
			if(attack.getOpAttack() == -1)
				opponent.attackMultiplier = 0.67f;
			else if(attack.getOpAttack() == -2)
				opponent.attackMultiplier = 0.5f;
			else if(attack.getOpAttack() == -3)
				opponent.attackMultiplier = 0.4f;
			else if(attack.getOpAttack() == -4)
				opponent.attackMultiplier = 0.33f;
			else if(attack.getOpAttack() == 4)
				opponent.attackMultiplier = 3;
			else if(attack.getOpAttack() == 3)
				opponent.attackMultiplier = 2.5f;
			else if(attack.getOpAttack() == 2)
				opponent.attackMultiplier = 2f;
			else if(attack.getOpAttack() == 1)
				opponent.attackMultiplier = 1.5f;
		
				opponent.setAttack(opponent.attackMultiplier * opponent.getAttack());
				opponent.attackChange = true;
				opponent.changeAttack += attack.getOpAttack();
				
		}
		if(attack.getOpDefense() != 0) {
			
			
			
			if(attack.getOpDefense() == -1)
				opponent.defenseMultiplier = 0.67f;
			else if(attack.getOpDefense() == -2)
				opponent.defenseMultiplier = 0.5f;
			else if(attack.getOpDefense() == -3)
				opponent.defenseMultiplier = 0.4f;
			else if(attack.getOpDefense() == -4)
				opponent.defenseMultiplier = 0.33f;
			else if(attack.getOpDefense() == 4)
				opponent.defenseMultiplier = 3;
			else if(attack.getOpDefense() == 3)
				opponent.defenseMultiplier = 2.5f;
			else if(attack.getOpDefense() == 2)
				opponent.defenseMultiplier = 2f;
			else if(attack.getOpDefense() == 1)
				opponent.defenseMultiplier = 1.5f;
		
			opponent.setDefense(opponent.defenseMultiplier * opponent.getDefense());
			opponent.defenseChange = true;
			opponent.changeDefense += attack.getOpDefense();
		}
			
			
		
		if(attack.getSelfDamage() > 0) {
			
			takeDamage( (defense * (1/10))  - attack.getSelfDamage() + (this.attack * (1/10)) );
		}
	
		
		
		if(attack.getSelfSpeed() != 0) {
			
			if(attack.getSelfSpeed() == -1)
				speedMultiplier = 0.67f;
			else if(attack.getSelfSpeed() == -2)
				speedMultiplier = 0.5f;
			else if(attack.getSelfSpeed() == -3)
				speedMultiplier = 0.4f;
			else if(attack.getSelfSpeed() == -4)
				speedMultiplier = 0.33f;
			else if(attack.getSelfSpeed() == 4)
				speedMultiplier = 3;
			else if(attack.getSelfSpeed() == 3)
				speedMultiplier = 2.5f;
			else if(attack.getSelfSpeed() == 2)
				speedMultiplier = 2f;
			else if(attack.getSelfSpeed() == 1)
				speedMultiplier = 1.5f;
			
			speed = speedMultiplier * speed;
			speedChange = true;
			changeSpeed += attack.getSelfSpeed();
			
		}
		if(attack.getSelfAttack() > 0) {
			
			
			if(attack.getSelfAttack() == -1)
				attackMultiplier = 0.67f;
			else if(attack.getSelfAttack() == -2)
				attackMultiplier = 0.5f;
			else if(attack.getSelfAttack() == -3)
				attackMultiplier = 0.4f;
			else if(attack.getSelfAttack() == -4)
				attackMultiplier = 0.33f;
			else if(attack.getSelfAttack() == 4)
				attackMultiplier = 3;
			else if(attack.getSelfAttack() == 3)
				attackMultiplier = 2.5f;
			else if(attack.getSelfAttack() == 2)
				attackMultiplier = 2f;
			else if(attack.getSelfAttack() == 1)
				attackMultiplier = 1.5f;
			
			this.attack = attackMultiplier * this.attack;
			attackChange = true;
			changeAttack += attack.getSelfAttack();
			
		}
		if(attack.getSelfDefense() > 0) {
			
			if(attack.getSelfDefense() == -1)
				defenseMultiplier = 0.67f;
			else if(attack.getSelfDefense() == -2)
				defenseMultiplier = 0.5f;
			else if(attack.getSelfDefense() == -3)
				defenseMultiplier = 0.4f;
			else if(attack.getSelfDefense() == -4)
				defenseMultiplier = 0.33f;
			else if(attack.getSelfDefense() == 4)
				defenseMultiplier = 3;
			else if(attack.getSelfDefense() == 3)
				defenseMultiplier = 2.5f;
			else if(attack.getSelfDefense() == 2)
				defenseMultiplier = 2f;
			else if(attack.getSelfDefense() == 1)
				defenseMultiplier = 1.5f;
			
			defense = defenseMultiplier * defense;
			defenseChange = true;
			changeDefense += attack.getSelfDefense();
		}
	
	}
	
	public void drawAttackChange(PApplet marker, float x, float y) {
		
		if(attackMultiplier > 1) {
			marker.fill(255);
		}
		else {
			marker.fill(255);
			
		}
		
		marker.rect(x, y, 70, 25);
		
		marker.fill(0,0,0);
		marker.textSize(13);
		//DecimalFormat df = new DecimalFormat("###.##");
		
		marker.text("atk", x + 5, y + 15);
		marker.text(changeAttack, x + 30, y + 15);
		
	}
	
	public void drawSpeedChange(PApplet marker, float x, float y) {
		
		if(speedMultiplier > 1) {
			marker.fill(255);
		}
		else {
			marker.fill(255);
			
		}
		
		marker.rect(x, y, 70, 25);
		
		marker.fill(0,0,0);
		marker.textSize(13);
	//	DecimalFormat df = new DecimalFormat("###.##");
		marker.text("spe", x + 5, y + 15);
		marker.text(changeSpeed, x + 30, y + 15);
	}//
	
	public void drawDefenseChange(PApplet marker, float x, float y) {
		
		if(defenseMultiplier > 1) {
			marker.fill(255);
		}
		else {
			marker.fill(255);
			
		}
		marker.rect(x, y, 70, 25);
		
		marker.fill(0,0,0);
		marker.textSize(13);
		//DecimalFormat df = new DecimalFormat("###.##");
		
		marker.text("def", x + 5, y + 15);
		marker.text(changeDefense, x + 30, y + 15);
	}
	public void draw(PApplet marker, float x, float y) {
		PImage image = marker.loadImage(filename);
		marker.image(image, x, y, 300, 300);
	}
	public boolean canCapture() {
		int n = (int) (health  + (int)(Math.random() * 10));
		
		return n < trueHp/2;
	}
	
public void drawStatPage(PApplet marker) {
		
		marker.textSize(20);
		draw(marker, 500, 250);
		marker.text("Attack : " + getTrueAttack() , 875, 250);
		marker.text("Defense : " + getTrueDefense() , 875, 300);
		marker.text("Speed : " + getTrueSpeed() , 875, 350);
		marker.text("Health : " + getHealth() , 875, 400);
		marker.text("Type : " + getType().getName() , 875, 450);
	}
	
}