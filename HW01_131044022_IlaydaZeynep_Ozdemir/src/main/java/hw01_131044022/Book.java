/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

/**
 *Book , Documenta ek olarak sayfa sayisi bilgisini tutar
 * @author ilayda
 */
public class Book extends Document{
    private int numOfPage;
/**
 * 
 * @param name
 * @param page 
 */
    public Book(String name,int page) {
        super(name);
        setNumOfPage(page);
    } 
/**
 * 
 * @param page 
 */
    public void setNumOfPage(int page) {
        this.numOfPage = page;
    }
/**
 * 
 * @return 
 */
    public int getNumOfPage() {
        return numOfPage;
    }
    
}
