AP Computer Science Final Project - README Template


Instructions:
The first step in creating an excellent APCS final project is to write up a README. At this stage, this README file acts as your project proposal. Once you’ve filled in all components, Shelby will read through it and suggest edits. Ultimately, you need a document that adequately describes your project idea and we must agree on this plan.


Have one member of your group make a copy of this Google Doc. Then, they should share it with all other members so that every group member has edit permissions.


There’s a lot of parts of this document that you might not have full answers for yet. Because you haven’t written the program yet, it’s difficult to think about the instructions or which group members will do which parts. Even though this is hard to think about, you must have something in these sections that acts as your current plan. However, during the course of the project, you’ll continuously update this document. This means that you will not be held to exactly what you put here - components of this document can change (and it’s pretty common!).


There is one exception: the Features List section. Once Shelby OKs your README, the Features List section cannot be modified. For this reason, it is most important that you get a solid idea of what you want to make and the primary features it will have now.


Talk with your group. Consider drawing some pictures of what you think your project might look like. Be precise. When you’re ready, fill this out together. Each component in brackets below ( [these things] ) should be replaced with your ideas. Note that there are several sample READMEs posted on this assignment for you to use as guidance.


-------------------When README is finalized, remove everything above this line--------------------


[Project Title]
Authors: Nishad Yedunuthula, Shaashwath Sivakumar
Revision: 4/19/2020
Introduction: 
[In a few paragraphs totalling about ½ page, introduce the high-level concept of your program. What this looks like depends a lot on what type of thing you are making. An introduction for an application will look different than one for a game. In general, your introduction should address questions like these:
This program will be based off of pokemon(It won’t be called pokemon, we just haven't found a replacement name yet). It’s a game where the player walks around a map and tries to capture pokemon. Pokemon are creatures that have moves, abilities, and types. They all have stats such as speed, defense, attack. The player walks around and if he encounters a pokemon, then they enter a pokemon battle. This is a turn based battle where the pokemon they encounter and their own pokemon start to fight, each turn is composed by one move used by each pokemon, the pokemon with the highest speed stat goes first. Pokemon are encountered in special tiles.


Instructions:
The left,right,up,down keys will move the player throughout the grid. If he steps on a square, he will encounter a pokemon. 
Then a screen will pop up showing what pokemon he encountered and all their specific stats. If the player wants to fight, he clicks battle,
if not he clicks run and will run away. If they battle, they will encounter a screen where they then are shown a list of their moves and
they will click which moves they want to use until they defeat, or are defeated, or decide to capture the pokemon. The switch button in 
this screen means that they can switch pokemon.






Features List (THE ONLY SECTION THAT CANNOT CHANGE LATER):
Must-have Features:
[These are features that we agree you will definitely have by the project due date. A good final project would have all of these completed. At least 5 are required. Each feature should be fully described (at least a few full sentences for each)]
*  Pokemon with unique names and typings and all the stats required for one. The pokemon will have a total of 4 moves, 1 type at least, evolutions, and statistics.
*  A grid that allows the player to move around, the grid will have normal tiles such as grass, path, then there will be rocks or walls, parts where the player cannot move past. Then there will be tall grass, the tall grass where pokemon can be encountered. Thenthe map will center the player.
*  Special places on the grid where pokemon can be encountered, the tall grass will have a percent chance to encounter a pokemon. Battles | Essentials Docs Wiki | Fandom 
*  The ability to fight and capture pokemon, make the battle screens and turns. When a pokemon is encountered, they are sent a battle screen like this : Then have the ability to capture wild pokemon












   *  Having working graphics, the different tiles will have a different images on them


Want-to-have Features:
[These are features that you would like to have by the project due date, but you’re unsure whether you’ll hit all of them. A good final project would have perhaps half of these completed. At least 5 are required. Again, fully describe each.]
   *  Multiple maps where the player can go through, since instead of creating 1 massive map, have several smaller ones which are accessed by going to the end of another one
   *  Healing centers, where your pokemon are healed after all the damage they take
   *  30+ pokemon
   *  30+ attacks
   *  Npc players to battle with, will be random squares on the maps where when encounter, will send to a pokemon battle with multiple pokemon in line


Stretch Features:
[These are features that we agree a fully complete version of this program would have, but that you probably will not have time to implement. A good final project does not necessarily need to have any of these completed at all. At least 3 are required. Again, fully describe each.]
   *  Dual types, each pokemon can have 1 type where it is super effective/resistance towards other types, so dual types will expand
   *  Save feature, to save the pokemon you have and their evolution
   *  50+ pokemon and 50+ attacks




Class List:
[This section lists the Java classes that make up the program and very briefly describes what each represents. It’s totally fine to put this section in list format and not to use full sentences.]


Attacks
-Different types of attacks : smash, lightning bolt
Types
-Different types of types: lightning, fire
Pokemon
-Different types of pokemon: drakoflame, waterfliyer: some random names
Battle
PokemonGrid
DrawingSurface
Main
Player
NPC












Credits:
[Gives credit for project components. This includes both internal credit (your group members) and external credit (other people, websites, libraries). To do this:
   * List the group members and describe how each member contributed to the completion of the final program. This could be classes written, art assets created, leadership/organizational skills exercises, or other tasks. Initially, this is how you plan on splitting the work.
   * Give credit to all outside resources used. This includes downloaded images or sounds, external java libraries, parent/tutor/student coding help, etc.]
   
   Shaashwath : 
Everything in type
30 pokemon subclasses
Created all new Pokemon images
Created the NButton
Created the capturing system
Created the instruction screen with the start game button
Made most of attack

Nishad:
Made the maps
Made the grid format
Made all scenes within the game
Made the save feature
Made most of the pokemon superclass
Did everything in DrawingSurface except for capturing