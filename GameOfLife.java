///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            (GameOfLife.java)
// Files:            (list of source files)
// Semester:         (Introduction to Computer Programming) Fall 2015
//
// Author:           (Nhialee Yang)
// Email:            (nyang5@wisc.edu)
// CS Login:         (nhialee)
// Lecturer's Name:  (Deb Deppeler)
// Lab Section:      (302)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ////////////////////
//
//                   CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                   If pair programming is allowed:
//                   1. Read PAIR-PROGRAMMING policy (in cs302 policy) 
//                   2. choose a partner wisely
//                   3. REGISTER THE TEAM BEFORE YOU WORK TOGETHER 
//                      a. one partner creates the team
//                      b. the other partner must join the team
//                   4. complete this section for each program file.
//
// Pair Partner:     (name of your pair programming partner)
// Email:            (email address of your programming partner)
// CS Login:         (partner's login name)
// Lecturer's Name:  (name of your partner's lecturer)
// Lab Section:      (your partner's lab section number)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but tutors, roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of 
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Scanner;

/**GameOfLife is an application based on John Conway's Game of life. It
 * asks the user to select from one of five pattern configurations,
 * from a menu, to display. Afterwards, the user will be asked to press "enter" 
 * on his or her keyboard to view the next generation of that configuration or 
 * type "end" to exit the simulation and return to the main menu. The next 
 * generation is determined based on the implementation of the rules in John
 * Conway's Game of life. This will loop until the user chooses to terminate 
 * the program.
 * 
 * Bugs: none known
 * 
 * @author	Nhialee Yang
 */

public class GameOfLife {

	// DO NOT ADD STATIC FIELDS TO THIS CLASS
	// YOU MUST SOLVE ALL PARTS BY PASSING THE 
	// THE VALUES YOU NEED TO AND FROM METHODS.
	// WE WILL TEST ALL METHODS INDEPENDENT OF 
	// OTHER METHODS.  
	//
	// THAT CAN ONLY WORK IF YOU DEFINE EACH 
	// METHOD AS DESCRIBED.  YOU MAY NOT IMPLEMENT
	// YOUR OWN DESIGN EXCEPT TO ADD PRIVATE
	// HELPER METHODS AS YOU LIKE.  YOU MUST
	// STILL IMPLEMENT ALL PUBLIC METHODS
	// OF THIS CLASS.

	/**
	 * Program execution starts here.
	 * @param args UNUSED
	 */    
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		//declare local variables
		boolean[][] world;
		boolean[][] newWorld;
		boolean[][] tempWorld;

		//handles Scanner inputs
		String option;
		String select1;


		// Display Welcome message
		System.out.println("Welcome to the Game of Life");

