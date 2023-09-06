package SN.Attack;
import SN.Type.*;
import processing.core.PApplet;;
public abstract class Attack {
	private float opDamage;
	private float opSpeed;
	private float opDefense;
	private float opAttack;
	private float selfDamage;
	private float selfSpeed;
	private float selfDefense;
	private float selfAttack;
	private Type type;
	private String name;
	
	
	public Attack(float opDamage, float opSpeed, float opDefense, float opAttack, String name, Type type, float selfDamage, float selfSpeed, float selfDefense, float selfAttack ) {
		this.opDamage = opDamage;
		this.opSpeed = opSpeed;
		this.opDefense = opDefense;
		this.opAttack = opAttack;
		this.type = type;
		
		
		this.selfDamage = selfDamage;
		this.selfSpeed = selfSpeed;
		this.selfDefense = selfDefense;
		this.selfAttack = selfAttack;
		
		this.name = name;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	
	
	public float getOpDamage() {
		return opDamage;
	}
	public float getOpSpeed() {
		return opSpeed;
	}
	public float getOpDefense() {
		return opDefense;
	}
	public float getOpAttack() {
		return opAttack;
	}
	
	
	
	public float getSelfDamage() {
		return selfDamage;
	}
	public float getSelfSpeed() {
		return selfSpeed;
	}
	public float getSelfDefense() {
		return selfDefense;
	}
	public float getSelfAttack() {
		return selfAttack;
	}
	
	
	
	public Type getType() {
		return type;
	}
	
	
	
}
