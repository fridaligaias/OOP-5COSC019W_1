/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WestminsterLibraryManagerTest;

/**
 *
 * @author fridaligaias - TASK 06, test of addItemToList method, of WestminsterLibraryManager - tutorial week 9
 */
public class WestminsterLibraryManagerTest {
    @Test
    public void testAddItemToList(){
        //adding a book
        Book book1 = new Book ("Big Java", "123");
        book1.setAuthor("Smith");
        book1.setPublicationYear(1999);
        
        mySystem.addItemToList(book1);
        assertEquals(book1, mySystem.itemList.get(0));
        
        assertEquals(1, mySystem.itemList.size());
        
        // adding a DVD
        
        DVD dvd1 = new DVD ("The universe", "234");
        dvd1.setPublicationYear(2008);
        dvd1.setDirector("Paul Smith");
        dvd1.setGenre("Science");
        
        mySystem.addItemToList(dvd1);
        
        assertEquals(dvd1, mySystem.itemList.get(1));
        
        assertEquals(dvd1, mySystem.itemList.size());
        
    }
    
}
