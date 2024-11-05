
package com.mycompany.practicetutorial07;
import java.util.*;
import java.util.Collections;

public class PracticeTutorial07 {
    public static void main(String[] args) {
        ArrayList<Book> bookList =  new ArrayList<Book>();
        
        Scanner s = new Scanner(System.in);
        
        Map<Book, Integer>hmap = new HashMap<Book, Integer>();
        boolean exit = false;
        while (!exit){
            System.out.println("Press 1 if you want to add a book.");
            System.out.println("Press 2 if you want to print the list of books sorted by year.");
            System.out.println("Press 3 if you want to map all books into shelves.");
            System.out.println("Press 4 if you want to print the list of books on a specific shelf.");
            System.out.println("Press 5 if you want to EXIT.");
            
            int choice = s.nextInt();
            s.nextLine();
            
            switch(choice){
                case 1:
                    System.out.println("Please insert the title of the book");
                    String title = s.nextLine();
                    
                    System.out.println("Please insert the author of the book");
                    String author = s.nextLine();
                    
                    System.out.println("Please insert the year of the book");
                    int year = s.nextInt();
                    
                    System.out.println("Please insert the price of the book");
                    double price = s.nextDouble();
                    
                    Book book = new Book (title, year, author);

                    
                    //add book to booklist array
                    book.setPrice(price);
                    bookList.add(book);
                    break;
                case 2:
                    Collections.sort(bookList);
                    for (int i=0; i<bookList.size(); i++){
                        System.out.println(bookList.get(i).toString());
                    }
                    break;
                case 3:
                    for(int j=0;j<bookList.size();j++){
                        System.out.println("Please enter the shelf number for the book " + bookList.get(j).getTitle());
                        int numShelf = s.nextInt();
                        hmap.put(bookList.get(j), numShelf);
                    }
                    break;
                case 4:
                    System.out.println("Enter the number of the shelf");
                    int selectedShelf = s.nextInt();
                    s.nextLine();
                    System.out.println("The book(s) is in shelf "+ selectedShelf+ " are: ");
                    
                    // Using entrySet() to iterate over the HashMap
                    for (Map.Entry<Book, Integer> entry: hmap.entrySet()){
                        if(entry.getValue().equals(selectedShelf)){
                            System.out.println(entry.getKey());
                        }
                    }
                    break;
                case 5:
                    exit = true;
                    break;
                    
            }
        }
    }
    
}
