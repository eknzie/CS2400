/*-------------------------------------------------------------
// AUTHOR: Kenzie Lam
// FILENAME: Lab 4
// SPECIFICATION: This program will take in user input and produce different patterns according to user input
// FOR: CS 1400- Lab #4
// TIME SPENT: 45 minutes
//-----------------------------------------------------------*/

import java.util.Scanner;

public class Lab4 {

    public static void main(String[] args) {
        final char SIDE_SYMB = '-';
        final char MID_SYMB = '*';
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        char choice = ' ';
        int numSymbols = -1, sideWidth = -1, midWidth = -1;

        do {
            displayMenu();
            inputStr = scanner.next();
            if (inputStr.length() > 0) {
                choice = inputStr.charAt(0);
            }

            switch (choice) {
            case 'r':
                System.out.println("Width of the sides: ");
                sideWidth = scanner.nextInt();
                System.out.println("Width of the middle: ");
                midWidth = scanner.nextInt();

                System.out.println();
                System.out.print(buildRow(SIDE_SYMB, sideWidth, MID_SYMB, midWidth));

                break;
            case 'p':
                System.out.println("Number of symbols on the lowest layer: ");
                numSymbols = scanner.nextInt(); 

                System.out.println();
                System.out.print(buildPyramid(SIDE_SYMB, MID_SYMB, numSymbols));

                break;   
            case 'd':
                System.out.println("Number of symbols on the middle layer: ");
                numSymbols = scanner.nextInt(); 

                System.out.println();
                System.out.print(buildDiamond(SIDE_SYMB, MID_SYMB, numSymbols));

                break;
            case 'q':
                System.out.println("Bye");
                break;
                
            default:
                System.out.println("Please choose a valid option from the menu.");
                break;
            }
            System.out.println();
        } while (choice != 'q');
        
        scanner.close();

    } // End of main
    //hiiii
    
    /**
     * Build a row of symbols (pattern) with the given parameters. 
     *
     * For example, -----*****----- can be built by the parameters
     *
     * sideWidth = 5, midWidth = 5, sideSymb = '-', midSymb = '*'
     * 
     * @param sideSymb  A char to be repeated on both sides
     * @param sideWidth Number of symbols on each side
     * @param midSymb   A char to be repeated in the middle
     * @param midWidth  Number of symbols in the middle
     * @return          A String of a row of the designed pattern end with \n
     */
    public static String buildRow(
        char sideSymb, int sideWidth, char midSymb, int midWidth) {

        String result = "";

        // YOUR CODE HERE
        // Make one side
        // -->
        String side = "";
        for (int i = 0; i < sideWidth; i++) {
        	side += sideSymb;
        }
        // Make the middle part
        // -->
        String middle = "";
        for (int i = 0; i < midWidth; i++) {
        	middle += midSymb;
        }
        // Combine side + middle + side + \n, save into "result"
        // -->
        result = side + middle + side + "\n";

        return result;
    }  // End of buildRow

    /**
     * Build a pyramid pattern with the given parameters.
     *
     * For example, the following pattern
     *
     *  -----*-----
     *  ----***----
     *  ---*****---
     *  --*******--
     *  -*********-
     *  ***********
     *
     * can be built by sideSymb = '-', midSymb = '*', numSymbols = 11
     *
     * When ptnHeight is not an odd integer, replace it by the closest
     * even integer below. For example, if numSymbols is 10, use 9 instead.
     * 
     * When ptnHeight is 0, return an empty String.
     * 
     * @param  sideSymb   A char to be repeated on both sides
     * @param  midSymb    A char to be repeated in the middle
     * @param  numSymbols The number of symbols on the lowest layer
     * @return            A String of the pyramid pattern.
     */
    public static String buildPyramid(
        char sideSymb, char midSymb, int numSymbols) {

        String result = "";
        int sideWidth = -1, midWidth = -1;

        // YOUR CODE HERE
        
        // If numSymbols is 0, return an empty string
        // -->
        if (numSymbols < 1) return "";
        // If numSymbols is not an odd number, find the
        // odd number less than numSymbols and replace it
        // -->
        if (numSymbols % 2 == 0) numSymbols--;
        // Make a loop to iterate the pyramid's levels
        for (int i = 0; i < numSymbols / 2 + 1; i++) {
            // Compute the number of middle symbols
            // -->
            String middle = "";
            for(int j = 0; j < 1+2*i; j++) {
            	middle += midSymb;
            }
            // Compute the number of symbols on one side
            // -->
            String side = "";
            for(int j = i; j < numSymbols / 2 ; j++) {
            	side += sideSymb;
            }
            // Use the "buildRow" method to make a row, then
            // add the row to the variable "result".
            // -->
            result += side+middle+side+"\n";
        }

        return result;
    }

    // /**
    //  * Build a diamond pattern. The parameters are the same 
    //  * as {@link #buildPyramid(char, char, int)}.
    //  * 
    //  * @param  sideSymb  A char to be repeated on both sides
    //  * @param  midSymb   A char to be repeated in the middle
    //  * @param  numSymbols The height of a pyramid
    //  * @return           A String of the inverted diamond pattern.
    //  */
    public static String buildDiamond(char sideSymb, char midSymb, int numSymbols) {
    	String result = "";
    	String side = "";
    	String middle = "";
    	if (numSymbols % 2 == 0) numSymbols--;
    	for (int i = 0; i < numSymbols; i++) {
    		if (i < numSymbols / 2) {
    			for (int j = i; j < numSymbols / 2; j++) {
    				side += sideSymb;
    			}
    			for (int j = 0; j < 1+2*i; j++) {
    				middle += midSymb;
    			}
    			result += side + middle + side +"\n";
    		}else {
    			int tmp = i - numSymbols/2;
    			for (int j = 0; j < tmp; j++) {
    				side += sideSymb;
    			}
    			for (int j = tmp*2; j < numSymbols; j++) {
    				middle += midSymb;
    			}
    			result += side + middle + side +"\n";
    		}
    		side = "";
    		middle = "";
    	}
    	return result;
    }

    /**
     * Display the menu
     */
    public static void displayMenu() {
        System.out.println("Please choose one pattern from the list");
        System.out.println("r) Row");
        System.out.println("p) Pyramid");
        System.out.println("d) Diamond");
        System.out.println("q) Quit");
    }  // End of displayMenu

}  // End of Lab 4 class
