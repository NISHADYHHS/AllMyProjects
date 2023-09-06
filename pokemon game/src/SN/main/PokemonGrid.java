package SN.main;

import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import SN.Pokemons.*;
import SN.Pokemons.Charizard;
import SN.Pokemons.Charmander;
import SN.Pokemons.Charmelion;
import SN.Pokemons.Pokemon;
import processing.core.PApplet;
import processing.core.*;

import java.io.FileWriter;

public class PokemonGrid extends PApplet {
	private String filename;
	private char[][] grid;
	private char[][] stats;
	private int y;
	private int x;
	private int savedcoordsX;
	private int savedcoordsY;
	private boolean moved = false;
	private boolean encounter = false;
	private boolean encountered = false;
	private String pokemonName;
	private int squares = 100;
	private PImage imgGrass;
	private PImage imgtallGrass;
	private PImage imgPath;
	private PImage imgRocks;
	private PImage imgredCross;
	private PImage imgpersontallGrass;
	private PImage imgpersonPath;
	private PImage imgpersonGrass;
	private PImage imgpersonStat;
	private boolean tpToRoute2 = false;;
	private char currentTile;
	private boolean pointcaptured = false;
	private ArrayList<Character> chars = new ArrayList<Character>();
	private boolean tpToRoute1 = false;
	private boolean tpToHealingCenter;
	private String allchars;
	private char previous;

	public PokemonGrid(String filename, PImage grass, PImage tallGrass, PImage path, PImage rocks, PImage redcross,
			PImage personGrass, PImage personPath, PImage personTallGrass, PImage personStationary, int squares) {
		this.filename = filename;
		imgGrass = grass;
		imgRocks = rocks;
		imgtallGrass = tallGrass;
		imgPath = path;
		imgredCross = redcross;
		imgpersontallGrass = personTallGrass;
		imgpersonPath = personPath;
		imgpersonGrass = personGrass;
		imgpersonStat = personStationary;
		grid = new char[squares][squares];
		stats = new char[100][100];
		readStats("SavedStats", stats);
		readData(filename, grid);
		String d = "";
		String v = "";

		for (int j = 0; j < stats.length; j++) {
			if (stats[j][0] <= 57 && stats[j][0] >= 48 || stats[j][0] == 45)
				d += stats[j][0];
		}
		for (int j = 0; j < stats.length; j++) {
			if (stats[j][1] <= 57 && stats[j][1] >= 48 || stats[j][1] == 45)
				v += stats[j][1];
		}

		savedcoordsX = Integer.parseInt(d);
		savedcoordsY = Integer.parseInt(v);

	}

	public String getMap() {
		return filename;

	}

	public char getMapChar() {
		// .println((grid[0].length) - 1 + " " + (grid.length - 1));
		allchars = allchars.trim();
		return allchars.charAt(allchars.length() - 1);
	}

	public boolean switchMap2() {

		return tpToRoute2;

	}

	public char getTile() {

		return currentTile;

	}

	public boolean switchMapHealingCenter() {

		return tpToHealingCenter;

	}

	public boolean switchMap1() {

		return tpToRoute1;

	}

	public int getX() { // returns x

		return x;
	}

	public int getY() { // returns y

		return y;
	}

	public boolean isValid(int x, int y) {
		if (x >= 0 && x < grid[y].length && y >= 0 && y < grid.length) {
			return true;
		}
		return false;
	}

	public boolean canMove(int x, int y) {
		if (isValid(x, y)) {
			if (grid[x][y] == '*') {

				return true;
			} else if (grid[x][y] == '8') {

				return true;
			} else if (grid[x][y] == '-') {

				return false;
			} else if (grid[x][y] == '0') {

				return true;
			} else if (grid[x][y] == 'F') {

				return true;
			} else if (grid[x][y] == '2') {
				tpToRoute2 = true;
				tpToRoute1 = false;
				tpToHealingCenter = false;
				return true;
			} else if (grid[x][y] == '5') {

				tpToRoute1 = true;
				tpToRoute2 = false;
				tpToHealingCenter = false;
				return true;
			} else if (grid[x][y] == 'H') {
				tpToRoute1 = true;
				tpToRoute2 = false;
				tpToHealingCenter = true;
				return true;
			} else {

				return false;
			}
		}
		return false;
	}

	public int squareCount() {

		return squares;
	}

	public boolean getStatus() { // retutrns whether in battle

		return encountered;
	}

	public String getPokemonName() {// returns the pokemonName

		return pokemonName;
	}

	public void drawthing(int x, int y) {

		// prev = grid[x][y];
		pointcaptured = true;

	}

