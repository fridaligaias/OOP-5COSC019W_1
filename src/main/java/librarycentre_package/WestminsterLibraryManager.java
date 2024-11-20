/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycentre_package;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections; //TASK 03


public class WestminsterLibraryManager implements LibraryManager {
    
    // ArrayLists
    private ArrayList<Item> itemList;
    private int item_limit;
    
    public WestminsterLibraryManager(int maxItemNumber){
        itemList = new ArrayList<Item>();
        item_limit = maxItemNumber;
    }

    @Override
    public boolean runMenu() {
         boolean exit = false; // Exit flag
        
        // Run console menu
        System.out.println("\n-- WESTMINSTER LIBRARY MANAGER CONSOLE MENU--");
        
        System.out.println("To save and exit, press 0");
        
        System.out.println("To Add a new item, press 1");
        
        System.out.println("To Display the list of item press 2");
        
        System.out.println("To Open GUI, press 3");
        
        System.out.println("To edit the Title of an Item, press 4");
        
        

        
        // Switch based on selected option
        Scanner s = new Scanner(System.in);
        int choice;
        choice = s.nextInt();

        
        switch(choice){
            
             // Exit
            case 0:
                exit = true;
                break;
            
            // Add staff member
            case 1:
                this.addItem();
                break;
            // Print staff members
            case 2:
                this.displayItems();
                break;
            
            // GUI
            case 3:
                this.runGUI();
                break;
                
            // editTitle, TASK 02, 07
            case 4:
                this.editTitleItem();
                break;
           
        }
        
        return exit;
    }

    @Override
    public void addItem() {
        Scanner s = new Scanner (System.in);
        
        if(itemList.size() < item_limit){
            System.out.println("Press 1 if you want to add a Book");
            System.out.println("Press 2 if you want to add a DVD");
            
            int choiceItem = s.nextInt();
            s.nextLine();
            
            //common questions
            System.out.println("Enter the Title");
            String title = s.nextLine();
            
            System.out.println("Enetr the ISBN");
            String isbn = s.nextLine();
            
            System.out.println("Enter the publication year ");
            int year = s.nextInt();
            s.nextLine();
            
            // check if the item is a book or a dvd
            switch(choiceItem){
                case 1:
                    // it is a book
                    System.out.println("Enter the author's name");
                    String author = s.nextLine();
                    
                    // create a new book and add to the list
                    Book book = new Book(title, isbn);
                    book.setAuthor(author);
                    book.setPublicationYear(year);
                   
                    this.addItemToList(book);
                    
                    break;
                    
                case 2:
                    //it is a dvd
                    System.out.println("Enter the genre");
                    String genre = s.nextLine();

                    System.out.println("Enter the director's name");
                    String director = s.nextLine();
                    
                    // create a new receptionist and add to the list
                    DVD dvd = new DVD(title, isbn);
                    dvd.setGenre(genre);
                    dvd.setDirector(director);
                    dvd.setPublicationYear(year);
                    
                    this.addItemToList(dvd);
                    break;
            }
            
        }
        else {
            System.out.println("No more space in the system");
        }
    }
    
    public void addItemToList(Item item){
        
        //check if there are space avilable
        if(this.itemList.size() < item_limit) {
            itemList.add(item);
        }
        else{
            System.out.println("No more space in teh list");
        }
    }

    @Override
    public void displayItems() {
        //sorting , TASK 03
        Collections.sort(itemList);
        
        if (!itemList.isEmpty()){

        
            for(Item item : itemList) {
                // print the type of item and the the description
                if(item instanceof Book)
                    System.out.print("BOOK - ");
                else if (item instanceof DVD)
                    System.out.print("DVD - ");
                //add here teh code if you added teh class Megazine
                else if (item instanceof Magazine)
                    System.out.print("Magazine - ");
                
                System.out.println(item.toString());
            }
        }
        else{
            System.out.println("There are no items in the system.");
        }
    }

    @Override
    public void runGUI() {
        ItemTableGUI table = new ItemTableGUI(itemList);
        table.setVisible(true);
    }
    
    // TASK 02
    @Override
    public void editTitleItem(){
        Scanner s = new Scanner (System.in);
        //ask to instert the ISBN
        System.out.println("Enter the ISBN: ");
        String isbn = s.nextLine(); // T02.03
        
        boolean found = false;
        
        if(!itemList.isEmpty()){
            for(int i =0; i < itemList.size(); i++){
                if(isbn.equals(itemList.get(i).getISBN())){
                    found = true;
                    //item is found and info will be printed in the screen
                    if(itemList.get(i) instanceof Book){
                        System.out.println("Book - ");
                    } else if (itemList.get(i) instanceof DVD){
                        System.out.println("DVD - ");
                    } else if (itemList.get(i) instanceof Magazine){
                        System.out.println("Magazine - ");
                    }
                    
                    System.out.println("Title: "+ itemList.get(i).getTitle()+ ", publication year: " + itemList.get(i).getPublicationYear());
                    
                    //asking the new title
                    System.out.println("Please enter the new Title");
                    String newTitle = s.nextLine();
                    
                    //set the new title
                    itemList.get(i).setTitle(newTitle);
                    System.out.println("The new title has been saved");
                }
            
            }
            if (!found){
                System.out.println("No ISBN found!");
            }
        } else {
            System.out.println("There are no items in the system!");
        }
        
    }
    
}
