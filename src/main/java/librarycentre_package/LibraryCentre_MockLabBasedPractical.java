/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package librarycentre_package;

/**** ENTER HERE YOUR DETAILS:*******
         * 
         * FIRST NAME: Fridali
         * 
         * LAST NAME: Gaias 
         * 
         * STUDENT ID: w1905050
         * 
         */


public class LibraryCentre_MockLabBasedPractical {

    public static void main(String[] args) {
        
       WestminsterLibraryManager libraryCentre = new WestminsterLibraryManager(5);
    
        boolean exit = false;
        
        //run the menu until the user select exit
        while (!exit)
            exit = libraryCentre.runMenu();
    }
}
