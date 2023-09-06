package SN.Player;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

import SN.Pokemons.*;
import SN.Pokemons.Charizard;
import SN.Pokemons.Charmander;
import SN.Pokemons.Charmelion;
import SN.Pokemons.Pokemon;
import processing.core.PApplet;

public class Player {

	private String f = "";
	// private boolean save
	private ArrayList<Pokemon> pokemons;

	public Player(ArrayList<Pokemon> slots) {
		pokemons = slots;

	}

	public Pokemon getP1() {

		return pokemons.get(0);
	}

	public Pokemon getP2() {

		return pokemons.get(1);
	}

	public Pokemon getP3() {

		return pokemons.get(2);
	}

	public Pokemon getP4() {

		return pokemons.get(3);
	}

	public Pokemon getP5() {

		return pokemons.get(4);
	}

	public Pokemon getP6() {

		return pokemons.get(5);
	}

	public void setP1(Pokemon p) {
		pokemons.set(0, p);
	}

	public void setP2(Pokemon p) {
//		pokemons.remove(1);
		pokemons.set(1, p);
	}

	public void setP3(Pokemon p) {
		// pokemons.remove(2);
		pokemons.set(2, p);
	}

	public void setP4(Pokemon p) {
		// pokemons.remove(3);
		pokemons.set(3, p);
	}

	public void setP5(Pokemon p) {
		// pokemons.remove(4);
		pokemons.set(4, p);
	}

	public void setP6(Pokemon p) {
		// pokemons.remove(5);
		pokemons.set(5, p);
	}

	public void drawSwitchScreen(PApplet marker, Player player) {

		if (player.getP1() != null) {
			player.getP1().setAttack(player.getP1().getTrueAttack());
			player.getP1().setSpeed(player.getP1().getTrueSpeed());
			player.getP1().setDefense(player.getP1().getTrueDefense());

			player.getP1().setAttackT(false);
			player.getP1().setDefenseT(false);
			player.getP1().setSpeedT(false);
		}
		if (player.getP1() != null) {

			marker.fill(player.getP1().getType().getColor1(), player.getP1().getType().getColor2(),
					player.getP1().getType().getColor3());
			marker.rect(200, 100, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP1().getName(), 300, 163);
		}
		if (player.getP2() != null) {

			marker.fill(player.getP2().getType().getColor1(), player.getP2().getType().getColor2(),
					player.getP2().getType().getColor3());
			marker.rect(200, 400, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP2().getName(), 300, 463);
		}

		if (player.getP3() != null) {

			marker.fill(player.getP3().getType().getColor1(), player.getP3().getType().getColor2(),
					player.getP3().getType().getColor3());
			marker.rect(200, 700, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP3().getName(), 300, 763);
		}

		if (player.getP4() != null) {

			marker.fill(player.getP4().getType().getColor1(), player.getP4().getType().getColor2(),
					player.getP4().getType().getColor3());
			marker.rect(1100, 100, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP4().getName(), 1200, 163);
		}

		if (player.getP5() != null) {

			marker.fill(player.getP5().getType().getColor1(), player.getP5().getType().getColor2(),
					player.getP5().getType().getColor3());
			marker.rect(1100, 400, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP5().getName(), 1200, 463);
		}

		if (player.getP6() != null) {

			marker.fill(player.getP6().getType().getColor1(), player.getP6().getType().getColor2(),
					player.getP6().getType().getColor3());
			marker.rect(1100, 700, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP6().getName(), 1200, 763);
		}

	}

