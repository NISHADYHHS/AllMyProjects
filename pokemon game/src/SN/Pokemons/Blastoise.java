package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.Attack;
import SN.Attack.LightningBolt;
import SN.Attack.Mudfall;
import SN.Attack.Scream;
import SN.Attack.Smash;
import SN.Attack.WaterBlast;
import SN.Type.Electricity;
import SN.Type.Water;

public class Blastoise extends Pokemon {

	
	
	public Blastoise() {
		super(new ArrayList<Attack>(Arrays.asList(new Smash(), new Scream(), new Mudfall(), new WaterBlast())), 300, 140, 150, 80, new Water(), "Blastoise",300, "Blastoise.png",0,0, null, 100000000);
		// TODO Auto-generated constructor stub
	}
}
