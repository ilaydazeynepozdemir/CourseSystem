/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw01_131044022;

/**
 *
 * @author ilayda
 */
public class File extends Document {

    int size;

    /**
     * no parameter constructor
     */
    public File() {
        super();
        setSize(10);
    }

    /**
     * constructor
     *
     * @param name file adi
     */
    public File(String name) {
        super(name);
    }
    
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getSize() {
        return size;
    }
    
}
