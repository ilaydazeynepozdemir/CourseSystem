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
public class WhiteBoardDescription extends Document {
    String description;

    /**
     *constructor 
     */
    public WhiteBoardDescription() {
        super();
        setDescription("");
    }

    /**
     *constructor
     * @param name 
     */
    public WhiteBoardDescription(String name,String takenDescription) {
        super(name);
        setDescription(takenDescription);
    }

    public void setDescription(String givenDescription) {
        this.description = givenDescription;
    }

    public String getDescription() {
        return description;
    }
/**
 * description
 * @return 
 */
    @Override
    public String toString() {
        return getDescription();
    }
    
    
    
    

}
