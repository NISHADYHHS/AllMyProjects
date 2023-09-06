package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Parasect extends Pokemon {
	public Parasect() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new Fart(), new Smash(), new Mudfall(), new Scream())), 300, 83, 83,
			90, new Smelly(), "Parasect", 210, "Parasect.png", 0, 0, null, 10000);
	}
}
