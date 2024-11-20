/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycentre_package;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author b.villarini
 */
public class ItemTableModel extends AbstractTableModel{
    
    
    private String[] columnNames = {"Title", "ISBN", "Year", "Type"}; // TASK 04, add column
    private ArrayList<Item> itemList; 
    
    public ItemTableModel(ArrayList<Item> itemList){
        this.itemList = itemList;
    }

    @Override
    public int getRowCount() {
        return itemList.size();   
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    // edit below for taks 04
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object temp = null; 
        if (columnIndex == 0) { 
         temp = itemList.get(rowIndex).getTitle(); 
      } 
        else if (columnIndex == 1) { 
         temp = itemList.get(rowIndex).getISBN(); 
      } 
      else if (columnIndex == 2) { 
         temp = itemList.get(rowIndex).getPublicationYear(); 
      } 
        
        // adding fourth column, task 04
        
      else if (columnIndex == 3){
          //checking the type and assign to the temp variable that will be shown on the table
          if (itemList.get(rowIndex) instanceof Book)
              temp="Book";
          else if (itemList.get(rowIndex) instanceof DVD)
              temp = "DVD";
          else if (itemList.get(rowIndex) instanceof Magazine)
              temp = "Magazine";
      }
        
      return temp; 
        
    }
    
    // needed to show column names in JTable 
   public String getColumnName(int col) { 
      return columnNames[col]; 
   } 
    
}
