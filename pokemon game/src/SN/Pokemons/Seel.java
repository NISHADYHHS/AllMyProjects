package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Seel extends Pokemon {

	public Seel() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new Scream(), new Smash(), new LightningBolt(), new WaterBlast())), 243, 66, 68, 73, 
		new Water(), "See", 243, "Seel.png", 0, 0, new Dewgong(), 2);
		// TODO Auto-generated constructor stub
	}
	
}
