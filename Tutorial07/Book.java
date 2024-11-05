
package com.mycompany.practicetutorial07;


public class Book implements Comparable<Book> {
    // variables
    private String title;
    private double price;
    private int year;
    private String author;
    
    // constructor
    public Book(String title, int year, String author){
        this.title = title;
        this.year = year;
        this.author = author;
    }
    
    // define setters
    
    public void setTitle(String title){
        this.title = title;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    
    // define getters
    
    public String getTitle(){
        return title;
    }
    public double getPrice(){
        return price;
    }
    public int getyear(){
        return year;
    }
    public String getAuthor(){
        return author;
    }
    
    // toString() method for info about book
    
    public String toString(){
        return " " + title + " || Price: " + price + " | Year Published: " + year + " | Author: " + author;
    }
    
    public int compareTo(Book b){
        return this.year = b.getyear();
    }
}