		//menu choices
		do {

			System.out.println("Select a pattern of life for the world");
			System.out.println("1 - Glider");
			System.out.println("2 - Beacon");
			System.out.println("3 - Boat");
			System.out.println("4 - R-pentomino");
	   		System.out.println("5 - Random");
			System.out.println("9 - Exit");
			System.out.print("Choice: ");
			option = input.nextLine();

			if(option.contains("1")){

				world = createNewWorld(Config.WORLD_ROWS, Config.WORLD_COLUMNS);
				initializeGlider(world);
				printWorld("Glider", world, 0);

				int generation = 1;

				//sub-menu
				do {
					System.out.println("\nOptions");
					System.out.println("(Enter): show next generation");
					System.out.println("end(Enter): end this simulation");
					System.out.print("Choice: ");
					select1 = input.nextLine();


					if (select1.equals("")) {
						
						//the new world is determined
						newWorld = createNewWorld(Config.WORLD_ROWS, 
								Config.WORLD_COLUMNS);
						nextGeneration(world,newWorld);
						printWorld("Glider",newWorld,generation);

						//we no longer need current world
						clearWorld(world);

						//references are re-assigned
						tempWorld = world;
						world = newWorld;
						newWorld = tempWorld;

						generation++;
					}
					else if (!select1.contains("end")) {

						System.out.println("Invalid input");
					}

				}while(!select1.contains("end"));

			}
			else if(option.contains("2")){

				world = createNewWorld(Config.WORLD_ROWS, Config.WORLD_COLUMNS);
				initializeBeacon(world);
				printWorld("Beacon", world, 0);

				int generation = 1;

				do {
					System.out.println("\nOptions");
					System.out.println("(Enter): show next generation");
					System.out.println("end(Enter): end this simulation");
					System.out.print("Choice: ");
					select1 = input.nextLine();

					if (select1.equals("")) {
						
						//the new world is determined
						newWorld = createNewWorld(Config.WORLD_ROWS, 
								Config.WORLD_COLUMNS);
						nextGeneration(world,newWorld);
						printWorld("Beacon",newWorld,generation);

						//we no longer need the current world
						clearWorld(world);

						//references are re-assigned
						tempWorld = world;
						world = newWorld;
						newWorld = tempWorld;

						generation++;
					}
					else if (!select1.contains("end")) {

						System.out.println("Invalid input");
					}

				}while(!select1.contains("end"));

			}
			else if(option.contains("3")){

				world = createNewWorld(Config.WORLD_ROWS, Config.WORLD_COLUMNS);
				initializeBoat(world);
				printWorld("Boat", world, 0);

				int generation = 1;

				do {
					System.out.println("\nOptions");
					System.out.println("(Enter): show next generation");
					System.out.println("end(Enter): end this simulation");
					System.out.print("Choice: ");
					select1 = input.nextLine();

					if (select1.equals("")) {
						
						//the new world is determined
						newWorld = createNewWorld(Config.WORLD_ROWS, 
								Config.WORLD_COLUMNS);
						nextGeneration(world,newWorld);
						printWorld("Boat",newWorld,generation);

						//we no longer need the current world
						clearWorld(world);
						
						//references are re-assigned
						tempWorld = world;
						world = newWorld;
						newWorld = tempWorld;

						generation++;
					}
					else if (!select1.contains("end")) {

						System.out.println("Invalid input");
					}

				}while(!select1.contains("end"));

			}
			else if(option.contains("4")){

				world = createNewWorld(Config.WORLD_ROWS, Config.WORLD_COLUMNS);
				initializeRpentomino(world);
				printWorld("R-pentomino", world, 0);

				int generation = 1;

				do {
					System.out.println("\nOptions");
					System.out.println("(Enter): show next generation");
					System.out.println("end(Enter): end this simulation");
					System.out.print("Choice: ");
					select1 = input.nextLine();

					//the new world is determined
					if (select1.equals("")) {
						newWorld = createNewWorld(Config.WORLD_ROWS, 
								Config.WORLD_COLUMNS);
						nextGeneration(world,newWorld);
						printWorld("R-pentomino",newWorld,generation);

						//we no longer need the current world
						clearWorld(world);

						//references are re-assigned
						tempWorld = world;
						world = newWorld;
						newWorld = tempWorld;

						generation++;
					}
					else if (!select1.contains("end")) {

						System.out.println("Invalid input");
					}

				}while(!select1.contains("end"));

			}
			else if(option.contains("5")){

				world = createNewWorld(Config.WORLD_ROWS, Config.WORLD_COLUMNS);
				initializeRandomWorld(world);
				printWorld("Random", world, 0);

				int generation = 1;

				do {
					System.out.println("\nOptions");
					System.out.println("(Enter): show next generation");
					System.out.println("end(Enter): end this simulation");
					System.out.print("Choice: ");
					select1 = input.nextLine();

					if (select1.equals("")) {
						
						//the new world is determined
						newWorld = createNewWorld(Config.WORLD_ROWS, 
								Config.WORLD_COLUMNS);
						nextGeneration(world,newWorld);
						printWorld("Random",newWorld,generation);

						//we no longer need the current world
						clearWorld(world);

						//references are re-assigned
						tempWorld = world;
						world = newWorld;
						newWorld = tempWorld;

						generation++;
					}
					else if (!select1.contains("end")) {

						System.out.println("Invalid input");
					}

				}while(!select1.contains("end"));

			}
			else if (!option.contains("9")) {

				System.out.println("Invalid input");
			}

		} while (!option.contains("9"));

		System.out.println("End of Game of Life.");

