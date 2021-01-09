/*
* This program uses recursion to find all the magic squares of 15 in java.
*
* @author  Douglass Jeffrey
* @version 1.0
* @since   2021-01-08
* Class MagicSquare.
*/

class MagicSquare {

  /**
   * Recursive function runs through all possible random numbers with 9 digits
   * and picks out all the numbers with more than 1 instance
   * of the same number.
   */
  public static String magicTest(int [] magicBox, int locationVal) {

    /* nested for loops to run through every number. I would have used nested
     * recursive statements instead but I ended up getting stack overflows
     * having to do with the fact that there are 300,000,000 possible numbers
     * which took up way to much storage and crashed my ide.
     */
    for (int counter1 = 1; counter1 <= 9; counter1++) {
      for (int counter2 = 1; counter2 <= 9; counter2++) {
        for (int counter3 = 1; counter3 <= 9; counter3++) {
          for (int counter4 = 1; counter4 <= 9; counter4++) {
            for (int counter5 = 1; counter5 <= 9; counter5++) {
              for (int counter6 = 1; counter6 <= 9; counter6++) {
                for (int counter7 = 1; counter7 <= 9; counter7++) {
                  for (int counter8 = 1; counter8 <= 9; counter8++) {
                    
                    // sets counters to array values
                    magicBox[0] = locationVal;
                    magicBox[1] = counter1;
                    magicBox[2] = counter2;
                    magicBox[3] = counter3;
                    magicBox[4] = counter4;
                    magicBox[5] = counter5;
                    magicBox[6] = counter6;
                    magicBox[7] = counter7;
                    magicBox[8] = counter8;
                    
                    /* 
                    * eliminates all numbers with more than one instance of the 
                    * same number.
                    */
                    if (locationVal != counter1 && locationVal != counter2
                        && locationVal != counter3 && locationVal != counter4 
                        && locationVal != counter5 && locationVal != counter6 
                        && locationVal != counter7 && locationVal != counter8
                        && counter1 != counter2 && counter1 != counter3
                        && counter1 != counter4 && counter1 != counter5
                        && counter1 != counter6 && counter1 != counter7
                        && counter1 != counter8 && counter2 != counter3 
                        && counter2 != counter4 && counter2 != counter5 
                        && counter2 != counter6 && counter2 != counter7 
                        && counter2 != counter8 && counter3 != counter4
                        && counter3 != counter5 && counter3 != counter6
                        && counter3 != counter7 && counter3 != counter8
                        && counter4 != counter5 && counter4 != counter6 
                        && counter4 != counter7 && counter4 != counter8
                        && counter5 != counter6 && counter5 != counter7
                        && counter5 != counter8 && counter6 != counter7
                        && counter6 != counter8 && counter7 != counter8) {
            
                      // checks is magic box to determine if its a magic box
                      if (isMagic(magicBox) == true) {
                        // Printing out the square that was found
                        printMagicSquare(magicBox);
                      }

                      // debugging tool to print all numbers
                      /*
                       *System.out.println(magicBox[0] + ", " + magicBox[1] 
                       *                  + ", " + magicBox[2] + ", " 
                       *                  + magicBox[3] + ", " + magicBox[4] 
                       *                  + ", " + magicBox[5] + ", " 
                       *                  + magicBox[6] + ", " + magicBox[7] 
                       *                  + ", " + magicBox[8]);
                       */
                    }
                  }
                }
              }
            }
          }
        }
      }
    }

    if (locationVal == 9) {
      return ("complete");
    }
    return (magicTest(magicBox, (locationVal + 1)));
  }

  /**
   * function to check if square is magic.
   */
  public static boolean isMagic(int[] possibleSquare) {
    // returns true or false for whether or not inputted array is a magic square
    int magicnum = 15;
    int row1 = possibleSquare[0] + possibleSquare[1] + possibleSquare[2];
    int row2 = possibleSquare[3] + possibleSquare[4] + possibleSquare[5];
    int row3 = possibleSquare[6] + possibleSquare[7] + possibleSquare[8];
    int col1 = possibleSquare[0] + possibleSquare[3] + possibleSquare[6];
    int col2 = possibleSquare[1] + possibleSquare[4] + possibleSquare[7];
    int col3 = possibleSquare[2] + possibleSquare[5] + possibleSquare[8];
    int diag1 = possibleSquare[0] + possibleSquare[4] + possibleSquare[8];
    int diag2 = possibleSquare[2] + possibleSquare[4] + possibleSquare[6];

    if (row1 == magicnum && row2 == magicnum && row3 == magicnum
        && col1 == magicnum && col2 == magicnum && col3 == magicnum
        && diag1 == magicnum && diag2 == magicnum) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * function used to print out the found magic square.
   */
  public static void printMagicSquare(int[] outputSquare) {
    // prints inputted array in a magic square format
    System.out.println("\n*****");
    for (int count = 0; count < outputSquare.length; count++) {
      if (count == 3 || count == 6) {
        System.out.println();
        System.out.print(outputSquare[count] + " ");
      } else {
        System.out.print(outputSquare[count] + " ");
      }
    }
    System.out.println("\n*****");
  }

  /**
   * main function to begin the game.
   */
  public static void main(String[] args) {
    // sets initial values of all 9 segments
    int[] magicBox = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    // sets value of recursive 
    int locationVal = 1;
    // calls magictest function
    magicTest(magicBox, locationVal);
  }
}