	public void movething(int dirx, int diry) { // moves the square with parameters of dir x and dir y, can be 1,-1,0

		if (grid[x + dirx][y + diry] == '8') { // if the coords are in the red area encounter = true

			encounter = true;

		} else {

			encounter = false;
		}
		moved = false;

		// if(grid[x][y] == )
		char prev = grid[x + dirx][y + diry];
		// char prev = grid[]
		previous = prev;
		// .println(prev);
		// grid[x][y] = grid[x + dirx][y + diry];
		grid[x + dirx][y + diry] = 'X';

		this.x = x + dirx; // x = the x that is true
		this.y = y + diry; // y = the y that is true

		chars.add(prev);
		if (chars.size() > 1) {
			grid[x - dirx][y - diry] = chars.get(chars.size() - 2);
			currentTile = chars.get(chars.size() - 2);
		} else {
			grid[x - dirx][y - diry] = prev;
			currentTile = prev;
		}

		// adds dirx and diry to the current coords and makes it true

	}

	public Pokemon encounter() {// if encounter == true, then make a random number

		if (encounter == true) {
			int r = (int) (Math.random() * 530) + 1; // number 0 - 14
			if (r == 1) { // if 1, u find a charizard, encountered is true;

				encountered = true;

				return new Charizard();

			} else if (r == 2 || r == 3) {// if 1, u find a blastoise, encountered is true;

				encountered = true;
				return new Charmelion();
			} else if (r == 4 || r == 5 || r == 6) {// if 1, u find a serperior, encountered is true;

				encountered = true;
				return new Charmander();
			} else if (r == 7) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Blastoise();
			} else if (r == 8 || r == 9) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Wartortle();
			} else if (r == 10 || r == 11 || r == 12) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Squirtle();
			} else if (r == 13) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Venusaur();
			} else if (r == 14 || r == 15) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Ivysaur();
			} else if (r == 16 || r == 17 || r == 18) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Bulbasaur();
			} else if (r == 19 || r == 20) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Meganium();
			} else if (r == 21 || r == 22 || r == 23) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Bayleef();
			} else if (r == 24 || r == 25 || r == 26 || r == 27) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Chikorita();
			} else if (r == 24 || r == 25 || r == 26 || r == 27) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Clefairy();
			} else if (r == 28 || r == 29 || r == 30 || r == 31 || r == 32) {// if 1, u find a venosaur, encountered is
																				// true;

				encountered = true;
				return new Clefable();
			} else if (r == 33 || r == 34 || r == 35 || r == 36 || r == 37 || r == 38) {// if 1, u find a venosaur,
																						// encountered is true;

				encountered = true;
				return new Cleffa();
			} else if (r == 39 || r == 40 || r == 41 || r == 42 || r == 43 || r == 44 || r == 45) {// if 1, u find a
																									// venosaur,
																									// encountered is
																									// true;

				encountered = true;
				return new Seel();
			} else if (r == 46 || r == 47 || r == 48 || r == 49 || r == 50) {// if 1, u find a venosaur, encountered is
																				// true;

				encountered = true;
				return new Dewgong();
			} else if (r == 51 || r == 52 || r == 53 || r == 54 || r == 55 || r == 56 || r == 57) {// if 1, u find a
																									// venosaur,
																									// encountered is
																									// true;

				encountered = true;
				return new Geodude();
			} else if (r == 58 || r == 59 || r == 60 || r == 61 || r == 62) {// if 1, u find a venosaur, encountered is
																				// true;

				encountered = true;
				return new Graveler();
			} else if (r == 63 || r == 64 || r == 65) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Golem();
			} else if (r == 66 || r == 67 || r == 68 || r == 69 || r == 70 || r == 71 || r == 72) {// if 1, u find a
																									// venosaur,
																									// encountered is
																									// true;

				encountered = true;
				return new Paras();
			} else if (r == 72 || r == 73 || r == 74 || r == 75) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Parasect();
			} else if (r == 76 || r == 77 || r == 78 || r == 79 || r == 80 || r == 81 || r == 82) {// if 1, u find a
																									// venosaur,
																									// encountered is
																									// true;

				encountered = true;
				return new Pidgey();
			} else if (r == 82 || r == 83 || r == 84 || r == 85 || r == 86 || r == 87) {// if 1, u find a venosaur,
																						// encountered is true;

				encountered = true;
				return new Pidgeotto();
			} else if (r == 88 || r == 89 || r == 90) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Pidgeot();
			} else if (r == 91 || r == 92 || r == 93 || r == 94) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Ponyta();
			} else if (r == 95 || r == 96 || r == 97) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Rapidash();
			} else if (r == 98 || r == 99 || r == 100 || r == 101) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Dratini();
			} else if (r == 102 || r == 103 || r == 104) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Dragonaire();
			} else if (r == 105 || r == 106) {// if 1, u find a venosaur, encountered is true;

				encountered = true;
				return new Dragonite();
			}

			else { // if you did not get 1,2,3,0 thenm encountered = false
					// .println("u found nothing");
				encountered = false;
				return null;
			}

		} else {

			// .println("not on grass");
			return null;
		}
	}

	public void drawBattleScreen(PApplet marker, String pokemon) { // the screen when you encounter a pokemon, only when
																	// encounter is true

		marker.textSize(40);
		marker.text("YOU", 200, 500);
		marker.text(pokemon, 500, 100);
		marker.stroke(0);
		marker.fill(0, 255, 30);
		marker.rect(500, 700, 100, 50);
	}

	public void drawHoriz(PApplet marker, float x, float y) {

		for (int f = 0; f < squares; f++) {

		}
	}

	public void draw(PApplet marker, float x, float y, float width, float height) { // draws boxes

		float placeholdery = y;
		int count = 0;

		for (int i = 0; i < grid.length; i++) {
			count = 0;

			// marker.fill(255,255,255); // fills white
			for (int j = 0; j < grid[0].length; j++) {

				// create a box of 40,40
				count = 1;
				y += 40 + count; // y is increased by 40

				if (grid[i][j] == '*') { // if a point on the grid == true, the box becomes blue
					marker.stroke(3, 130, 140);
					marker.fill(3, 130, 140);
					marker.image(imgGrass, x, y);
					// marker.rect(x, y, 40, 40);
					encounter = false;

				} else if (grid[i][j] == '-') {
					// nonmove = true;
					marker.stroke(0, 0, 0);
					marker.fill(0);
					marker.image(imgRocks, x, y);
					encounter = false;
				}

				else if (grid[i][j] == '8') {
					marker.stroke(0, 100, 0);
					marker.fill(0, 100, 0);
					marker.image(imgtallGrass, x, y);
					encounter = true;
				} else if (grid[i][j] == '0') {
					marker.stroke(0, 100, 0);
					marker.fill(0, 100, 0);
					marker.image(imgPath, x, y);
					encounter = false;
				} else if (grid[i][j] == '2') {
					marker.stroke(0, 100, 0);
					marker.fill(255, 0, 0);
					marker.rect(x, y, 40, 40);
					encounter = false;
				} else if (grid[i][j] == 'H') {
					marker.stroke(255, 255, 255);
					// marker.fill(150,0,255);
					// marker.rect(x,y,40,40);
					marker.image(imgredCross, x, y);
					encounter = false;
				} else if (grid[i][j] == 'F') {
					marker.stroke(255, 255, 255);
					marker.fill(150, 0, 255);
					marker.rect(x, y, 40, 40);
					// marker.image(imgredCross,x,y);
					encounter = false;
				} else if (grid[i][j] == 'X') {
					marker.image(imgpersonStat, x, y);
					this.x = i;
					this.y = j;
					if (pointcaptured == true) {

						if (previous == '0')
							marker.image(imgpersonPath, x, y);
						else if (previous == '*')
							marker.image(imgpersonGrass, x, y);
						else if (previous == '8')
							marker.image(imgpersontallGrass, x, y);
						// marker.image(imgPerson, x, y);
					} else {

						marker.image(imgpersonStat, x, y);
					}

					encounter = false;

				} else {
					// nonmove = true;
					marker.rect(x, y, 40, 40);
					marker.fill(0, 0, 255);

				}

				// marker.fill(255);
				if (j == grid.length - 1) {
					x += 40 + count; // making the grid
					y = placeholdery;

				}
			}
		}
	}

	public void savedMap(int countx, int county) throws IOException {
		String f = "";
		for (int j = 0; j < grid.length; j++) {
			for (int i = 0; i < grid[0].length; i++) {

				f = f + grid[i][j];
				// .print(grid[i][j]);

			}
			f = f + "\n";
		}

		FileWriter writer = null;
		FileWriter writer2 = null;
		try {
			writer = new FileWriter("SavedMap");

			writer.write(f);
			writer.close();

			writer2 = new FileWriter("SavedStats");
			String c = countx + "\n" + county + "\n" + filename;
			writer2.write(c);
			writer2.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void readStats(String filename, char[][] gameData) {

		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (i < gameData.length && count < gameData[i].length)
							gameData[i][count] = line.charAt(i);

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}

	}

	public int returnX() {

		return savedcoordsX;
	}

	public int returnY() {

		return savedcoordsY;
	}

	public void readData(String filename, char[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for (int i = 0; i < line.length(); i++)
						if (i < gameData.length && count < gameData[i].length) {
							gameData[i][count] = line.charAt(i);
							allchars += line.charAt(i);
						}

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

}