		input.close();
	}

	/**
	 * Create a new world
	 * @param numRows The number of rows to be in the created world
	 * @param numColumns  The number of columns to be in the created world
	 * @return A double dimension array of boolean that is numRows by 
	 * numColumns in size and initialized to all false values. 
	 */
	public static boolean[][] createNewWorld(int numRows, int numColumns) {

		boolean[][] world = new boolean[numRows][numColumns];

		return world;
	}

	/**
	 * Sets all the cells in the world to not alive (false).
	 * @param world 
	 */
	public static void clearWorld( boolean[][]world) {

		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				world[i][j] = false;
			}
		}		
	}	

	/**
	 * Initializes the world to the Glider pattern.
	 * <pre>
	 * ..........
	 * .@........
	 * ..@@......
	 * .@@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre>
	 * @param world  the existing double dimension array that will be 
	 * reinitialized to the Glider pattern. 
	 */
	public static void initializeGlider(boolean[][]world) {

		world[1][1] = true;
		world[2][2] = true;
		world[2][3] = true;
		world[3][1] = true;
		world[3][2] = true;
	}

	/**
	 * Initializes the world to the Beacon pattern.
	 * <pre>
	 * ..........
	 * .@@.......
	 * .@........
	 * ....@.....
	 * ...@@.....
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the Beacon pattern.
	 */		
	public static void initializeBeacon(boolean[][] world) {

		world[1][1] = true;
		world[1][2] = true;
		world[2][1] = true;
		world[3][4] = true;
		world[4][3] = true;
		world[4][4] = true;
	}

	/**
	 * Initializes the world to the Boat pattern.
	 * <pre>
	 * ..........
	 * .@@.......
	 * .@.@......
	 * ..@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the Boat pattern.
	 */		
	public static void initializeBoat(boolean[][] world) {

		world[1][1] = true;
		world[1][2] = true;
		world[2][1] = true;
		world[2][3] = true;
		world[3][2] = true;

	}	
	/**
	 * Initializes the world to the R-pentomino pattern.
	 * <pre>
	 * ..........
	 * ..@@......
	 * .@@.......
	 * ..@.......
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * ..........
	 * </pre> 
	 * @param world the existing double dimension array that will be 
	 * reinitialized to the R-pentomino pattern.
	 */		
	public static void initializeRpentomino(boolean[][] world) {

		world[1][2] = true;
		world[1][3] = true;
		world[2][1] = true;
		world[2][2] = true;
		world[3][2] = true;

	}	
	/**
	 * Initialize the GameOfLife world with a random selection of cells alive. 
	 * 
	 * @param world  the existing double dimension array that will be 
	 * reinitialized to a Random pattern.
	 */	
	public static void initializeRandomWorld(boolean[][] world){

		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				if (Config.RNG.nextDouble() < Config.CHANCE_ALIVE) {
					world[i][j] = true;
				}        	
			}
		}
	}

	/** 
	 * Whether a cell is living in the next generation of the game.
	 * 
	 * The rules of the game are as follows:
	 * 1) Any live cell with fewer than two live neighbors dies, as if caused
	 *    by under-population.
	 * 2) Any live cell with two or three live neighbors lives on to the next 
	 *    generation.
	 * 3) Any live cell with more than three live neighbors dies, as if by 
	 *    overcrowding.
	 * 4) Any dead cell with exactly three live neighbors becomes a live cell, 
	 *    as if by reproduction.
	 * 
	 * @param numLivingNeighbors The number of neighbors that are currently
	 *        living.
	 * @param cellCurrentlyLiving Whether the cell is currently living.
	 * 
	 * @return True if this cell is living in the next generation.    
	 */
	public static boolean isCellLivingInNextGeneration( int numLivingNeighbors, 
			boolean cellCurrentlyLiving) {

		//applies John Conway's rules in Game of Life. 
		//cells with fewer than 2 or more than 3 live neighbors die
		if ((numLivingNeighbors < 2 || numLivingNeighbors > 3) &&
				cellCurrentlyLiving == true) {
			return false;
		}

		//cells with 2 or 3 live neighbors live on to the next generation	
		if ((numLivingNeighbors == 2 || numLivingNeighbors == 3) &&
				cellCurrentlyLiving == true) {
			return true;
		}

		//dead cells with exactly 3 live neighbors become alive
		if (numLivingNeighbors == 3 && cellCurrentlyLiving == false) {
			return true;
		}

		return false;
	}

	/**
	 * Whether a specific neighbor is alive.
	 *
	 * Check whether the specific cell is alive or dead.
	 * 
	 * Note that cellRow and cellColumn may not be valid. If the cellRow is 
	 * less than 0 or greater than the number of rows -1 
	 * then the cell is outside the world. If the cellColumn is less than 0 
	 * or is greater than the number of columns -1 then 
	 * the cell is outside the world. Return false for any cell outside the 
	 * world.
	 * 
	 * @param world The current world.
	 * @param neighborCellRow The row of the cell which we are wanting to know
	 *  is alive.
	 * @param neighborCellColumn The column of the cell for which we are wanting
	 *  to know is alive.
	 * 
	 * @return Whether the cell is alive.
	 */	
	public static boolean isNeighborAlive(boolean [][]world, int neighborCellRow, 
			int neighborCellColumn) {

		//the row of the cell we want to know is alive
		if (neighborCellRow < 0 || neighborCellRow > world.length-1) {
			return false;
		}

		//the colum of the cell we want to know is alive
		if (neighborCellColumn < 0 || neighborCellColumn > world[0].length-1) {
			return false;
		}

		return world[neighborCellRow][neighborCellColumn];
	}

	/**
	 * Counts the number of neighbors that are currently living around the 
	 * specified cell.
	 *
	 * A cell has eight neighbors. The neighbors are the cells that are 
	 * horizontally, vertically and diagonally adjacent.
	 * 
	 * Note that if a specific cell is on the edge of the world then it may not 
	 * have neighboring cells.  For example: for the 0'th row (top row) of the 
	 * world there are not any rows above it.
	 * Assume all those cells are dead (have false values).
	 * 
	 * @param world The current world.
	 * @param cellRow The row of the cell for which we are looking for neighbors.
	 * @param cellColumn The column of the cell for which we are looking for 
	 * neighbors.
	 * 
	 * @return The number of neighbor cells that are currently living.
	 */
	public static int numNeighborsAlive(boolean[][] world, int cellRow, 
			int cellColumn) {

		//declare local variables
		int count = 0;

		//If the current cell is i and j then the other cells should be mapped
		//as follows:
		//[i-1,j-1][i-1,j][i-1,j+1]
		//[i,  j-1][i,  j][i,  j+1]
		//[i+1,j-1][i+1,j][i+1,j+1]

		// check left
		if (isNeighborAlive(world,cellRow, cellColumn-1)) {
			count++;
		}

		//check upper left
		if (isNeighborAlive(world,cellRow-1, cellColumn-1)) {
			count++;
		}

		//checks above
		if (isNeighborAlive(world,cellRow-1, cellColumn)) {
			count++;
		}

		//checks upper right
		if (isNeighborAlive(world,cellRow-1, cellColumn+1)) {
			count++;
		}

		//checks right
		if (isNeighborAlive(world,cellRow, cellColumn+1)) {
			count++;
		}

		// checks bottom right
		if (isNeighborAlive(world,cellRow+1, cellColumn+1)) {
			count++;
		}

		// checks bottom
		if (isNeighborAlive(world,cellRow+1, cellColumn)) {
			count++;
		}

		// checks bottom left
		if (isNeighborAlive(world,cellRow+1, cellColumn-1)) {
			count++;
		}

		return count; 
	}

	/**
	 * Determines the next generation of the world.
	 * 
	 * @param currentWorld The world currently shown. 
	 * @param newWorld The new world to determine by looking at
	 * each cells neighbors in the current world. 
	 */
	public static void nextGeneration(boolean[][] currentWorld, 
			boolean[][] newWorld) {

		//declare local variables
		boolean cellCurrentlyLiving;
		int numLivingNeighbors;
		
		//next generation of the world is determined
		for (int i = 0; i < currentWorld.length; i++) {
			for (int j = 0; j < currentWorld[i].length; j++) {
				cellCurrentlyLiving = currentWorld[i][j];
				numLivingNeighbors = numNeighborsAlive(currentWorld,i,j);

				newWorld[i][j] = isCellLivingInNextGeneration(numLivingNeighbors,
						cellCurrentlyLiving);
			}
		}
	}

	/**
	 * Prints out the world showing each cell as alive or dead.
	 * 
	 * Loops through every cell of the world. If a cell is alive, print out
	 * the Config.ALIVE character, otherwise the Config.DEAD character. 
	 * 
	 * Tracks how many cells are alive and prints out the number of cells alive
	 * or that no cells are alive.
	 * 
	 * @param patternName The name of the pattern chosen by the user. 
	 * @param world The array representation of the current world. 
	 * @param generationNum The number of the current generation.  
	 */    
	public static void printWorld(String patternName, boolean[][] world, 
			int generationNum) {

		//declare local variables
		int aliveCount = 0;

		//prints out pattern and generation
		System.out.println("\n"+ patternName + " generation: " + generationNum);

		//for every alive or dead cell
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				if (world[i][j] == true) {
					System.out.print(Config.ALIVE);
				}
				else {
					System.out.print(Config.DEAD);
				}
			}
			System.out.println();
		}
		generationNum++;

		//counts every live cell in the world array
		for (int i = 0; i < world.length; i++) {
			for (int j = 0; j < world[i].length; j++) {
				if (world[i][j] == true) {
					aliveCount++;
				}
			}
		}
		//displays the number of cells that are alive.
		System.out.println(aliveCount + " cells are alive.");
	}
}

