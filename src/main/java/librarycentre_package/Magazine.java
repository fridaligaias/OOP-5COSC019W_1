/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarycentre_package;

/**
 *
 * @author fridaligaias - 18/11
 */
public class Magazine extends Item {
    // variables
    private int issue_num;
    private String pub_freq;
    private String editor;
    
    // constructor
    public Magazine(String title, String ISBN) {
        super(title, ISBN);
    }
    
    // getters and setters
    public int getIssue_num() {
        return issue_num;
    }

    public void setIssue_num(int issue_num) {
        this.issue_num = issue_num;
    }
    
    public String getPub_freq(){
        return pub_freq;
    }

    public void setPub_freq(String pub_freq) {
        this.pub_freq = pub_freq;
    }
    
    public String getEditor(){
        return editor;
    }
    
    public void setEditor(String editor){
        this.editor = editor;
    }
    
    // toString
    @Override
    public String toString(){
        return super.toString() + " Issue Number " + issue_num + "\n Publication Frequency " + pub_freq + "\n Editor " + editor;
    }
}
