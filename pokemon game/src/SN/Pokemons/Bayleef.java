package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Bayleef extends Pokemon {

	public Bayleef() {
		super(new ArrayList<Attack>(Arrays.asList(new Scream(), new Smash(), new SuperPunch(), new LightningBolt())), 250, 63, 60, 70, 
				new Plant(), "Bayleef", 250, "Bayleef.png", 0, 0, new Meganium(), 7);
		// TODO Auto-generated constructor stub
	}
}
