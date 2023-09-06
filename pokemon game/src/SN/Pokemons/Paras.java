package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Paras extends Pokemon {
	public Paras() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new Fart(), new Smash(), new Mudfall(), new Scream())), 250, 59, 61,
			64, new Smelly(), "Paras", 250, "Paras.png", 0, 0, new Parasect(), 2);
	}
}
