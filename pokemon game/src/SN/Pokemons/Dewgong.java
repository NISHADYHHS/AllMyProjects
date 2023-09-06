package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Dewgong extends Pokemon {

	public Dewgong() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new WaterBlast(), new Smash(), new Fart(), new Mudfall())), 300, 83, 84, 92, 
				new Water(), "Dewgong", 300, "Dewgong.png", 0, 0, null, 100000);
		// TODO Auto-generated constructor stub
	}

}