	public void savedPokemon() {

		f = "";

		if (getP1() != null) {

			f += getP1().getName() + "";
			f += "\n";
			f += getP1().getAttack() + "";
			f += "\n";
			f += getP1().getSpeed() + "";
			f += "\n";
			f += getP1().getDefense() + "";
			f += "\n";
			f += getP1().getLevel() + "";
			f += "\n";
		}
		if (getP2() != null) {

			f += getP2().getName() + "";
			f += "\n";
			f += getP2().getAttack() + "";
			f += "\n";
			f += getP2().getSpeed() + "";
			f += "\n";
			f += getP2().getDefense() + "";
			f += "\n";
			f += getP1().getLevel() + "";
			f += "\n";
		}
		if (getP3() != null) {

			f += getP3().getName() + "";
			f += "\n";
			f += getP3().getAttack() + "";
			f += "\n";
			f += getP3().getSpeed() + "";
			f += "\n";
			f += getP3().getDefense() + "";
			f += "\n";
			f += getP1().getLevel() + "";
			f += "\n";
		}
		if (getP4() != null) {

			f += getP4().getName() + "";
			f += "\n";
			f += getP4().getAttack() + "";
			f += "\n";
			f += getP4().getSpeed() + "";
			f += "\n";
			f += getP4().getDefense() + "";
			f += "\n";
			f += getP1().getLevel() + "";
			f += "\n";
		}
		if (getP5() != null) {

			f += getP5().getName() + "";
			f += "\n";
			f += getP5().getAttack() + "";
			f += "\n";
			f += getP5().getSpeed() + "";
			f += "\n";
			f += getP5().getDefense() + "";
			f += "\n";
			f += getP1().getLevel() + "";
			f += "\n";
		}
		if (getP6() != null) {

			f += getP6().getName() + "";
			f += "\n";
			f += getP6().getAttack() + "";
			f += "\n";
			f += getP6().getSpeed() + "";
			f += "\n";
			f += getP6().getDefense() + "";
			f += "\n";
			f += getP1().getLevel() + "";
			f += "\n";
		}

		FileWriter writer = null;

		try {
			writer = new FileWriter("SavedPokemon");

			writer.write(f);
			writer.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String getF() {

		return f;
	}

	public String readData() {

		File dataFile = new File("SavedPokemon");
		String returner = "";
		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();

					returner += line;
					returner += "\n";
					// count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + "" + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + "" + " does not exist.");
		}
		return returner;
	}

	public void readPokemon() {

		// System.out.println();
		String[] words = readData().split("\n");
		int count = 0;
		for (int x = 0; x < words.length; x++) {

			if (words[x].equals("Charmander")) {

				Pokemon p = new Charmander();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;
				x = x + 4;
				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

			} else if (words[x].equals("Blastoise")) {

				Pokemon p = new Blastoise();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Bayleef")) {

				Pokemon p = new Bayleef();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Chamelion")) {

				Pokemon p = new Charmelion();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Charizard")) {

				Pokemon p = new Charizard();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Chikorita")) {

				Pokemon p = new Chikorita();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Clefable")) {

				Pokemon p = new Clefable();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Clefairy")) {

				Pokemon p = new Clefairy();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Cleffa")) {

				Pokemon p = new Cleffa();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Dewgong")) {

				Pokemon p = new Dewgong();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Dragonaire")) {

				Pokemon p = new Dragonaire();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Dragonite")) {

				Pokemon p = new Dragonite();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Dratini")) {

				Pokemon p = new Dratini();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Geodude")) {

				Pokemon p = new Geodude();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Golem")) {

				Pokemon p = new Golem();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Graveler")) {

				Pokemon p = new Graveler();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Ivysaur")) {

				Pokemon p = new Ivysaur();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Meganium")) {

				Pokemon p = new Meganium();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Paras")) {

				Pokemon p = new Paras();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Parasect")) {

				Pokemon p = new Parasect();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Pidgeot")) {

				Pokemon p = new Pidgeot();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Pidgeotto")) {

				Pokemon p = new Pidgeotto();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Pidgey")) {

				Pokemon p = new Pidgey();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Ponyta")) {

				Pokemon p = new Ponyta();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Rapidash")) {

				Pokemon p = new Rapidash();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Seel")) {

				Pokemon p = new Seel();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Squirtle")) {

				Pokemon p = new Squirtle();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Venusaur")) {

				Pokemon p = new Venusaur();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			} else if (words[x].equals("Wartortle")) {

				Pokemon p = new Wartortle();
				p.setTrueAttack((float) Double.parseDouble(words[x + 1]));
				p.setTrueSpeed((float) Double.parseDouble(words[x + 2]));
				p.setTrueDefense((float) Double.parseDouble(words[x + 3]));
				p.setLevel((int) Double.parseDouble(words[x + 4]));
				count++;

				if (count == 1)
					setP1(p);
				else if (count == 2)
					setP2(p);
				else if (count == 3)
					setP3(p);
				else if (count == 4)
					setP4(p);
				else if (count == 5)
					setP5(p);
				else if (count == 6)
					setP6(p);

				x = x + 4;
			}

		}

	}

}